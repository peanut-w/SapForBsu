package com.haiqiu.cfadata.service;


import com.haiqiu.cfadata.doentity.SeasonsByCompetitionDO;

/**
 * Created by peanut on 2019/6/14 下午1:31
 */
public interface SeasonService {

    SeasonsByCompetitionDO seasonByCo(Integer coId);
}
