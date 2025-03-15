package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.TempGameMapTitle;

@Mapper
public interface TempGameMapTitleCustomizeMapper {

    List<TempGameMapTitle> list(String snowNo);
}
