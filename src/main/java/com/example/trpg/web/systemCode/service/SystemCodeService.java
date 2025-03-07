package com.example.trpg.web.systemCode.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.trpg.dao.mapper.SystemCodeMapper;
import com.example.trpg.dao.mapper.customize.SystemCodeCustomizeMapper;
import com.example.trpg.dao.model.SystemCode;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SystemCodeService {

    private final SystemCodeCustomizeMapper systemCodeCustomizeMapper;
    private final SystemCodeMapper systemCodeMapper;

    public Page<SystemCode> getSystemCodesByPage(int page, int pageSize) {
        // 創建 PageRequest 物件，從 0 開始計算頁碼
        Pageable pageable = PageRequest.of(page - 1, pageSize); // page - 1 是因為頁數從 0 開始
        // 查詢玩家資料
        List<SystemCode> systemCodes = systemCodeCustomizeMapper.systemCodeList(pageable.getPageNumber() * pageable.getPageSize(),
                pageable.getPageSize());
        // 查詢玩家總數量
        long total = systemCodeCustomizeMapper.countSystemCodes();

        // 創建 Page 物件並返回
        return new PageImpl<>(systemCodes, pageable, total);
    }

    public void save(SystemCode systemCode) {
        systemCodeMapper.insert(systemCode);
    }

    public SystemCode toEdit(int id) {
        SystemCode systemCode = systemCodeMapper.selectByPrimaryKey(id);
        return systemCode;
    }

    public void edit(SystemCode systemCode) {
        systemCodeMapper.updateByPrimaryKeySelective(systemCode);
    }

    public void delete(int id) {
        systemCodeMapper.deleteByPrimaryKey(id);
    }

}
