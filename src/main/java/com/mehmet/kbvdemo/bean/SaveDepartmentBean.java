package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.mapper.DepartmentDtoMapper;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SaveDepartmentBean // extends ResponsePayload tipini kurmam lazım .... Sor ekibe .
{
  private final DepartmentRepository repo;
  private final DepartmentDtoMapper mapper;
  private final  FindDepartmentBean findBean;

  @Transactional
  public ResponseEntity<DepartmentDto> save (DepartmentDto departmentDto)
  {
    //ResponseEntity responseEntity = findBean.find(departmentDto.getId());
    //try{
    //if(responseEntity==null)
    //{
      Department department = mapper.convertToEntity(departmentDto);
      Department saveDepartment = repo.save(department);
      return new ResponseEntity<>(mapper.map(saveDepartment), HttpStatus.CREATED);

    //}
    //}catch (Exception e)
    //{
    //  System.out.println("hata var");
    //  return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //}

    //return responseEntity;

  }


}
