package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.SystemCode;

@Mapper
public interface SystemCodeCustomizeMapper {

    List<SystemCode> systemCodeList(int offset, int limit);

    long countSystemCodes();
}
