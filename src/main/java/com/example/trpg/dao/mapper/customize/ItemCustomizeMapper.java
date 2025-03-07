package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Item;

@Mapper
public interface ItemCustomizeMapper {

    List<Item> itemList(int offset, int limit);

    long countItems();
}
