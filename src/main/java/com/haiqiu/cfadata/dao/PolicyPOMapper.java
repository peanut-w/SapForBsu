package com.haiqiu.cfadata.dao;

import com.haiqiu.cfadata.poentity.PolicyPO;
import com.haiqiu.cfadata.poentity.PolicyPOExample;

import java.util.List;

public interface PolicyPOMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PolicyPO record);

    int insertSelective(PolicyPO record);

    List<PolicyPO> selectByExample(PolicyPOExample example);

    PolicyPO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PolicyPO record);

    int updateByPrimaryKey(PolicyPO record);
}
