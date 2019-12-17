package com.haiqiu.cfadata.dao;



import com.haiqiu.cfadata.poentity.MatchPO;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface MatchPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchPO record);

    int insertSelective(MatchPO record);

    MatchPO selectByPrimaryKey(Integer id);

    List<MatchPO> selectBySe(Integer seId);

    List<MatchPO> selectByRoId(Integer roId);

    List<MatchPO> selectByRoAndLm(@Param("roId") Integer roId, @Param("lm") Date lm);

    int updateByPrimaryKeySelective(MatchPO record);

    int updateByPrimaryKey(MatchPO record);

    int deleteAll();
}
