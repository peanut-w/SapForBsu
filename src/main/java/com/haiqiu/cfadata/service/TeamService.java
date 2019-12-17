package com.haiqiu.cfadata.service;


import com.haiqiu.cfadata.doentity.TeamsByClubDO;
import com.haiqiu.cfadata.doentity.TeamsBySeasonExtendDO;

/**
 * Created by peanut on 2019/6/14 下午1:32
 */
public interface TeamService {
    TeamsBySeasonExtendDO teamBySeason(Integer seId,String lm);

    TeamsByClubDO teamByClub(Integer clId);
}
