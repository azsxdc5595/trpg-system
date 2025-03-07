package com.example.trpg.dao.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Item;

@Mapper
public interface ItemMapper {
    int deleteByPrimaryKey(String uid);

    int insert(Item row);

    int insertSelective(Item row);

    Item selectByPrimaryKey(String uid);

    int updateByPrimaryKeySelective(Item row);

    int updateByPrimaryKey(Item row);
}