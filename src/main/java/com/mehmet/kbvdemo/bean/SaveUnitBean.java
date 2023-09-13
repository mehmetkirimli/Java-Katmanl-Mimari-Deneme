package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Unit;
import com.mehmet.kbvdemo.mapper.UnitDtoMapper;
import com.mehmet.kbvdemo.repository.UnitRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveUnitBean {
  private final UnitRepository unitRepository;
  private final UnitDtoMapper unitDtoMapper;

  @Transactional
  public ResponseEntity<UnitDto> save (UnitDto unitDto)
  {
    Unit unit = unitDtoMapper.convertToEntity(unitDto);
    Unit saveUnit = unitRepository.save(unit);
    return new ResponseEntity<UnitDto>(unitDtoMapper.map(saveUnit), HttpStatusCode.valueOf(200));
  }

}
