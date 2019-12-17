package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.*;
import com.haiqiu.cfadata.doentity.CompetitionDO;
import com.haiqiu.cfadata.doentity.SeasonDO;
import com.haiqiu.cfadata.doentity.TeamSquardFromToDO;
import com.haiqiu.cfadata.poentity.*;
import com.haiqiu.cfadata.service.SquadService;
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
public class SquadServiceImpl implements SquadService {
    private static Logger logger = LoggerFactory.getLogger(SquadServiceImpl.class);
    @Autowired
    private TeamPOMapper teamPOMapper;
    @Autowired
    private SeasonPOMapper seasonPOMapper;
    @Autowired
    private CompetitionPOMapper competitionPOMapper;
    //    @Autowired
//    private CountryPOMapper countryPOMapper;
    @Autowired
    private TeamPersonPOMapper teamPersonPOMapper;
    @Autowired
    private PersonPOMapper personPOMapper;
    @Autowired
    private RolePOMapper rolePOMapper;
    @Autowired
    private RoundPOMapper roundPOMapper;

    @Override
    public TeamSquardFromToDO teamSquardFromTo(String teamId, String startTime, String endTime) {

        PersonPO personPO = new PersonPO();
        TeamSquardFromToDO teamSquardFromToDO = new TeamSquardFromToDO();
        TeamSquardFromToDO.TeamBean teamBean = new TeamSquardFromToDO.TeamBean();
        TeamSquardFromToDO.TeamBean.SquadBean squadBean = new TeamSquardFromToDO.TeamBean.SquadBean();
        TeamSquardFromToDO.TeamBean.SquadBean.RoleBean roleBean = new TeamSquardFromToDO.TeamBean.SquadBean.RoleBean();
//        List<CountryPO> countryBeans = new ArrayList<>();
        List<TeamSquardFromToDO.TeamBean.SquadBean> squadBeans = new ArrayList<>();
        SeasonDO seasonBean = new SeasonDO();
        CompetitionDO competitionBean = new CompetitionDO();
        List<SeasonDO> seasonBeans = new ArrayList<>();
        List<RoundPO> roundPOs = new ArrayList<>();
        Date currentRoDate = new Date();
        RolePO rolePO = new RolePO();
        TeamSquardFromToDO.TeamBean.SquadBean.PersonBean personBean = new TeamSquardFromToDO.TeamBean.SquadBean.PersonBean();

        TeamPO teamPO = teamPOMapper.selectByPrimaryKey(Integer.valueOf(teamId));

        teamBean = new TeamSquardFromToDO.TeamBean();
        if (teamPO != null) {
            teamBean.setId(String.valueOf(teamPO.getId()));
            BeanUtils.copyProperties(teamPO, teamBean);
        } else {
            logger.error("TeamSquardFromToDO接口异常,teamId为空!,teamId{}", teamId);
        }

        SimpleDateFormat sdfformat = new SimpleDateFormat("yyyy-MM-dd");

        Date seStartDate = null;
        Date seEndDate = null;

        try {
            seStartDate = sdfformat.parse(startTime);
            seEndDate = sdfformat.parse(endTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<SeasonPO> seasonPOs = seasonPOMapper.selectByTime(seStartDate, seEndDate);

        SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");

        if (seasonPOs != null && seasonPOs.size() != 0) {
            for (SeasonPO seasonPO : seasonPOs) {
                seasonBean = new SeasonDO();
                seasonBean.setId(String.valueOf(seasonPO.getId()));
//                competition
                CompetitionPO competitionPO = competitionPOMapper.selectByPrimaryKey(seasonPO.getCompetitionId());
                competitionBean = new CompetitionDO();
                if (competitionPO != null) {
                    if (competitionPO.getId() != null) {
                        competitionBean.setId(String.valueOf(competitionPO.getId()));
                    }
                    if (competitionPO.getName() != null) {
                        competitionBean.setName(competitionPO.getName());
                    }
                    if (competitionPO.getSportId() != null) {
                        competitionBean.setSport_id(String.valueOf(competitionPO.getSportId()));
                    }
                }

                seasonBean.setCompetition(competitionBean);
                if (seasonPO.getStart() != null) {
                    seasonBean.setStart(sdfprase.format(seasonPO.getStart()));
                }
                if (seasonPO.getEnd() != null) {
                    seasonBean.setEnd(sdfprase.format(seasonPO.getEnd()));
                }

                roundPOs = roundPOMapper.selectBySe(seasonPO.getId());
// TODO: 2019/7/30  初始化缓存处理
                if (roundPOs != null && roundPOs.size() != 0) {
                    for (RoundPO roundPO : roundPOs) {
                        if (roundPO.getStart() != null && roundPO.getEnd() != null) {
                            currentRoDate = new Date();
//                                            判断当前轮次 在哪个赛季时间范围内
                            if (currentRoDate.getTime() >= roundPO.getStart().getTime() && currentRoDate.getTime() <= roundPO.getEnd().getTime()) {
                                seasonBean.setCurrent_round_id(String.valueOf(roundPO.getId()));
                            }
                        }
                    }
                }

                BeanUtils.copyProperties(seasonPO, seasonBean);
                seasonBeans.add(seasonBean);
            }
        } else {
            logger.error("teamSquardFromToDO teamId:{}无from start{}to end{}赛季信息", teamId, startTime, endTime);
        }

        teamSquardFromToDO = new TeamSquardFromToDO();
        teamSquardFromToDO.setSeason(seasonBeans);

        List<TeamPersonPO> teamPersonPOs = teamPersonPOMapper.selectByTeamTime(Integer.valueOf(teamId), seStartDate, seEndDate);
        if (teamPersonPOs != null && teamPersonPOs.size() != 0) {
            for (TeamPersonPO teamPersonPO : teamPersonPOs) {
                squadBean = new TeamSquardFromToDO.TeamBean.SquadBean();
                if (teamPersonPO.getStart() != null) {
                    squadBean.setStart(sdfprase.format(teamPersonPO.getStart()));
                }
                if (teamPersonPO.getEnd() != null) {
                    squadBean.setEnd(sdfprase.format(teamPersonPO.getEnd()));
                }
                squadBean.setId(String.valueOf(teamPersonPO.getId()));
                squadBean.setShirtnumber(teamPersonPO.getShirtnumber());
//                  person
                personPO = personPOMapper.selectByPrimaryKey(teamPersonPO.getPersonId());
                if (personPO != null) {
                    personBean = new TeamSquardFromToDO.TeamBean.SquadBean.PersonBean();
                    personBean.setId(String.valueOf(personPO.getId()));
//                  country
//                    CountryPO countryPO = countryPOMapper.selectByPrimaryKey(personPO.getCountryId());
//                    countryBeans = new ArrayList<>();
//                    countryBeans.add(countryPO);
//                    personBean.setCountry(countryBeans);

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
                    squadBean.setPerson(personBean);
                }
//role
                rolePO = rolePOMapper.selectByPrimaryKey(teamPersonPO.getRoleId());
                if (rolePO != null) {
                    squadBean.setRole(rolePO);
                }
                squadBeans.add(squadBean);
            }
        } else {

            logger.error("teamSquardFromToDO teamId:{}无from start{}to end{}人员信息", teamId, startTime, endTime);
        }
        teamBean.setSquad(squadBeans);
        teamSquardFromToDO.setTeam(teamBean);
        return teamSquardFromToDO;
    }


}
