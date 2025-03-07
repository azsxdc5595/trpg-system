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
public class SystemCode implements Serializable {
    private Integer id;

    private String cname;

    private Integer enabled;

    private static final long serialVersionUID = 1L;
}