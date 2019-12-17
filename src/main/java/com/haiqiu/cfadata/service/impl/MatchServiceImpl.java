package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.*;
import com.haiqiu.cfadata.doentity.*;
import com.haiqiu.cfadata.poentity.*;
import com.haiqiu.cfadata.service.MatchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by peanut on 2019/6/5 上午11:30
 */
@Service
public class MatchServiceImpl implements MatchService {
    private static Logger logger = LoggerFactory.getLogger(MatchServiceImpl.class);
    @Autowired
    private MatchPOMapper matchPOMapper;
    @Autowired
    private MatchResultPOMapper matchResultPOMapper;
    @Autowired
    private MatchEventPOMapper matchEventPOMapper;
    @Autowired
    private MatchResultAtPOMapper matchResultAtPOMapper;
    @Autowired
    private TeamPOMapper teamPOMapper;
    @Autowired
    private TeamPersonPOMapper teamPersonPOMapper;
    @Autowired
    private PersonPOMapper personPOMapper;
    @Autowired
    private SeasonPOMapper seasonPOMapper;
    @Autowired
    private RoundPOMapper roundPOMapper;
    @Autowired
    private CompetitionPOMapper competitionPOMapper;
    @Autowired
    private MatchLineUpPOMapper matchLineUpPOMapper;

