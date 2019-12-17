package com.haiqiu.cfadata.dao;


import com.haiqiu.cfadata.doentity.LineUpNameDO;
import com.haiqiu.cfadata.doentity.PlayListDO;
import com.haiqiu.cfadata.poentity.MatchLineUpPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MatchLineUpPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchLineUpPO record);

    int insertSelective(MatchLineUpPO record);

    MatchLineUpPO selectByPrimaryKey(Integer id);

    MatchLineUpPO selectByTeamAndPlayer(@Param("maId") Integer maId, @Param("teamId") Integer teamId, @Param("playerId") Integer playerId);

    int updateByPrimaryKeySelective(MatchLineUpPO record);

    int updateByPrimaryKey(MatchLineUpPO record);

    List<PlayListDO> selectPlaysByMaId(Integer maId);

    List<LineUpNameDO> selectLineUpNameByMa(Integer maId);

}
