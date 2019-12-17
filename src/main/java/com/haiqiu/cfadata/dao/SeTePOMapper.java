package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.SeTePO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeTePOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeTePO record);

    int insertSelective(SeTePO record);

    SeTePO selectByPrimaryKey(Integer id);

    SeTePO selectBySeAndTeId(@Param("seasonId") Integer seId, @Param("teamId") Integer teId);

    List<Integer> selectTeBySe(@Param("seasonId") Integer seId);

    int updateByPrimaryKeySelective(SeTePO record);

    int updateByPrimaryKey(SeTePO record);

    int deleteAll();
}
