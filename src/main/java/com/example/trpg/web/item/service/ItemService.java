package com.example.trpg.web.item.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.trpg.Service.SnowflakeService;
import com.example.trpg.dao.mapper.ItemMapper;
import com.example.trpg.dao.mapper.customize.ItemCustomizeMapper;
import com.example.trpg.dao.model.Item;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemCustomizeMapper itemCustomizeMapper;
    private final ItemMapper itemMapper;
    private final SnowflakeService snowflakeService;

    public Page<Item> getItemsByPage(int page, int pageSize) {
        // 創建 PageRequest 物件，從 0 開始計算頁碼
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page - 1 是因為頁數從 0 開始
        // 查詢玩家資料
        List<Item> items = itemCustomizeMapper.itemList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageSize());
        // 查詢玩家總數量
        long total = itemCustomizeMapper.countItems();

        // 創建 Page 物件並返回
        return new PageImpl<>(items, pageable, total);
    }

    public void save(Item item) {
        item.setUid(snowflakeService.getSnowNo());
        itemMapper.insert(item);
    }

    public Item toEdit(String uid) {
        Item item = itemMapper.selectByPrimaryKey(uid);
        return item;
    }

    public void edit(Item item) {
        itemMapper.updateByPrimaryKeySelective(item);
    }

    public void delete(String uid) {
        itemMapper.deleteByPrimaryKey(uid);
    }

}
