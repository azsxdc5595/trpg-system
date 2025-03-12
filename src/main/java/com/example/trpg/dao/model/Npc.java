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
public class Npc implements Serializable {
    private String uid;

    private String name;

    private String race;

    private String profession;

    private Integer strength;

    private Integer dexterity;

    private Integer intelligence;

    private Integer luck;

    private Integer health;

    private static final long serialVersionUID = 1L;
}