package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.PersonDetailPO;

public interface PersonDetailPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PersonDetailPO record);

    int insertSelective(PersonDetailPO record);

    PersonDetailPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PersonDetailPO record);

    int updateByPrimaryKey(PersonDetailPO record);
}
