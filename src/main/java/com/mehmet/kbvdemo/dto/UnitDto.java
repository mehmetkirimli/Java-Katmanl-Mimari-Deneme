package com.mehmet.kbvdemo.dto;

import com.mehmet.kbvdemo.entity.Unit;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UnitDto
{
  private Long id;
  private String name;
  private LocalDate creatingDate;

  public Unit convertToEntity(UnitDto unitDto)
  {
    Unit unit = new Unit();

    unit.setId(unitDto.getId());
    unit.setName(unitDto.getName());
    unit.setCreatingDate(unitDto.getCreatingDate());
    return unit;
  }

}
