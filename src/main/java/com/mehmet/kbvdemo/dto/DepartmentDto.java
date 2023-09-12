package com.mehmet.kbvdemo.dto;

import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.mapper.UnitDtoMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class DepartmentDto {

  private Long id;
  private String name;
  private String consTeam;
  private Long departmentGroup;
  private UnitDto unitDto;


  public Department convertToEntity(DepartmentDto departmentDto)
  {
    Department department = new Department();

    department.setId(departmentDto.getId());
    department.setName(departmentDto.getName());
    department.setDepartmentGroup(departmentDto.getDepartmentGroup());
    department.setConsTeam(departmentDto.getConsTeam());
    department.setUnit(departmentDto.getUnitDto() != null ? new UnitDtoMapper().convertToEntity(departmentDto.getUnitDto()) : null);

    return department ;
  }


}
