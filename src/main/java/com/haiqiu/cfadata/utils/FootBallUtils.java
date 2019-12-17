package com.haiqiu.cfadata.utils;

import com.haiqiu.cfadata.dao.RoundPOMapper;
import com.haiqiu.cfadata.dao.SeasonPOMapper;
import com.haiqiu.cfadata.poentity.RoundPO;
import com.haiqiu.cfadata.poentity.SeasonPO;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by peanut on 2019/8/2 上午11:27
 */
public  class FootBallUtils {

    private static Date CURRENTDATE = new Date();

    @Autowired
    private  SeasonPOMapper seasonPOMapper;
    @Autowired
    private  RoundPOMapper roundPOMapper;


    /**
     *
     */
    public  Map<String,Integer> getCurrentSeasonAndRound(Integer competitionId) {
        List<SeasonPO> seasonPOS = seasonPOMapper.selectByCoId(competitionId);
        System.out.println(competitionId);
        List<RoundPO> roundPOs = null;
//        不在某个赛季范围内则传默认值0
        Integer currentSeId = 0;
        Integer currentRoId = 0;
        Map<String,Integer> map = new HashMap<>();
        if (seasonPOS != null) {
            for (SeasonPO seasonPO : seasonPOS) {
                CURRENTDATE = new Date();
                if (CURRENTDATE.getTime() >= seasonPO.getStart().getTime() && CURRENTDATE.getTime() <= seasonPO.getEnd().getTime()) {
                    currentSeId = seasonPO.getId();
                    roundPOs = roundPOMapper.selectBySe(currentSeId);
                    if (roundPOs != null) {
                        for (RoundPO roundPO : roundPOs) {
                            CURRENTDATE = new Date();
                            if (roundPO.getStart() != null && roundPO.getEnd() != null) {
                                if (CURRENTDATE.getTime() >= roundPO.getStart().getTime() && CURRENTDATE.getTime() <= roundPO.getEnd().getTime()) {
                                    currentRoId = roundPO.getId();
                                }
                            }

                        }
                    }

                }
            }
        }
        map.put("currentSeId", currentSeId);
        map.put("currentRoId", currentRoId);
        return map;
    }
}


