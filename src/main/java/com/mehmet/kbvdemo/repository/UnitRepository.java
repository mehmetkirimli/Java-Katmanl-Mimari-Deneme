package com.mehmet.kbvdemo.repository;

import com.mehmet.kbvdemo.dto.ShowInterface;
import com.mehmet.kbvdemo.entity.Unit;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends CrudRepository<Unit,Long>
{

  @Query(
      nativeQuery = true,
      value = " SELECT u.id as unitid,u.unit_name as unitname,d.name as depname,d.id as depid FROM DEPARTMENT d\n"
          + "RIGHT JOIN UNIT u ON u.id=d.unit_id\n"
          + "ORDER BY u.id "

  )
  List<ShowInterface> getListUnitAndDepartment();


}
