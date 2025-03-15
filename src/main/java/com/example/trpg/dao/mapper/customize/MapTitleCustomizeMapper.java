package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.MapTitle;

@Mapper
public interface MapTitleCustomizeMapper {

    List<MapTitle> mapTitleList(int offset, int limit);

    long countMapTitles();

	MapTitle getStartMapTitle();

	MapTitle getRandomEnabledTile();
}
