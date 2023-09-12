package com.mehmet.kbvdemo.service;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.entity.Department;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface DepartmentService
{
  ResponseEntity<DepartmentDto> save (DepartmentDto departmentDto);

  ResponseEntity<DepartmentDto> find (DepartmentDto departmentDto);

  ResponseEntity<DepartmentDto> find (Long id);

  ResponseEntity<List<DepartmentDto>> findAll();

  ResponseEntity<DepartmentDto> update(DepartmentDto departmentDto);

  ResponseEntity<DepartmentDto> delete(Long id);


}
