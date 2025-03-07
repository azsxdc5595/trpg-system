package com.example.trpg.web.npc.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.trpg.Service.SnowflakeService;
import com.example.trpg.dao.mapper.NpcMapper;
import com.example.trpg.dao.mapper.customize.NpcCustomizeMapper;
import com.example.trpg.dao.model.Npc;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NpcService {

    private final NpcCustomizeMapper npcCustomizeMapper;
    private final NpcMapper npcMapper;
    private final SnowflakeService snowflakeService;

    public Page<Npc> getNpcsByPage(int page, int pageSize) {
        // 創建 PageRequest 物件，從 0 開始計算頁碼
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page - 1 是因為頁數從 0 開始
        // 查詢玩家資料
        List<Npc> npcs = npcCustomizeMapper.npcList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageSize());
        // 查詢玩家總數量
        long total = npcCustomizeMapper.countNpces();

        // 創建 Page 物件並返回
        return new PageImpl<>(npcs, pageable, total);
    }

    public void save(Npc npc) {
        npc.setUid(snowflakeService.getSnowNo());
        npcMapper.insert(npc);
    }

    public Npc toEdit(String uid) {
        Npc npc = npcMapper.selectByPrimaryKey(uid);
        return npc;
    }

    public void edit(Npc npc) {
        npcMapper.updateByPrimaryKeySelective(npc);
    }

    public void delete(String uid) {
        npcMapper.deleteByPrimaryKey(uid);
    }

}
