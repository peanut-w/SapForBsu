package com.haiqiu.cfadata.dao;



import com.haiqiu.cfadata.poentity.CompetitionPO;

import java.util.List;

public interface CompetitionPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(CompetitionPO record);

    int insertSelective(CompetitionPO record);

    CompetitionPO selectByPrimaryKey(Integer id);

    List<CompetitionPO> selectAll();

    int updateByPrimaryKeySelective(CompetitionPO record);

    int updateByPrimaryKey(CompetitionPO record);

    int deleteAll();
}
