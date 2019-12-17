package com.haiqiu.cfadata.controller;


import com.haiqiu.cfadata.doentity.SeasonsByCompetitionDO;
import com.haiqiu.cfadata.service.impl.SeasonServiceImpl;
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
public class SeasonController {
    @Autowired
    SeasonServiceImpl seasonService;

    @GetMapping("/seasons-by-competition/{competition}")
    public SeasonsByCompetitionDO season(@PathVariable String competition) {
        return seasonService.seasonByCo(Integer.valueOf(competition.substring(2)));
    }

}
