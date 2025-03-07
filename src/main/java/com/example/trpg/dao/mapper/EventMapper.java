package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Event;

@Mapper
public interface EventMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Event row);

    int insertSelective(Event row);

    Event selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Event row);

    int updateByPrimaryKey(Event row);
}