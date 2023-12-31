package com.mehmet.kbvdemo.controller;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.filter.DepartmentFilter;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import com.mehmet.kbvdemo.service.DepartmentService;
import java.util.Iterator;
import java.util.List;
import javax.annotation.security.RolesAllowed;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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


  // this method can be accessed by user whose role is User
  @GetMapping(value = "/byId")
  @RolesAllowed("user")
  public ResponseEntity<DepartmentDto> getDepartmentById(@RequestParam("id") Long id)
  {
    return departmentService.find(id);
  }



  // this method can be accessed by user whose role is Admin
 @GetMapping(value = "/getAll")
 @RolesAllowed("admin")
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

  @DeleteMapping(value = "/delete")
  public ResponseEntity<DepartmentDto> deleteDepartment(@RequestParam ("id") Long id)
  {
    return departmentService.delete(id);
  }

  @PostMapping(value = "/filterBySpec")
  public ResponseEntity<List<DepartmentDto>> filterBySpec (@RequestBody DepartmentFilter filter)
  {
    return departmentService.filterBySpec(filter);
  }

}
