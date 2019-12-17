package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.ClubPO;

public interface ClubPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ClubPO record);

    int insertSelective(ClubPO record);

    ClubPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ClubPO record);

    int updateByPrimaryKey(ClubPO record);

    int deleteAll();
}