    @Override
    public MatchDO match(Integer maId) {
        MatchDO matchDO = null;
        MatchDO.MatchBean matchBean = new MatchDO.MatchBean();
        TeamDO awayBean = new TeamDO();
        TeamDO homeBean = new TeamDO();
        MatchDO.MatchBean.RoundBean roundBean = new MatchDO.MatchBean.RoundBean();
        MatchDO.MatchBean.MatchResultBean matchResultBean = new MatchDO.MatchBean.MatchResultBean();
        MatchDO.MatchBean.MatchEventBean matchEventBean = new MatchDO.MatchBean.MatchEventBean();
        MatchDO.MatchBean.MatchEventBean.PersonBean personBean = new MatchDO.MatchBean.MatchEventBean.PersonBean();
        MatchDO.MatchBean.MatchEventBean.PersonBean additionalPersonBean = new MatchDO.MatchBean.MatchEventBean.PersonBean();
        MatchDO.MatchBean.MatchEventBean.TeamBean teamBean = new MatchDO.MatchBean.MatchEventBean.TeamBean();
        MatchDO.MatchBean.MatchEventBean.TeamPersonBean teamPersonBean = new MatchDO.MatchBean.MatchEventBean.TeamPersonBean();
        MatchDO.MatchBean.RoundBean.SeasonBean seasonBean = new MatchDO.MatchBean.RoundBean.SeasonBean();
        MatchDO.MatchBean.RoundBean.SeasonBean.CompetitionBean competitionBean = new MatchDO.MatchBean.RoundBean.SeasonBean.CompetitionBean();


        List<MatchDO.MatchBean.MatchEventBean> matchEventBeans = new ArrayList<>();
        List<MatchDO.MatchBean.MatchResultBean> matchResultBeans = new ArrayList<>();


        MatchPO matchPO = matchPOMapper.selectByPrimaryKey(maId);

        if (matchPO != null) {
            //格式化时间
            SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat sdfprasetime = new SimpleDateFormat("HH:mm:ss");


            matchBean = new MatchDO.MatchBean();

            if (matchPO.getId() != null) {
                matchBean.setId(String.valueOf(matchPO.getId()));
            }
            if (matchPO.getRoundId() != null) {
                matchBean.setRound_id(String.valueOf(matchPO.getRoundId()));
            }
            if (matchPO.getMatchday() != null) {
                matchBean.setMatchday(String.valueOf(matchPO.getMatchday()));
            } else {
                matchBean.setMatchday("0");
            }
            if (matchPO.getGroupMatchday() != null) {
                matchBean.setGroup_matchday(String.valueOf(matchPO.getGroupMatchday()));
            }
            if (matchPO.getMatchDate() != null) {
                matchBean.setMatch_date(sdfprase.format(matchPO.getMatchDate()));
                matchBean.setMatch_time(sdfprasetime.format(matchPO.getMatchDate()));
            }
//            if (matchPO.getMatchTime() != null) {
//                matchBean.setMatch_time(matchPO.getMatchTime());
//            }
            if (matchPO.getFinished() != null) {
                matchBean.setFinished(matchPO.getFinished());
            }
            if (matchPO.getLiveStatus() != null) {
                matchBean.setLive_status(matchPO.getLiveStatus());
            }
//            比赛时长
            matchBean.setCurrent_minute("90");
            //       若是比赛结束 当前节填入 game-end,比赛获胜队伍填入获胜队伍  WinnerTeamId默认值为0
            if ("yes".equals(matchPO.getFinished())) {
                if (matchPO.getWinnerTeamId() != null) {
                    matchBean.setWinner_team_id(String.valueOf(matchPO.getWinnerTeamId()));
                } else {
                    matchBean.setWinner_team_id("0");
                }
                matchBean.setCurrent_period("game-end");
            } else {
                matchBean.setWinner_team_id("0");
            }
            RoundPO roundPO = roundPOMapper.selectByPrimaryKey(matchPO.getRoundId());
            if (roundPO != null) {
                roundBean = new MatchDO.MatchBean.RoundBean();
                roundBean.setId(String.valueOf(roundPO.getId()));
                roundBean.setName(roundPO.getName());
                //round 中的 season
                seasonBean = new MatchDO.MatchBean.RoundBean.SeasonBean();
                SeasonPO seasonPO = seasonPOMapper.selectByPrimaryKey(roundPO.getSeasonId());
                if (seasonPO != null) {
                    seasonBean.setId(String.valueOf(seasonPO.getId()));
                    seasonBean.setName(seasonPO.getName());
//season中的competition
                    competitionBean = new MatchDO.MatchBean.RoundBean.SeasonBean.CompetitionBean();
                    CompetitionPO competitionPO = competitionPOMapper.selectByPrimaryKey(seasonPO.getCompetitionId());
                    if (competitionPO != null) {
                        competitionBean.setGender(competitionPO.getGender());
                        competitionBean.setId(String.valueOf(competitionPO.getId()));
                        competitionBean.setName(competitionPO.getName());
                        competitionBean.setType(competitionPO.getType());

                        seasonBean.setCompetition(competitionBean);
                    }
                    roundBean.setSeason(seasonBean);
                }
                matchBean.setRound(roundBean);
            }
//        比赛事件
            List<MatchEventPO> matchEventPOs = matchEventPOMapper.selectByMaId(maId);
            if (matchEventPOs != null && matchEventPOs.size() != 0) {
                for (MatchEventPO matchEventPO : matchEventPOs) {
                    matchEventBean = new MatchDO.MatchBean.MatchEventBean();
                    matchEventBean.setId(String.valueOf(matchEventPO.getId()));
                    matchEventBean.setAction(matchEventPO.getAction());
                    matchEventBean.setKind(matchEventPO.getKind());
                    if (matchEventPO.getMinute() != null) {
                        matchEventBean.setMinute(String.valueOf(matchEventPO.getMinute()));
                    }
                    if (matchEventPO.getTeamId() != null) {
                        TeamPO teampo = teamPOMapper.selectByPrimaryKey(matchEventPO.getTeamId());
                        if (teampo != null) {
                            teamBean = new MatchDO.MatchBean.MatchEventBean.TeamBean();
                            teamBean.setId(String.valueOf(teampo.getId()));
                            teamBean.setName(teampo.getName());
                            teamBean.setShow_team(teampo.getShowTeam());
                            matchEventBean.setTeam(teamBean);
                        }
                    }
//person
                    if (matchEventPO.getPersonId() != null) {
                        PersonPO personPO = personPOMapper.selectByPrimaryKey(matchEventPO.getPersonId());
                        if (personPO != null) {
                            personBean = new MatchDO.MatchBean.MatchEventBean.PersonBean();
                            personBean.setId(String.valueOf(personPO.getId()));
                            if (personPO.getHeight() != null) {
                                personBean.setHeight(String.valueOf(personPO.getHeight()));
                            }
                            if (personPO.getWeight() != null) {
                                personBean.setWeight(String.valueOf(personPO.getWeight()));
                            }
                            if (personPO.getBirthday() != null) {
                                personBean.setBirthday(sdfprase.format(personPO.getBirthday()));
                            }
                            BeanUtils.copyProperties(personPO, personBean);
                            matchEventBean.setPerson(personBean);
                        }
                    }
//additional  person
                    if (matchEventPO.getAdditionalPersonId() != null) {
                        PersonPO additionalPe = personPOMapper.selectByPrimaryKey(matchEventPO.getAdditionalPersonId());
                        if (additionalPe != null) {
                            additionalPersonBean = new MatchDO.MatchBean.MatchEventBean.PersonBean();
                            additionalPersonBean.setId(String.valueOf(additionalPe.getId()));
                            if (additionalPe.getHeight() != null) {
                                additionalPersonBean.setHeight(String.valueOf(additionalPe.getHeight()));
                            }
                            if (additionalPe.getWeight() != null) {
                                additionalPersonBean.setWeight(String.valueOf(additionalPe.getWeight()));
                            }
                            if (additionalPe.getBirthday() != null) {
                                additionalPersonBean.setBirthday(sdfprase.format(additionalPe.getBirthday()));
                            }
                            BeanUtils.copyProperties(additionalPe, additionalPersonBean);
                            matchEventBean.setAdditional_person(additionalPersonBean);
                        }
                    }
                    if (matchEventPO.getTeamPersonId() != null) {
                        TeamPersonPO teamPersonPO = teamPersonPOMapper.selectByPrimaryKey(matchEventPO.getTeamPersonId());
                        if (teamPersonPO != null) {
                            teamPersonBean = new MatchDO.MatchBean.MatchEventBean.TeamPersonBean();
                            teamPersonBean.setId(String.valueOf(teamPersonPO.getId()));
                            teamPersonBean.setShirtnumber(teamPersonPO.getShirtnumber());
                            matchEventBean.setTeam_person(teamPersonBean);
                        }
                    }
                    matchEventBeans.add(matchEventBean);
                }

            }
            matchBean.setMatch_event(matchEventBeans);

//team  主队和客队
            TeamPO home = teamPOMapper.selectByPrimaryKey(matchPO.getHomeId());
            if (home != null) {
                homeBean = new TeamDO();
                homeBean.setId(String.valueOf(home.getId()));
                homeBean.setName(home.getName());
                homeBean.setShow_team(home.getShowTeam());
                matchBean.setHome(homeBean);
            }

            TeamPO away = teamPOMapper.selectByPrimaryKey(matchPO.getAwayId());
            if (away != null) {
                awayBean = new TeamDO();
                awayBean.setId(String.valueOf(away.getId()));
                awayBean.setName(away.getName());
                awayBean.setShow_team(away.getShowTeam());
                matchBean.setAway(awayBean);
            }

//比赛结果 每场比赛主客队各三个结果
            List<MatchResultPO> matchResultPOs = matchResultPOMapper.selectByMaId(maId);
            if (matchResultPOs != null && matchResultPOs.size() != 0) {
                for (MatchResultPO matchResultPO : matchResultPOs) {
                    matchResultBean = new MatchDO.MatchBean.MatchResultBean();
                    if (matchResultPO.getMatchResult() != null) {
                        matchResultBean.setMatch_result(String.valueOf(matchResultPO.getMatchResult()));
                    }
                    if (matchResultPO.getMatchResultAt() != null) {
                        matchResultBean.setMatch_result_at(String.valueOf(matchResultPO.getMatchResultAt()));
                    }
                    matchResultBean.setPlace(matchResultPO.getPlace());
                    matchResultBeans.add(matchResultBean);
                }
            }
            matchBean.setMatch_result(matchResultBeans);
            matchDO = new MatchDO();
            matchDO.setMatch(matchBean);
//matchResultAt 固定值  4个
            List matchResultAtBeans = matchResultAtPOMapper.selectAll();
            matchDO.setMatch_result_at(matchResultAtBeans);
            return matchDO;
        } else {
            logger.error("match接口异常！maId:{}", maId);
            return null;
        }
    }

