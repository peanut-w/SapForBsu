package com.haiqiu.cfadata.service.impl;


import com.haiqiu.cfadata.dao.CountryPOMapper;
import com.haiqiu.cfadata.poentity.CountryPO;
import com.haiqiu.cfadata.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * Created by peanut on 2019/6/5 上午11:30
 */
@Service
public class CountryServiceImpl implements CountryService {
    private static Logger logger = LoggerFactory.getLogger(CountryServiceImpl.class);
    @Autowired
    private CountryPOMapper countryPOMapper;


    @Override
    public List<CountryPO> countryPOList() {
        List<CountryPO> list = null;
        try {
            list = countryPOMapper.selectAll();
            if (list != null && list.size() != 0) {
                return list;
            } else {
                logger.error("country-list is null,未查询到国家列表信息!");
                return null;
            }
        } catch (Exception e) {
            logger.error("countryPOList接口异常{}", e);
            return null;
        }

    }
}
