package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.ScreenDto;
import com.mehmet.kbvdemo.dto.ShowInterface;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.entity.Unit;
import com.mehmet.kbvdemo.mapper.UnitDtoMapper;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import com.mehmet.kbvdemo.repository.UnitRepository;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    return new ResponseEntity<UnitDto>(dto,HttpStatus.valueOf(200));

  }
  public  ResponseEntity<ScreenDto> kafamızaGore(Long id)
  {

    Optional<Department> departmentDtoResponseEntity = departmentRepository.findById(id);

    Long id1 = departmentDtoResponseEntity.get().getUnit().getId();
    Optional<Unit> unit = unitRepository.findById(id1);

    ScreenDto screenDto = unitDtoMapper.justOnlyNameMap(unit.get(),departmentDtoResponseEntity.get());

    return new ResponseEntity<ScreenDto>(screenDto,HttpStatus.valueOf(200));
  }

  public ResponseEntity<List<ShowInterface>> listUnitAndDepartment()
  {
    List<ShowInterface> list =  unitRepository.getListUnitAndDepartment();

    return new ResponseEntity<List<ShowInterface>>(list,HttpStatus.valueOf(200));
  }

  public ResponseEntity<UnitDto> find(Long id) {
    return this.getUnitDto(id);
  }

  public ResponseEntity<UnitDto> find(UnitDto unitDto) {
    return this.getUnitDto(unitDto.getId());
  }

  public ResponseEntity<List<UnitDto>> findAll() {
    return new ResponseEntity<List<UnitDto>>(
        unitDtoMapper.mapList((List<Unit>) unitRepository.findAll()), HttpStatus.valueOf(200));
  }

  public ResponseEntity<UnitDto> getUnitDto(Long id) {
    ResponseEntity<UnitDto> unitDtoResponseEntity = new ResponseEntity<UnitDto>(
        HttpStatus.valueOf(404));
    Optional<Unit> unit = unitRepository.findById(id);
    if (unit.isPresent()) {
      unitDtoResponseEntity = new ResponseEntity<UnitDto>(unitDtoMapper.map(unit.get()),
          HttpStatus.valueOf(200));
    }
    return unitDtoResponseEntity;
  }

}
