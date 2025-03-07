package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.MapTitle;

@Mapper
public interface MapTitleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MapTitle row);

    int insertSelective(MapTitle row);

    MapTitle selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MapTitle row);

    int updateByPrimaryKey(MapTitle row);
}