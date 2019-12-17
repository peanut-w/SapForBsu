package com.haiqiu.cfadata.controller;



import com.haiqiu.cfadata.poentity.CountryPO;
import com.haiqiu.cfadata.service.impl.CountryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by peanut on 2019/4/25 下午12:35
 */
@RestController
@RequestMapping("sap/en")
public class CountryController {

    @Autowired
    private CountryServiceImpl countryService;


    @RequestMapping("/country-list")
    public List<CountryPO> country() {
        return countryService.countryPOList();
    }
}
