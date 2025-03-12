package com.example.trpg.dao.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MapTitle implements Serializable {
    private Integer id;

    private Integer trapFlag;

    private Integer floor;

    private String pattern;

    private String relatedEvents;

    private String name;

    private Integer enabled;

    private static final long serialVersionUID = 1L;
}