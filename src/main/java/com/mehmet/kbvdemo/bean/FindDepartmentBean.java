package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.mapper.DepartmentDtoMapper;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class FindDepartmentBean {

  private final DepartmentRepository repo;
  private final DepartmentDtoMapper mapper;
  HttpStatus OK = HttpStatus.valueOf(200);
  HttpStatus NOTFOUND = HttpStatus.valueOf(404);



  public ResponseEntity<DepartmentDto> find (DepartmentDto departmentDto)
  {
    return getDepartmentDto(departmentDto.getId());
  }

  public ResponseEntity<DepartmentDto> find(Long id){
    return getDepartmentDto(id);
  }

  public ResponseEntity<List<DepartmentDto>> findAll() //list
  {
    return new ResponseEntity<List<DepartmentDto>>(mapper.mapList((List<Department>) repo.findAll()),HttpStatus.valueOf(200));
  }


  public ResponseEntity<DepartmentDto> getDepartmentDto(Long id) {
    ResponseEntity<DepartmentDto> responseEntity = new ResponseEntity<>(NOTFOUND);
    try {
      Optional<Department> department = repo.findById(id);
      if (department.isPresent()) // isPresent metodu , department nesnesi null değilse true döner.
      {
        responseEntity = new ResponseEntity<>(mapper.map(department.get()), OK);
        return responseEntity;
      }
    } catch (Exception e) {
      return responseEntity;
    }
    return responseEntity;
  }
}
