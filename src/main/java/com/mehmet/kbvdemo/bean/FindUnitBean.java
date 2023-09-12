package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.mapper.UnitDtoMapper;
import com.mehmet.kbvdemo.repository.UnitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindUnitBean
{
  private final UnitRepository unitRepository;
  private final UnitDtoMapper unitDtoMapper;

  public ResponseEntity<UnitDto> getUnitByDepartmentId(Long id)
  {
    return null;
  }

}
