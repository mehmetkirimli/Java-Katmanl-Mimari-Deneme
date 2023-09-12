package com.mehmet.kbvdemo.controller;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import com.mehmet.kbvdemo.service.DepartmentService;
import java.util.Iterator;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/department") // "api/department" olabilir kontrol edersin ofiste
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentController
{
  private final DepartmentService departmentService;

  @GetMapping(value = "/byId")
  public ResponseEntity<DepartmentDto> getDepartmentById(@RequestParam("id") Long id)
  {
    return departmentService.find(id);
  }

 @GetMapping(value = "/getAll")
  public ResponseEntity<List<DepartmentDto>> getAll()
  {
    return departmentService.findAll();
  }

  @PostMapping(value = "/save")
  public ResponseEntity<DepartmentDto> saveDepartment(@RequestBody DepartmentDto departmentDto)
  {
    return departmentService.save(departmentDto);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<DepartmentDto> updateDepartment(@RequestBody DepartmentDto departmentDto)
  {
    return departmentService.update(departmentDto);
  }
}
