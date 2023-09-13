package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.entity.Unit;
import com.mehmet.kbvdemo.mapper.UnitDtoMapper;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import com.mehmet.kbvdemo.repository.UnitRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.swing.text.html.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindUnitBean {

  private final UnitRepository unitRepository;
  private final UnitDtoMapper unitDtoMapper;
  private  final DepartmentRepository departmentRepository;

  public ResponseEntity<UnitDto> getUnitByDepartmentId(Long id) {

    Optional<Department> departmentDtoResponseEntity = departmentRepository.findById(id);
    Long id1 = departmentDtoResponseEntity.get().getUnit().getId();
    Optional<Unit> unit = unitRepository.findById(id1);

    UnitDto dto = unitDtoMapper.map(unit.get());
    return new ResponseEntity<UnitDto>(dto,HttpStatusCode.valueOf(200));

  }

  public ResponseEntity<UnitDto> find(Long id) {
    return this.getUnitDto(id);
  }

  public ResponseEntity<UnitDto> find(UnitDto unitDto) {
    return this.getUnitDto(unitDto.getId());
  }

  public ResponseEntity<List<UnitDto>> findAll() {
    return new ResponseEntity<List<UnitDto>>(
        unitDtoMapper.mapList((List<Unit>) unitRepository.findAll()), HttpStatusCode.valueOf(200));
  }

  public ResponseEntity<UnitDto> getUnitDto(Long id) {
    ResponseEntity<UnitDto> unitDtoResponseEntity = new ResponseEntity<UnitDto>(
        HttpStatusCode.valueOf(404));
    Optional<Unit> unit = unitRepository.findById(id);
    if (unit.isPresent()) {
      unitDtoResponseEntity = new ResponseEntity<UnitDto>(unitDtoMapper.map(unit.get()),
          HttpStatusCode.valueOf(200));
    }
    return unitDtoResponseEntity;
  }

}
