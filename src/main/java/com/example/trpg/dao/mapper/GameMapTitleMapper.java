package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.GameMapTitle;

@Mapper
public interface GameMapTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(GameMapTitle row);

    int insertSelective(GameMapTitle row);

    GameMapTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(GameMapTitle row);

    int updateByPrimaryKey(GameMapTitle row);
}