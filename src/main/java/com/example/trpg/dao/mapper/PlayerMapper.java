package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Player;

@Mapper
public interface PlayerMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Player row);

    int insertSelective(Player row);

    Player selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Player row);

    int updateByPrimaryKey(Player row);
}