package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.TeamPO;

import java.util.List;

public interface TeamPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TeamPO record);

    int insertSelective(TeamPO record);

    TeamPO selectByPrimaryKey(Integer id);

    List<TeamPO> selectByClub(Integer clubId);

    int updateByPrimaryKeySelective(TeamPO record);
    int updateByPrimaryKey(TeamPO record);

    int deleteAll();

}
