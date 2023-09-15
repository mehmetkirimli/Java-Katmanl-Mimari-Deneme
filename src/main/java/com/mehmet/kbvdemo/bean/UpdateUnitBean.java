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
public class UpdateUnitBean
{
  private final UnitRepository unitRepository;
  private final UnitDtoMapper unitDtoMapper;

  @Transactional
  public ResponseEntity<UnitDto> update (UnitDto unitDto)
  {
    Optional<Unit> unit = unitRepository.findById(unitDto.getId());

    if(unit.isPresent())
    {
      unitDto.setId(unit.get().getId());
    }
    else
    {
      unitDto.setId(null);
    }
    Unit save = unitRepository.save(unitDtoMapper.convertToEntity(unitDto));

    return new ResponseEntity<UnitDto>(unitDtoMapper.map(save), HttpStatusCode.valueOf(200));
  }

}
