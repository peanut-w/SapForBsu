package com.haiqiu.cfadata.dao;

import com.haiqiu.cfadata.poentity.TeamPersonPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TeamPersonPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamPersonPO record);

    int insertSelective(TeamPersonPO record);

    TeamPersonPO selectByPrimaryKey(Integer id);

    TeamPersonPO selectByTeAndPeFromTo(@Param("teamId") Integer teamId, @Param("personId") Integer personId, @Param("start") Date start, @Param("end") Date end);

    List<TeamPersonPO> selectByPeId(Integer peId);

    List<TeamPersonPO> selectByTeamTime(@Param("teamId") Integer teamId, @Param("start") Date start, @Param("end") Date end);

    int updateByPrimaryKeySelective(TeamPersonPO record);

    int updateByPrimaryKey(TeamPersonPO record);

    int deleteAll();
}
