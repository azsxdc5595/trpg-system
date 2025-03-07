package com.example.trpg.web.event.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.trpg.Service.SnowflakeService;
import com.example.trpg.dao.mapper.EventMapper;
import com.example.trpg.dao.mapper.customize.EventCustomizeMapper;
import com.example.trpg.dao.model.Event;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EventService {

    private final EventCustomizeMapper eventCustomizeMapper;
    private final EventMapper eventMapper;
    private final SnowflakeService snowflakeService;

    public Page<Event> getEventsByPage(int page, int pageSize) {
        // 創建 PageRequest 物件，從 0 開始計算頁碼
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page - 1 是因為頁數從 0 開始
        // 查詢玩家資料
        List<Event> events = eventCustomizeMapper.eventList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageSize());
        // 查詢玩家總數量
        long total = eventCustomizeMapper.countEvents();

        // 創建 Page 物件並返回
        return new PageImpl<>(events, pageable, total);
    }

    public void save(Event event) {
        event.setUid(snowflakeService.getSnowNo());
        eventMapper.insert(event);
    }

    public Event toEdit(String uid) {
        Event event = eventMapper.selectByPrimaryKey(uid);
        return event;
    }

    public void edit(Event event) {
        eventMapper.updateByPrimaryKeySelective(event);
    }

    public void delete(String uid) {
        eventMapper.deleteByPrimaryKey(uid);
    }

}
