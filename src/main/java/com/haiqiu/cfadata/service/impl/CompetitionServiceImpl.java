package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.*;
import com.haiqiu.cfadata.doentity.CompetitionListDO;
import com.haiqiu.cfadata.poentity.*;
import com.haiqiu.cfadata.service.CompetitionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by peanut on 2019/6/5 上午11:30
 */
@Service
public class CompetitionServiceImpl implements CompetitionService {

    private static Logger logger = LoggerFactory.getLogger(CompetitionServiceImpl.class);

    @Autowired
    private CompetitionPOMapper competitionPOMapper;
    @Autowired
    private FederationPOMapper federationPOMapper;
    @Autowired
    private SeasonPOMapper seasonPOMapper;
    @Autowired
    private RoundPOMapper roundPOMapper;
    @Autowired
    private AgePOMapper agePOMapper;
    @Autowired
    private CountryPOMapper countryPOMapper;

    /**
     * competition-list 接口
     *
     * @return
     */
    @Override
    public List<CompetitionListDO> competitionList() {
        List<CompetitionListDO> competitionListDOs = new ArrayList<>();
        List<SeasonPO> seasonPOs = new ArrayList<>();
        List<RoundPO> roundPOs = new ArrayList<>();
        CompetitionListDO competitionListDO = new CompetitionListDO();
        Date currentSeDate = new Date();
        Integer currentSeId = 0;
        Date currentRoDate = new Date();
        Integer currentRoId = 0;
        List<CompetitionPO> competitionPOs = competitionPOMapper.selectAll();
        if (competitionPOs != null && competitionPOs.size() != 0) {
            try {
                for (CompetitionPO competitionPO : competitionPOs) {
                    //                当前赛季  根据赛事ID查出所有赛季，遍历赛季获得赛季起止时间，当前时间和赛季起始时间作比较 如果在这个范围内则为当前赛季,
                    seasonPOs = seasonPOMapper.selectByCoId(competitionPO.getId());
                    if (seasonPOs != null && seasonPOs.size() != 0) {
                        for (SeasonPO seasonPO : seasonPOs) {
                            currentSeDate = new Date();
                            if (seasonPO.getStart() != null && seasonPO.getEnd() != null) {
                                //                            判断当前赛季 在哪个赛季时间范围内  当前赛季和当前时间的优化，后续存入到缓存中
                                if (currentSeDate.getTime() >= seasonPO.getStart().getTime() && currentSeDate.getTime() <= seasonPO.getEnd().getTime()) {
                                    currentSeId = seasonPO.getId();
                                    roundPOs = roundPOMapper.selectBySe(seasonPO.getId());
                                    if (roundPOs != null && roundPOs.size() != 0) {
                                        for (RoundPO roundPO : roundPOs) {
                                            if (roundPO.getStart() != null && roundPO.getEnd() != null) {
                                                //                                            判断当前轮次 在哪个赛季时间范围内
                                                if (currentRoDate.getTime() >= roundPO.getStart().getTime() && currentRoDate.getTime() <= roundPO.getEnd().getTime()) {
                                                    currentRoId = roundPO.getId();

                                                }
                                            }
                                        }
                                    }

                                }
                            }

                        }
                        competitionListDO = new CompetitionListDO();
                        competitionListDO.setCurrent_season_id(String.valueOf(currentSeId));
                        competitionListDO.setCurrent_round_id(String.valueOf(currentRoId));
                        if (competitionPO.getAgeId() != null) {
                            competitionListDO.setAge_id(String.valueOf(competitionPO.getAgeId()));
                        }
                        if (competitionPO.getGender() != null) {
                            competitionListDO.setGender(competitionPO.getGender());
                        }

                        competitionListDO.setId(String.valueOf(competitionPO.getId()));
//                        competitionListDO.setMicroname(competitionPO.getMicroname());
                        competitionListDO.setName(competitionPO.getName());
//                        competitionListDO.setShortname(competitionPO.getShortname());
                        competitionListDO.setType(competitionPO.getType());
                        //age
                        if (competitionPO.getAgeId() != null) {
                            AgePO ageBean = agePOMapper.selectByPrimaryKey(competitionPO.getAgeId());
                                competitionListDO.setAge(ageBean);
                        }
                        //sport  暂时只有足球一项运动
                        SportPO sportBean = new SportPO();
                        sportBean.setId("1");
                        sportBean.setName("Football");
                        competitionListDO.setSport(sportBean);
                        //federation
                        if (competitionPO.getFederationId() != null) {
                            FederationPO federationPO = federationPOMapper.selectByPrimaryKey(competitionPO.getFederationId());
                            competitionListDO.setFederation(federationPO);
                        }
                        //country
                        if (competitionPO.getCountryId() != null) {
                            CountryPO countryBean = countryPOMapper.selectByPrimaryKey(competitionPO.getCountryId());
                            competitionListDO.setCountry(countryBean);
                        }

                        competitionListDOs.add(competitionListDO);
                    } else {
                        // 当前赛事下无任何赛季信息                   进入下一个循环
                        continue;
                    }
                }
                //                将赛事信息写入到赛事集合内
                return competitionListDOs;
            } catch (Exception e) {
                logger.error("competitionListDO接口异常{}", e);
                return null;
            }

        } else {
            logger.error("未查询到任何赛事信息");
            return null;
        }
    }

}
