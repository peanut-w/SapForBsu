package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.SportPO;

public interface SportPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SportPO record);

    int insertSelective(SportPO record);

    SportPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SportPO record);

    int updateByPrimaryKey(SportPO record);
}
