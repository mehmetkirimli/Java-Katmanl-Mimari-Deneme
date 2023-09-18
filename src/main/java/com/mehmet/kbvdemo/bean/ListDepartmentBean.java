package com.mehmet.kbvdemo.bean;


import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.filter.DepartmentFilter;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.mapper.DepartmentDtoMapper;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import com.mehmet.kbvdemo.spec.DepartmentSpec;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ListDepartmentBean
{
  private final DepartmentRepository departmentRepository;
  private final DepartmentDtoMapper departmentDtoMapper;


  public ResponseEntity<List<DepartmentDto>> filterBySpec(DepartmentFilter filter) // BURDAKİ HATA NE ????
  {
    //ResponseEntity<List<DepartmentDto>> response = new ResponseEntity<List<DepartmentDto>>(departmentDtoMapper.mapList(departmentRepository.findAll(DepartmentSpec.findByFilter(filter))),
    //    HttpStatusCode.valueOf(200));


    return null;
  }

}
