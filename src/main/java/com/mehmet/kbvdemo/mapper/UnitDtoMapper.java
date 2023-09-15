package com.mehmet.kbvdemo.mapper;


import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.ScreenDto;
import com.mehmet.kbvdemo.dto.ShowDto;
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

  public ScreenDto justOnlyNameMap(Unit unit,Department department)
  {
    return ScreenDto.builder()
        .depId(department.getId())
        .depName(department.getName())
        .unitName(unit.getName())
        .build();
  }

  public ShowDto unitAndDepartmentMap(Unit unit,Department department)
  {
    return ShowDto.builder()
        .unitId(unit.getId())
        .unitName(unit.getName())
        .depName(department.getName())
        .depId(department.getId())
        .build();
  }

  public List<ShowDto> listUnitAndDepartmentMap(List<ShowDto> list) // repodan gelen veri dto tipinde değil aslında , burada bi hatam var. SOR ???
  {
    List<ShowDto> mappedList = new ArrayList<>();

    /*
    for (ShowDto showDto : list)
    {
      mappedList.add(this.unitAndDepartmentMap();
    }

     */
    return mappedList;
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
