package com.haiqiu.cfadata.dao;



import com.haiqiu.cfadata.poentity.MatchEventPO;

import java.util.List;

public interface MatchEventPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MatchEventPO record);

    int insertSelective(MatchEventPO record);

    MatchEventPO selectByPrimaryKey(long id);

    List<MatchEventPO> selectByMaId(Integer maId);


    int updateByPrimaryKeySelective(MatchEventPO record);

    int updateByPrimaryKey(MatchEventPO record);

    int deleteAll();
}
