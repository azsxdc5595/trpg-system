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
public class Event implements Serializable {
    private String uid;

    private String name;

    private String description;

    private String category;

    private String eventGroup;

    private Integer level;

    private Integer enabled;

    private static final long serialVersionUID = 1L;
}