package com.mehmet.kbvdemo.controller;


import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.service.UnitService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UnitController
{
  public final UnitService unitService;

  @GetMapping(value = "/getByDepartmentId")
  public ResponseEntity<UnitDto> getUnitByDepartmentId(Long id)
  {
    return unitService.findByDepartmentId(id);
  }

  @PostMapping(value = "/save")
  public ResponseEntity<UnitDto> save (UnitDto unitDto)
  {
    return unitService.save(unitDto);
  }

}