    @Override
    public MatchesBySeasonsDO matchesBySeasons(Integer seId, String lm) {
        MatchesBySeasonsDO matchesBySeasonsDO = null;
        List<RoundPO> roundPOs = new ArrayList<>();
        Date currentRoDate = null;
        MatchesBySeasonsDO.RoundBean.MatchBean matchBean = new MatchesBySeasonsDO.RoundBean.MatchBean();
        MatchesBySeasonsDO.RoundBean roundBean = new MatchesBySeasonsDO.RoundBean();
        TeamDOForSeason awayBean = new TeamDOForSeason();
        TeamDOForSeason homeBean = new TeamDOForSeason();
        List<MatchesBySeasonsDO.RoundBean.MatchBean> matchBeans = new ArrayList<>();
        List<MatchesBySeasonsDO.RoundBean> roundBeans = new ArrayList<>();

        SeasonPO seasonPO = seasonPOMapper.selectByPrimaryKey(seId);
        if (seasonPO != null) {
            matchesBySeasonsDO = new MatchesBySeasonsDO();
            SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");
            SimpleDateFormat sdfprasetime = new SimpleDateFormat("hh:mm:ss");

            //根据season查询出所有的round
            List<Integer> roundIds = roundPOMapper.selectBySeId(seId);
            if (roundIds != null && roundIds.size() != 0) {
                roundBeans = new ArrayList<>();
                for (Integer roundId : roundIds) {
                    roundBean = new MatchesBySeasonsDO.RoundBean();
                    RoundPO roundPO = roundPOMapper.selectByPrimaryKey(roundId);
                    if (roundPO != null) {
                        roundBean.setCurrent_matchday("0");
                        roundBean.setId(String.valueOf(roundId));
                        roundBean.setName(roundPO.getName());
                        roundBean.setSeason_id(String.valueOf(seId));
                        //根据round查询出所有的比赛  过滤修改时间
                        List<MatchPO> matchPOs = null;
                        if (lm != null) {
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                            try {
                                matchPOs = matchPOMapper.selectByRoAndLm(roundId, sdf.parse(lm));
                            } catch (ParseException e) {
                                e.printStackTrace();
                            }

                        } else {
                            matchPOs = matchPOMapper.selectByRoId(roundId);
                        }

                        if (matchPOs != null && matchPOs != null) {
                            matchBeans = new ArrayList<>();
                            for (MatchPO matchPO : matchPOs) {
                                matchBean = new MatchesBySeasonsDO.RoundBean.MatchBean();
                                matchBean.setFinished(matchPO.getFinished());
                                matchBean.setId(String.valueOf(matchPO.getId()));
                                if (matchPO.getMatchDate() != null) {
                                    matchBean.setMatch_date(sdfprase.format(matchPO.getMatchDate()));
                                    matchBean.setMatch_time(sdfprasetime.format(matchPO.getMatchDate()));
                                }

                                TeamPO away = teamPOMapper.selectByPrimaryKey(matchPO.getAwayId());
                                if (away != null) {
                                    awayBean = new TeamDOForSeason();
                                    awayBean.setId(String.valueOf(away.getId()));
                                    awayBean.setName(away.getName());
                                    awayBean.setShow_team(away.getShowTeam());
                                    awayBean.setType(away.getType());
                                    awayBean.setGender(away.getGender());
                                    matchBean.setAway(awayBean);
                                }

                                TeamPO home = teamPOMapper.selectByPrimaryKey(matchPO.getHomeId());
                                if (home != null) {
                                    homeBean = new TeamDOForSeason();
                                    homeBean.setId(String.valueOf(home.getId()));
                                    homeBean.setName(home.getName());
                                    homeBean.setShow_team(home.getShowTeam());
                                    homeBean.setType(home.getType());
                                    homeBean.setGender(home.getGender());
                                    matchBean.setHome(homeBean);
                                }
                                matchBeans.add(matchBean);
                            }
                            roundBean.setMatch(matchBeans);
                            roundBeans.add(roundBean);
                        }
//                        currentRoDate = new Date();
//                        if (roundPO.getStart() != null && roundPO.getEnd() != null) {
//                            if (currentRoDate.getTime() >= roundPO.getStart().getTime() && currentRoDate.getTime() <= roundPO.getEnd().getTime()) {
//                                matchesBySeasonsDO.setCurrent_round_id(String.valueOf(roundPO.getId()));
//                            }
//                        }

                    }
                }
            }
            matchesBySeasonsDO.setCompetition_id(String.valueOf(seasonPO.getCompetitionId()));
            if (seasonPO.getStart() != null) {
                matchesBySeasonsDO.setStart(sdfprase.format(seasonPO.getStart()));
            }
            if (seasonPO.getEnd() != null) {
                matchesBySeasonsDO.setEnd(sdfprase.format(seasonPO.getEnd()));
            }
            matchesBySeasonsDO.setId(String.valueOf(seasonPO.getId()));
            matchesBySeasonsDO.setName(seasonPO.getName());
            matchesBySeasonsDO.setHas_tables(seasonPO.getHasTables());
            matchesBySeasonsDO.setRound(roundBeans);
            return matchesBySeasonsDO;
        } else {
            logger.error("matchesBySeasonsDO为空!赛季Id{}",seId);
            return null;
        }

    }

    @Override
    public MatchLineUpDO MatchLineUp(Integer maId) {
        MatchLineUpDO matchLineUpDO = new MatchLineUpDO();
        MatchLineUpDO.DataBean dataBean = new MatchLineUpDO.DataBean();
//阵型名称
        List<LineUpNameDO> lineUpNameDOS = matchLineUpPOMapper.selectLineUpNameByMa(maId);
        dataBean.setLineupName(lineUpNameDOS);
//队员位置
        List<PlayListDO> playListDOS = matchLineUpPOMapper.selectPlaysByMaId(maId);
        dataBean.setPlayList(playListDOS);
        matchLineUpDO.setData(dataBean);

        return matchLineUpDO;

    }

}
