package com.haiqiu.cfadata.controller;

import com.haiqiu.cfadata.doentity.TeamsByClubDO;
import com.haiqiu.cfadata.doentity.TeamsBySeasonExtendDO;
import com.haiqiu.cfadata.service.impl.TeamServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by peanut on 2019/4/25 下午12:35
 */
@RestController
@RequestMapping("sap/en")
public class TeamController {

    @Autowired
    private TeamServiceImpl teamService;

    @GetMapping("/teams-by-club/{club}")
    public TeamsByClubDO ByClub(@PathVariable String club) {
        return teamService.teamByClub(Integer.valueOf(club.substring(2)));
    }

    @GetMapping("/teams-by-season-extended/{SeasonId}")
    public TeamsBySeasonExtendDO BySeason(@PathVariable String SeasonId) {
        return teamService.teamBySeason(Integer.valueOf(SeasonId.substring(2)),null);
    }
    @GetMapping("/teams-by-season-extended/{SeasonId}/{lm}")
    public TeamsBySeasonExtendDO BySeasonLm(@PathVariable String SeasonId, @PathVariable String lm) {
        return teamService.teamBySeason(Integer.valueOf(SeasonId.substring(2)),lm.substring(2));
    }
}
