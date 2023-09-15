package com.mehmet.kbvdemo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowDto
{
  private Long unitId;
  private String unitName;
  private String depName;
  private Long depId;

}
