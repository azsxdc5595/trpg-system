package com.example.trpg.web.player.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.trpg.Service.SnowflakeService;
import com.example.trpg.dao.mapper.PlayerMapper;
import com.example.trpg.dao.mapper.customize.PlayerCustomizeMapper;
import com.example.trpg.dao.model.Player;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerCustomizeMapper playerCustomizeMapper;
    private final PlayerMapper playerMapper;
    private final SnowflakeService snowflakeService;

    public Page<Player> getPlayersByPage(int page, int pageSize) {
        // 創建 PageRequest 物件，從 0 開始計算頁碼
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page - 1 是因為頁數從 0 開始
        // 查詢玩家資料
        List<Player> players = playerCustomizeMapper.playerList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageSize());
        // 查詢玩家總數量
        long total = playerCustomizeMapper.countPlayers();

        // 創建 Page 物件並返回
        return new PageImpl<>(players, pageable, total);
    }

    public void save(Player player) {
        player.setUid(snowflakeService.getSnowNo());
        playerMapper.insert(player);
    }

    public Player toEdit(String uid) {
        Player player = playerMapper.selectByPrimaryKey(uid);
        return player;
    }

    public void edit(Player player) {
        playerMapper.updateByPrimaryKeySelective(player);
    }

    public void delete(String uid) {
        playerMapper.deleteByPrimaryKey(uid);
    }

}
