package com.haiqiu.cfadata.service;


import com.haiqiu.cfadata.doentity.TeamSquardFromToDO;

/**
 * Created by peanut on 2019/6/14 下午1:31
 */
public interface SquadService {

    TeamSquardFromToDO teamSquardFromTo(String teamId, String startTime, String endTime);
}
