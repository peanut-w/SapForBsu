package com.haiqiu.cfadata.controller;


import com.haiqiu.cfadata.doentity.MatchDO;
import com.haiqiu.cfadata.doentity.MatchLineUpDO;
import com.haiqiu.cfadata.doentity.MatchesBySeasonsDO;
import com.haiqiu.cfadata.service.impl.MatchServiceImpl;
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
public class MatchController {
    @Autowired
    MatchServiceImpl matchService;

    @GetMapping("/matches-by-season/{seasonId}")
    public MatchesBySeasonsDO maBySe(@PathVariable String seasonId) {
        return matchService.matchesBySeasons(Integer.valueOf(seasonId.substring(2)), null);
    }

    @GetMapping("/matches-by-season/{seasonId}/{lm}")
    public MatchesBySeasonsDO maBySe(@PathVariable String seasonId, @PathVariable String lm) {
        return matchService.matchesBySeasons(Integer.valueOf(seasonId.substring(2)), lm.substring(2));
    }

    @GetMapping("/match/{matchId}")
    public MatchDO match(@PathVariable String matchId) {
        return matchService.match(Integer.valueOf(matchId.substring(2)));
    }

    @GetMapping("/match-lineup/{maId}")
    public MatchLineUpDO lineup(@PathVariable String maId) {
        return matchService.MatchLineUp(Integer.valueOf(maId.substring(2)));
    }

}
