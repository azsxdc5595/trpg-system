package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.TempGameMapTitle;

@Mapper
public interface TempGameMapTitleMapper {
    int insert(TempGameMapTitle row);

    int insertSelective(TempGameMapTitle row);
}