package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.*;
import com.haiqiu.cfadata.doentity.SeasonsByCompetitionDO;
import com.haiqiu.cfadata.poentity.*;
import com.haiqiu.cfadata.service.SeasonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by peanut on 2019/6/5 上午11:30
 */
@Service
public class SeasonServiceImpl implements SeasonService {
    private static Logger logger = LoggerFactory.getLogger(SeasonServiceImpl.class);
    @Autowired
    private SeasonPOMapper seasonPOMapper;
    @Autowired
    private CompetitionPOMapper competitionPOMapper;
    @Autowired
    private CountryPOMapper countryPOMapper;
    @Autowired
    private FederationPOMapper federationPOMapper;
    @Autowired
    private RoundPOMapper roundPOMapper;
    @Autowired
    private AgePOMapper agePOMapper;

    @Override
    public SeasonsByCompetitionDO seasonByCo(Integer coId) {

        SeasonsByCompetitionDO seasonsByCompetitionDO = null;
        SeasonsByCompetitionDO.SeasonBean seasonBean = null;
        Date currentSeDate = null;
        Date currentRoDate = null;
        Integer currentSeId = 0;
        Integer currentRoId = 0;
        List<RoundPO> roundPOs = null;
        SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");
        List<SeasonsByCompetitionDO.SeasonBean> seasonBeans = new ArrayList<>();
        List<SeasonPO> seasonPOS = seasonPOMapper.selectByCoId(coId);
        if (seasonPOS != null) {
            seasonsByCompetitionDO = new SeasonsByCompetitionDO();
            for (SeasonPO seasonPO : seasonPOS) {
                currentSeDate = new Date();
                seasonBean = new SeasonsByCompetitionDO.SeasonBean();
                if (currentSeDate.getTime() >= seasonPO.getStart().getTime() && currentSeDate.getTime() <= seasonPO.getEnd().getTime()) {
                    currentSeId = seasonPO.getId();
                    roundPOs = roundPOMapper.selectBySe(currentSeId);
                    if (roundPOs != null) {
                        for (RoundPO roundPO : roundPOs) {
                            currentRoDate = new Date();
                            if (roundPO.getStart() != null && roundPO.getEnd() != null) {
                                if (currentRoDate.getTime() >= roundPO.getStart().getTime() && currentRoDate.getTime() <= roundPO.getEnd().getTime()) {
                                    currentRoId = roundPO.getId();
                                }
                            }

                        }
                    }

                }
                seasonBean.setCurrent_round_id(String.valueOf(currentRoId));
                if (seasonPO.getEnd() != null) {
                    seasonBean.setEnd(sdfprase.format(seasonPO.getEnd()));
                }
                seasonBean.setHas_tables(seasonPO.getHasTables());
                seasonBean.setId(String.valueOf(seasonPO.getId()));
                seasonBean.setName(seasonPO.getName());
                if (seasonPO.getStart() != null) {
                    seasonBean.setStart(sdfprase.format(seasonPO.getStart()));
                }
                seasonBeans.add(seasonBean);
            }
            seasonsByCompetitionDO.setSeason(seasonBeans);

            CompetitionPO competitionPO = competitionPOMapper.selectByPrimaryKey(coId);

            if (competitionPO != null) {
                seasonsByCompetitionDO.setCurrent_season_id(String.valueOf(currentSeId));
                seasonsByCompetitionDO.setCurrent_round_id(String.valueOf(currentRoId));
                seasonsByCompetitionDO.setId(String.valueOf(coId));
                if (competitionPO.getAgeId() != null) {
                    seasonsByCompetitionDO.setAge_id(String.valueOf(competitionPO.getAgeId()));
                }
                seasonsByCompetitionDO.setGender(competitionPO.getGender());
                seasonsByCompetitionDO.setName(competitionPO.getName());
//                seasonsByCompetitionDO.setShortname(competitionPO.getShortname());
                if (competitionPO.getSportId() != null) {
                    seasonsByCompetitionDO.setSport_id(String.valueOf(competitionPO.getSportId()));
                }
                seasonsByCompetitionDO.setType(competitionPO.getType());
            }
//        age
            AgePO ageBean = agePOMapper.selectByPrimaryKey(competitionPO.getAgeId());
            seasonsByCompetitionDO.setAge(ageBean);
            CountryPO countryPO = countryPOMapper.selectByPrimaryKey(competitionPO.getCountryId());
            if (countryPO != null) {
                seasonsByCompetitionDO.setCountry(countryPO);
            }

            FederationPO federationPO = federationPOMapper.selectByPrimaryKey(competitionPO.getFederationId());

            if (federationPO != null) {
                seasonsByCompetitionDO.setFederation(federationPO);
            }
            return seasonsByCompetitionDO;
        } else {
            logger.error("seasonsByCompetitionDO为空!coId:{}", coId);
            return null;
        }

    }

}
