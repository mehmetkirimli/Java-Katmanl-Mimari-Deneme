package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Unit;
import com.mehmet.kbvdemo.mapper.UnitDtoMapper;
import com.mehmet.kbvdemo.repository.UnitRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteUnitBean
{
  private final UnitRepository unitRepository;
  private final UnitDtoMapper unitDtoMapper;

  @Transactional
  public ResponseEntity<UnitDto> deleteById(Long id)
  {
    Optional<Unit> unit = unitRepository.findById(id);
    if(unit.isPresent())
    {
      unitRepository.delete(unit.get());
    }
    return new ResponseEntity<UnitDto>(unitDtoMapper.map(unit.get()), HttpStatusCode.valueOf(200));

  }

}
