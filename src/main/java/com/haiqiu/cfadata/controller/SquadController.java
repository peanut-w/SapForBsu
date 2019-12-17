package com.haiqiu.cfadata.controller;


import com.haiqiu.cfadata.doentity.TeamSquardFromToDO;
import com.haiqiu.cfadata.service.impl.SquadServiceImpl;
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
public class SquadController {
    @Autowired
    SquadServiceImpl squadService;


    @GetMapping("/team-squad-from-to/{team}/{startTime}/{endTime}")
    public TeamSquardFromToDO ByTime(@PathVariable("team") String team, @PathVariable("startTime") String startTime, @PathVariable("endTime") String endTime) {
        return squadService.teamSquardFromTo(team.substring(2), startTime.substring(2), endTime.substring(2));
    }


}
