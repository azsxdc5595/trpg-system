package com.example.trpg.dao.mapper.customize;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.trpg.dao.model.Event;

@Mapper
public interface EventCustomizeMapper {

    List<Event> eventList(int offset, int limit);

    long countEvents();
}
