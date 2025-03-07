package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Npc;

@Mapper
public interface NpcCustomizeMapper {

    List<Npc> npcList(int offset, int limit);

    long countNpces();
}
