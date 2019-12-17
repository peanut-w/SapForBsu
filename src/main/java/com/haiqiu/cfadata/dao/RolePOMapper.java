package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.RolePO;

public interface RolePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RolePO record);

    int insertSelective(RolePO record);

    RolePO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(RolePO record);

    int updateByPrimaryKey(RolePO record);
}
