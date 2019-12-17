package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.PersonPO;

public interface PersonPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonPO record);

    int insertSelective(PersonPO record);

    PersonPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonPO record);

    int updateByPrimaryKey(PersonPO record);

    int deleteAll();

}
