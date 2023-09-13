package com.mehmet.kbvdemo.controller;


import com.mehmet.kbvdemo.dto.ScreenDto;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.entity.Unit;
import com.mehmet.kbvdemo.service.UnitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/unit")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UnitController
{
  public final UnitService unitService;

  @GetMapping(value = "/getByDepartmentId")
  public ResponseEntity<UnitDto> getUnitByDepartmentId(@RequestParam("id")Long id)
  {
    return unitService.findByDepartmentId(id);
  }

  @GetMapping(value = "/getAll")
  public ResponseEntity<List<UnitDto>> getAll()
  {
    return unitService.findAll();
  }

  @GetMapping(value = "/byId")
  public ResponseEntity<UnitDto> getUnitById(@RequestParam ("id") Long id)
  {
    return unitService.find(id);
  }

  @PostMapping(value = "/save")
  public ResponseEntity<UnitDto> save (@RequestBody UnitDto unitDto)
  {
    return unitService.save(unitDto);
  }

  @GetMapping(value = "/onlyName")
  public ResponseEntity<ScreenDto> kafamizaGore (@RequestParam("id") Long id )
  {
    return unitService.kafa(id);
  }

}
