package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.SeasonPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface SeasonPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SeasonPO record);

    int insertSelective(SeasonPO record);

    SeasonPO selectByPrimaryKey(Integer id);

    List<SeasonPO> selectByCoId(Integer coId);

    List<SeasonPO> selectByTime(@Param("start") Date start, @Param("end") Date end);

    int updateByPrimaryKeySelective(SeasonPO record);

    int updateByPrimaryKey(SeasonPO record);

    void deleteAll();
}
