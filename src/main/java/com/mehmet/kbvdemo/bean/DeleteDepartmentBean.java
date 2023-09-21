package com.mehmet.kbvdemo.bean;

import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DeleteDepartmentBean
{
  private final DepartmentRepository departmentRepository;
  public final FindDepartmentBean findDepartmentBean;

  @Transactional
  public ResponseEntity<DepartmentDto> delete(Long id)
  {
    DepartmentDto deleteDepartmentDto = findDepartmentBean.find(id).getBody();

    if(deleteDepartmentDto != null)
    {
      departmentRepository.deleteById(id);
    }
    return new ResponseEntity<DepartmentDto>(deleteDepartmentDto, HttpStatus.valueOf(200));
  }

}
