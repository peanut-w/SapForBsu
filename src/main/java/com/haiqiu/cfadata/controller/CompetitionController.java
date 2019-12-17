package com.haiqiu.cfadata.controller;


import com.haiqiu.cfadata.doentity.CompetitionListDO;
import com.haiqiu.cfadata.service.impl.CompetitionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by peanut on 2019/4/25 下午12:35
 */
@RestController
@RequestMapping("sap/en")
public class CompetitionController {

    @Autowired
    private CompetitionServiceImpl competitionService;


    @RequestMapping("/competition-list")
    public List<CompetitionListDO> competition() {
        return competitionService.competitionList();
    }
}
