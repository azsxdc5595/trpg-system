package com.example.trpg.web.mapTitle.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.trpg.dao.mapper.MapTitleMapper;
import com.example.trpg.dao.mapper.customize.MapTitleCustomizeMapper;
import com.example.trpg.dao.model.MapTitle;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MapTitleService {

    private final MapTitleCustomizeMapper mapTitleCustomizeMapper;
    private final MapTitleMapper mapTitleMapper;

    public Page<MapTitle> getMapTitlesByPage(int page, int pageSize) {
        // 創建 PageRequest 物件，從 0 開始計算頁碼
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page - 1 是因為頁數從 0 開始
        // 查詢玩家資料
        List<MapTitle> mapTitles = mapTitleCustomizeMapper.mapTitleList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageSize());
        // 查詢玩家總數量
        long total = mapTitleCustomizeMapper.countMapTitles();

        // 創建 Page 物件並返回
        return new PageImpl<>(mapTitles, pageable, total);
    }

    public void save(MapTitle mapTitle) {
        mapTitleMapper.insert(mapTitle);
    }

    public MapTitle toEdit(int id) {
        MapTitle mapTitle = mapTitleMapper.selectByPrimaryKey(id);
        return mapTitle;
    }

    public void edit(MapTitle mapTitle) {
        mapTitleMapper.updateByPrimaryKeySelective(mapTitle);
    }

    public void delete(int id) {
        mapTitleMapper.deleteByPrimaryKey(id);
    }

}
