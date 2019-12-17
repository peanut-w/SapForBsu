package com.haiqiu.cfadata.controller;


import com.haiqiu.cfadata.doentity.PersonDO;
import com.haiqiu.cfadata.service.impl.PersonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Created by peanut on 2019/4/25 下午12:35
 */
@RestController("personController")
@RequestMapping("sap/en")
public class PersonController {

    @Autowired
    private PersonServiceImpl personService;

    @GetMapping("/person/{personId}")
    public PersonDO person(@PathVariable String personId) {
        return personService.person(Integer.valueOf(personId.substring(2)));
    }
}
