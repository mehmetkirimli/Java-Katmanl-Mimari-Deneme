package com.mehmet.kbvdemo.service.impl;

import com.mehmet.kbvdemo.bean.FindUnitBean;
import com.mehmet.kbvdemo.bean.SaveUnitBean;
import com.mehmet.kbvdemo.dto.UnitDto;
import com.mehmet.kbvdemo.service.UnitService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UnitServiceImpl implements UnitService {
  private final FindUnitBean findUnitBean;
  private final SaveUnitBean savedUnitBean;
  //private final UpdateUnitBean updateUnitBean;
  //private final DeleteUnitBean deleteUnitBean;



  @Override
  public ResponseEntity<UnitDto> save(UnitDto unitDto) {

    return savedUnitBean.save(unitDto);
  }

  @Override
  public ResponseEntity<UnitDto> find(UnitDto unitDto) {
    return null;
  }

  @Override
  public ResponseEntity<UnitDto> find(Long id) {

    return findUnitBean.find(id);
  }

  @Override
  public ResponseEntity<UnitDto> findByDepartmentId(Long id)
  {
    return findUnitBean.getUnitByDepartmentId(id);
  }

  @Override
  public ResponseEntity<List<UnitDto>> findAll() {

    return findUnitBean.findAll();
  }

  @Override
  public ResponseEntity<UnitDto> update(UnitDto unitDto) {
    return null;
  }

  @Override
  public ResponseEntity<UnitDto> delete(Long id) {
    return null;
  }
}
