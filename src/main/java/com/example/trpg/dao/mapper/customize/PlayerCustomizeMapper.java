package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Player;

@Mapper
public interface PlayerCustomizeMapper {

    List<Player> playerList(int offset, int limit);

    long countPlayers();
}
