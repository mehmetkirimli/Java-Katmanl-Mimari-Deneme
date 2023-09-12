package com.mehmet.kbvdemo.bean;


import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.mapper.DepartmentDtoMapper;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import jakarta.transaction.Transactional;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UpdateDepartmentBean
{
  private final DepartmentRepository repository;
  private  final DepartmentDtoMapper mapper;
  public final FindDepartmentBean findDepartmentBean;
  public final SaveDepartmentBean saveDepartmentBean;

  @Transactional
  public ResponseEntity<DepartmentDto> updateDepartment(DepartmentDto departmentDto)
  {
    ResponseEntity<DepartmentDto> currentDepartment = findDepartmentBean.find(departmentDto.getId());

    if (currentDepartment != null)
    {
      departmentDto.setId(currentDepartment.getBody().getId());
    }
    else
    {
      departmentDto.setId(null);
    }

    Department save = repository.save(mapper.convertToEntity(departmentDto));

    return new ResponseEntity<DepartmentDto>(mapper.map(save), HttpStatusCode.valueOf(200));




  }

}
