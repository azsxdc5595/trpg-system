package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.SystemCode;

@Mapper
public interface SystemCodeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SystemCode row);

    int insertSelective(SystemCode row);

    SystemCode selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SystemCode row);

    int updateByPrimaryKey(SystemCode row);
}