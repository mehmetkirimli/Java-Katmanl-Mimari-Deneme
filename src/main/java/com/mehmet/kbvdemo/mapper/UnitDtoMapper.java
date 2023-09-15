package com.mehmet.kbvdemo.mapper;


import com.mehmet.kbvdemo.dto.ScreenDto;
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

  public ScreenDto justOnlyNameMap(Unit unit,Department department)
  {
    return ScreenDto.builder()
        .depId(department.getId())
        .depName(department.getName())
        .unitName(unit.getName())
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
