package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.*;
import com.haiqiu.cfadata.doentity.TeamsByClubDO;
import com.haiqiu.cfadata.doentity.TeamsBySeasonExtendDO;
import com.haiqiu.cfadata.poentity.*;
import com.haiqiu.cfadata.service.TeamService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by peanut on 2019/6/5 上午11:30
 */
@Service
public class TeamServiceImpl implements TeamService {
    private static Logger logger = LoggerFactory.getLogger(TeamServiceImpl.class);
    @Autowired
    private SeTePOMapper seTePOMapper;
    @Autowired
    private TeamPOMapper teamPOMapper;
    @Autowired
    private SeasonPOMapper seasonPOMapper;
    @Autowired
    private CountryPOMapper countryPOMapper;
    @Autowired
    private AgePOMapper agePOMapper;
    @Autowired
    private ClubPOMapper clubPOMapper;

    @Override
    public TeamsBySeasonExtendDO teamBySeason(Integer seId, String lm) {
        TeamsBySeasonExtendDO teamsBySeasonExtendDO = new TeamsBySeasonExtendDO();
        TeamsBySeasonExtendDO.SeasonBean seasonBean = new TeamsBySeasonExtendDO.SeasonBean();
        List<TeamsBySeasonExtendDO.SeasonBean> seasonBeans = new ArrayList<>();
        TeamsBySeasonExtendDO.SeasonBean.TeamBean teamBean = new TeamsBySeasonExtendDO.SeasonBean.TeamBean();
        List<TeamsBySeasonExtendDO.SeasonBean.TeamBean> teamBeans = new ArrayList<>();
        TeamsBySeasonExtendDO.SeasonBean.TeamBean.ClubBean clubBean = new TeamsBySeasonExtendDO.SeasonBean.TeamBean.ClubBean();

        List<Integer> teIds = seTePOMapper.selectTeBySe(seId);
        if (teIds != null) {
            for (Integer teId : teIds) {
                TeamPO teamPO = teamPOMapper.selectByPrimaryKey(teId);
                if (teamPO != null) {
                    if (lm != null) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm");
                        try {
                            if (teamPO.getLastModified().getTime() >= sdf.parse(lm).getTime()) {
                                teamBean = new TeamsBySeasonExtendDO.SeasonBean.TeamBean();
                                clubBean = new TeamsBySeasonExtendDO.SeasonBean.TeamBean.ClubBean();
                                this.makeTeamBean(teamBean, clubBean, teamPO);
                                teamBeans.add(teamBean);
                            }
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else {
                        teamBean = new TeamsBySeasonExtendDO.SeasonBean.TeamBean();
                        clubBean = new TeamsBySeasonExtendDO.SeasonBean.TeamBean.ClubBean();
                        this.makeTeamBean(teamBean, clubBean, teamPO);
                        teamBeans.add(teamBean);
                    }
                }
            }

            SeasonPO seasonPO = seasonPOMapper.selectByPrimaryKey(seId);
            if (seasonPO != null) {
                seasonBean = new TeamsBySeasonExtendDO.SeasonBean();
                seasonBean.setCompetition_id(String.valueOf(seasonPO.getCompetitionId()));
                seasonBean.setId(String.valueOf(seasonPO.getId()));
                SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");
                seasonBean.setEnd(sdfprase.format(seasonPO.getEnd()));
                seasonBean.setName(seasonPO.getName());
                if (seasonPO.getStart() != null) {
                    seasonBean.setStart(sdfprase.format(seasonPO.getStart()));
                }
                seasonBean.setTeam(teamBeans);
            }
            seasonBeans.add(seasonBean);

            teamsBySeasonExtendDO = new TeamsBySeasonExtendDO();
            teamsBySeasonExtendDO.setId(String.valueOf(seasonPO.getCompetitionId()));
            teamsBySeasonExtendDO.setSport_id("1");
            teamsBySeasonExtendDO.setSeason(seasonBeans);

            return teamsBySeasonExtendDO;
        } else {
            logger.error("TeamsBySeasonExtendDO 接口异常 seId:{}", seId);
            return null;
        }

    }

    @Override
    public TeamsByClubDO teamByClub(Integer clId) {
        TeamsByClubDO teamsByClubDO = new TeamsByClubDO();
        TeamsByClubDO.TeamBean teamBean = new TeamsByClubDO.TeamBean();
        List<TeamsByClubDO.TeamBean> teamBeans = new ArrayList<>();

        List<TeamPO> teamPOS = teamPOMapper.selectByClub(clId);
        if (teamPOS != null && teamPOS.size() > 0) {
            for (TeamPO teamPO : teamPOS) {
                if (teamPO != null) {
                    teamBean = new TeamsByClubDO.TeamBean();
                    teamBean.setId(String.valueOf(teamPO.getId()));
                    teamBean.setName(teamPO.getName());
//                    teamBean.setShortname(teamPO.getShortname());
//                    teamBean.setMicroname(teamPO.getMicroname());
                    teamBean.setType(teamPO.getType());
                    teamBean.setGender(teamPO.getGender());
                    teamBean.setShow_team(teamPO.getShowTeam());
//            age
                    AgePO ageBean = agePOMapper.selectByPrimaryKey(teamPO.getAgeId());
                    teamBean.setAge(ageBean);
//            sport  暂时只有足球一项运动
                    SportPO sportBean = new SportPO();
                    sportBean.setId("1");
                    sportBean.setName("Football");
                    teamBean.setSport(sportBean);

                    teamBeans.add(teamBean);
                    teamsByClubDO.setTeam(teamBeans);
                }
            }
            teamsByClubDO.setId(String.valueOf(clId));
            ClubPO clubPO = clubPOMapper.selectByPrimaryKey(clId);
            teamsByClubDO.setName(clubPO.getName());
            return teamsByClubDO;
        } else {
            logger.error("TeamsByClubDO为空!clubId{}", clId);
            return null;
        }
    }

    public void makeTeamBean(TeamsBySeasonExtendDO.SeasonBean.TeamBean teamBean, TeamsBySeasonExtendDO.SeasonBean.TeamBean.ClubBean clubBean, TeamPO teamPO) {

//age
        AgePO ageBean = agePOMapper.selectByPrimaryKey(teamPO.getAgeId());
        teamBean.setAge(ageBean);

//country
        CountryPO countryPO = countryPOMapper.selectByPrimaryKey(teamPO.getCountryId());
        teamBean.setCountry(countryPO);
//club
        if (teamPO.getClubId() != null) {
            ClubPO clubPO = clubPOMapper.selectByPrimaryKey(teamPO.getClubId());
            clubBean.setId(String.valueOf(teamPO.getClubId()));
            if(clubPO!=null){
                if (clubPO.getName() != null) {
                    clubBean.setName(clubPO.getName());
                }
                teamBean.setClub(clubBean);
            }else{
                logger.error("俱乐部为空!id{}",teamPO.getClubId());
            }

        }
//其他
        if (teamPO.getGender() != null) {
            teamBean.setGender(teamPO.getGender());
        }
        if (teamPO.getShortname() != null) {
            teamBean.setName(teamPO.getShortname());
            teamBean.setShortname(teamPO.getShortname());
        } else {
            teamBean.setName(teamPO.getName());
        }
        if (teamPO.getShowTeam() != null) {
            teamBean.setShow_team(teamPO.getShowTeam());
        }
        if (teamPO.getType() != null) {
            teamBean.setType(teamPO.getType());
        }
        teamBean.setId(String.valueOf(teamPO.getId()));
    }

}
