package com.example.trpg.Service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * SnowflakeService.
 *
 * @author Sero
 * @since 2024/8/22
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class SnowflakeService {

    private final SnowflakeUtils snowflakeUtils;

    public String getSnowNo() {
        return String.valueOf(snowflakeUtils.nextId());
    }

}
