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
public class Item implements Serializable {
    private String uid;

    private String name;

    private String description;

    private String category;

    private static final long serialVersionUID = 1L;
}