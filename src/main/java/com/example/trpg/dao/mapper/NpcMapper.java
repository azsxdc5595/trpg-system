package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Npc;

@Mapper
public interface NpcMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Npc row);

    int insertSelective(Npc row);

    Npc selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Npc row);

    int updateByPrimaryKey(Npc row);
}