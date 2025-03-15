package com.example.trpg.web.game.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TempGameMapTitleCheck {
	
	private String snowNo;
	
	private Integer id;
	
    private Integer x;

    private Integer y;

    private Integer floor;
    
    private String icon;

}
