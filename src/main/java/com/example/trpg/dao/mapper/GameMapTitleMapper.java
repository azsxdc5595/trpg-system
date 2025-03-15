package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.GameMapTitle;

@Mapper
public interface GameMapTitleMapper {
    int insert(GameMapTitle row);

    int insertSelective(GameMapTitle row);
}