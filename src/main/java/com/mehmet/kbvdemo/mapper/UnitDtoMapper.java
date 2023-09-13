package com.mehmet.kbvdemo.mapper;


import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.entity.Unit;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UnitDtoMapper
{

  public UnitDto map(Unit unit)
  {
    return UnitDto.builder()
        .name(unit.getName())
        .id(unit.getId())
        .creatingDate(unit.getCreatingDate())
        .build();
  }

  public List<UnitDto> mapList(List<Unit> list) {
    List<UnitDto> mappedList = new ArrayList<>();

    for(Unit unit : list)
    {
      mappedList.add(this.map(unit));
    }
    return mappedList;
  }

  public Unit convertToEntity(UnitDto dto)
  {
    return dto.convertToEntity(dto);
  }


}
