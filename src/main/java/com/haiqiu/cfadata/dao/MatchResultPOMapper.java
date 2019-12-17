package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.poentity.MatchResultPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchResultPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchResultPO record);

    int insertSelective(MatchResultPO record);

    MatchResultPO selectByPrimaryKey(Integer id);

    MatchResultPO selectByMaIdAndPlace(@Param("maId") Integer maId, @Param("place") String place);

    MatchResultPO selectByAll(MatchResultPO matchResultPO);

    List<MatchResultPO> selectByMaId(Integer maId);

    int updateByPrimaryKeySelective(MatchResultPO record);

    int updateByPrimaryKey(MatchResultPO record);

    int deleteAll();
}
