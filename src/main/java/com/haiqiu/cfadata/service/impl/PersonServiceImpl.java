package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.*;
import com.haiqiu.cfadata.doentity.GfxDO;
import com.haiqiu.cfadata.doentity.PersonDO;
import com.haiqiu.cfadata.doentity.PersonDetailDO;
import com.haiqiu.cfadata.poentity.*;
import com.haiqiu.cfadata.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by peanut on 2019/6/5 上午11:30
 */
@Service
public class PersonServiceImpl implements PersonService {
    private static Logger logger = LoggerFactory.getLogger(PersonServiceImpl.class);
    @Autowired
    PersonPOMapper personPOMapper;
    @Autowired
    private TeamPersonPOMapper teamPersonPOMapper;
    @Autowired
    private CountryPOMapper countryPOMapper;
    @Autowired
    private GfxPOMapper gfxPOMapper;
    @Autowired
    private RolePOMapper rolePOMapper;
    @Autowired
    private TeamPOMapper teamPOMapper;
    @Autowired
    private PersonDetailPOMapper personDetailPOMapper;

    @Override
    public PersonDO person(Integer peId) {
        PersonDO personDO = new PersonDO();

        PersonDO.TeamPersonBean teamPersonBean = new PersonDO.TeamPersonBean();
        PersonDO.TeamPersonBean.TeamBean teamBean = new PersonDO.TeamPersonBean.TeamBean();

        List<CountryPO> countryBeans = new LinkedList<>();
        List<GfxDO> gfxBeans = new ArrayList<>();
        List<PersonDO.TeamPersonBean> teamPersonBeans = new ArrayList<>();
        SimpleDateFormat sdfprase = new SimpleDateFormat("dd.MM.yyyy");
        PersonPO personPO = personPOMapper.selectByPrimaryKey(peId);
        if (personPO != null) {
            personDO = new PersonDO();
            personDO.setId(String.valueOf(personPO.getId()));
            if (personPO.getBirthday() != null) {
                personDO.setBirthday(sdfprase.format(personPO.getBirthday()));
            }
            personDO.setFirstname(personPO.getFirstname());
            personDO.setFullname(personPO.getFullname());
            personDO.setGender(personPO.getGender());
            personDO.setSurname(personPO.getSurname());
            personDO.setName(personPO.getName());
            if (personPO.getWeight() != null) {
                personDO.setWeight(String.valueOf(personPO.getWeight()));
            }
            if (personPO.getHeight() != null) {
                personDO.setHeight(String.valueOf(personPO.getHeight()));
            }


//鉴于country都来自于同一数据
            if (personPO.getCountryId() != null) {
                CountryPO countryPO = countryPOMapper.selectByPrimaryKey(personPO.getCountryId());
                if (countryPO != null) {
                    countryBeans.add(countryPO);
                }
            }
            personDO.setCountry(countryBeans);
            if (personPO.getGfxId() != null) {
                GfxPO gfxPO = gfxPOMapper.selectByPrimaryKey(personPO.getGfxId());
                if (gfxPO != null) {
                    GfxDO gfxDO = new GfxDO();
                    gfxDO.setId(gfxPO.getId());
                    gfxDO.setUri(gfxPO.getUri());
                    gfxBeans.add(gfxDO);

                }
            }
            personDO.setGfx(gfxBeans);
//        person detail
            if (personPO.getPersonDetailId() != null) {
                PersonDetailPO personDetailPO = personDetailPOMapper.selectByPrimaryKey(personPO.getPersonDetailId());
                if (personDetailPO != null) {
                    PersonDetailDO personDetailDO = new PersonDetailDO();
                    BeanUtils.copyProperties(personDetailPO, personDetailDO);
                    personDetailDO.setBirth_country(countryBeans);
                    personDO.setPerson_detail(personDetailDO);
                }
            } else {
                PersonDetailDO personDetailDO = new PersonDetailDO();
                personDO.setPerson_detail(personDetailDO);
            }
//        teamPerson
            List<TeamPersonPO> teamPersonPOs = teamPersonPOMapper.selectByPeId(peId);
            if (teamPersonPOs != null && teamPersonPOs.size() != 0) {
                for (TeamPersonPO teamPersonPO : teamPersonPOs) {
                    teamPersonBean = new PersonDO.TeamPersonBean();
                    if (teamPersonPO.getEnd() != null) {
                        teamPersonBean.setEnd(sdfprase.format(teamPersonPO.getEnd()));
                    }
                    if (teamPersonPO.getStart() != null) {
                        teamPersonBean.setStart(sdfprase.format(teamPersonPO.getStart()));
                    }
                    teamPersonBean.setShirtnumber(teamPersonPO.getShirtnumber());
                    teamPersonBean.setId(String.valueOf(teamPersonPO.getId()));
                    RolePO rolePO = rolePOMapper.selectByPrimaryKey(teamPersonPO.getRoleId());
                    if (rolePO != null) {
                        teamPersonBean.setRole(rolePO);
                    }
                    TeamPO teamPO = teamPOMapper.selectByPrimaryKey(teamPersonPO.getTeamId());
                    if (teamPO != null) {
                        teamBean = new PersonDO.TeamPersonBean.TeamBean();
                        teamBean.setId(String.valueOf(teamPO.getId()));
                        teamBean.setName(teamPO.getName());
                        teamPersonBean.setTeam(teamBean);
                        teamPersonBeans.add(teamPersonBean);
                    }
                }
            }
            personDO.setTeam_person(teamPersonBeans);
            return personDO;
        } else {
            logger.error("personDO 为空，peId:{}", peId);
            return null;
        }

    }
}
