package com.haiqiu.cfadata.dao;



import com.haiqiu.cfadata.poentity.CountryPO;

import java.util.List;

public interface CountryPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CountryPO record);

    int insertSelective(CountryPO record);

    CountryPO selectByPrimaryKey(Integer id);

    List<CountryPO> selectAll();

    int updateByPrimaryKeySelective(CountryPO record);

    int updateByPrimaryKey(CountryPO record);
}
