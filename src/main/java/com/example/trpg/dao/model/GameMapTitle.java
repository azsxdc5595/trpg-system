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
public class GameMapTitle implements Serializable {
    private Integer id;

    private Integer mapTitleId;

    private String relatedEvents;

    private Integer x;

    private Integer y;

    private Integer floor;

    private static final long serialVersionUID = 1L;
}