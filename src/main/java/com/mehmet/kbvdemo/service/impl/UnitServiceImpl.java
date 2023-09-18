package com.mehmet.kbvdemo.service.impl;

import com.mehmet.kbvdemo.bean.DeleteUnitBean;
import com.mehmet.kbvdemo.bean.FindUnitBean;
import com.mehmet.kbvdemo.bean.SaveUnitBean;
import com.mehmet.kbvdemo.bean.UpdateUnitBean;
import com.mehmet.kbvdemo.dto.ScreenDto;
import com.mehmet.kbvdemo.dto.ShowInterface;
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
  private final UpdateUnitBean updateUnitBean;
  private final DeleteUnitBean deleteUnitBean;



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
  public ResponseEntity<UnitDto> update(UnitDto unitDto)
  {
    return updateUnitBean.update(unitDto);
  }

  @Override
  public ResponseEntity<UnitDto> delete(Long id) {
    return null;
  }

  @Override
  public ResponseEntity<UnitDto> deleteById(Long id)
  {
    return deleteUnitBean.deleteById(id);
  }

  @Override
  public ResponseEntity<List<ShowInterface>> listUnitAndDepartment()
  {
    return findUnitBean.listUnitAndDepartment();
  }

  @Override
  public ResponseEntity<ScreenDto> kafa(Long id) {
    return findUnitBean.kafamızaGore(id);
  }
}
