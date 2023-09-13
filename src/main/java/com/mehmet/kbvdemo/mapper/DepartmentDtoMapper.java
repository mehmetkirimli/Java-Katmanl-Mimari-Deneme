package com.mehmet.kbvdemo.mapper;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.entity.Department;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;


@Component
public class DepartmentDtoMapper {

  public DepartmentDto map(Department department)
  {
    return DepartmentDto.builder()
        .name(department.getName())
        .departmentGroup(department.getDepartmentGroup())
        .id(department.getId())
        .consTeam(department.getConsTeam())
        //.unitId(department.getUnit().getId())
        .build();
  }

  public List<DepartmentDto> mapList(List<Department> list) {
    List<DepartmentDto> mappedList = new ArrayList<>();

    for(Department department : list)
    {
      mappedList.add(this.map(department));
    }
    return mappedList;
  }

  public DepartmentDto mapWithObject(Department department)
  {
    return DepartmentDto.builder()
        .name(department.getName())
        .departmentGroup(department.getDepartmentGroup())
        .id(department.getId())
        .consTeam(department.getConsTeam())
        .unitDto(department.getUnit()==null ? null : new UnitDtoMapper().map(department.getUnit()))
        .build();
  }

  public Department convertToEntity(DepartmentDto dto){
    return dto.convertToEntity(dto);
  }

}
