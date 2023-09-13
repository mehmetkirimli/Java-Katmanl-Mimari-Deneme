package com.mehmet.kbvdemo.service;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Unit;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface UnitService
{
  ResponseEntity<UnitDto> save (UnitDto unitDto);

  ResponseEntity<UnitDto> find (UnitDto unitDto);

  ResponseEntity<UnitDto> find (Long id);

  ResponseEntity<UnitDto> findByDepartmentId(Long id);

  ResponseEntity<List<UnitDto>> findAll();

  ResponseEntity<UnitDto> update (UnitDto unitDto);

  ResponseEntity<UnitDto> delete (Long id);

}
