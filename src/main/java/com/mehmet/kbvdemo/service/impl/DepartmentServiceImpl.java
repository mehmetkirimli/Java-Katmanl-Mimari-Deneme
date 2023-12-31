package com.mehmet.kbvdemo.service.impl;

import com.mehmet.kbvdemo.bean.DeleteDepartmentBean;
import com.mehmet.kbvdemo.bean.FindDepartmentBean;
import com.mehmet.kbvdemo.bean.ListDepartmentBean;
import com.mehmet.kbvdemo.bean.SaveDepartmentBean;
import com.mehmet.kbvdemo.bean.UpdateDepartmentBean;
import com.mehmet.kbvdemo.dto.DepartmentDto;
import com.mehmet.kbvdemo.dto.filter.DepartmentFilter;
import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.service.DepartmentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DepartmentServiceImpl implements DepartmentService {

  private final FindDepartmentBean findDepartmentBean;
  private final SaveDepartmentBean saveDepartmentBean;
  private final UpdateDepartmentBean updateDepartmentBean;
  private final DeleteDepartmentBean deleteDepartmentBean;
  private final ListDepartmentBean listDepartmentBean;

  @Override
  public ResponseEntity<DepartmentDto> save(DepartmentDto departmentDto) {
    return saveDepartmentBean.save(departmentDto);
  }

  @Override
  public ResponseEntity<DepartmentDto> find(DepartmentDto departmentDto) {
    return findDepartmentBean.find(departmentDto);
  }

  @Override
  public ResponseEntity<DepartmentDto> find(Long id) {
    return findDepartmentBean.find(id);
  }

  @Override
  public ResponseEntity<List<DepartmentDto>> findAll() {
    return findDepartmentBean.findAll();
  }

  @Override
  public ResponseEntity<DepartmentDto> update(DepartmentDto departmentDto)
  {
    return updateDepartmentBean.updateDepartment(departmentDto);
  }

  @Override
  public ResponseEntity<DepartmentDto> delete(Long id) {
    return deleteDepartmentBean.delete(id);
  }

  @Override
  public ResponseEntity<List<DepartmentDto>> filterBySpec(DepartmentFilter filter)
  {
    return listDepartmentBean.filterBySpec(filter);
  }
}
