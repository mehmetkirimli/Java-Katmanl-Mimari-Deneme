package com.mehmet.kbvdemo.service;

import com.mehmet.kbvdemo.dto.ScreenDto;
import com.mehmet.kbvdemo.dto.ShowDto;
import com.mehmet.kbvdemo.dto.ShowInterface;
import com.mehmet.kbvdemo.dto.UnitDto;
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
  ResponseEntity<UnitDto> deleteById (Long id);

  ResponseEntity<List<ShowInterface>> listUnitAndDepartment();
  ResponseEntity<ScreenDto> kafa (Long id);
}
