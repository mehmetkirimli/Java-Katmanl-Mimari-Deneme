package com.mehmet.kbvdemo.repository;

import com.mehmet.kbvdemo.entity.Department;
import com.mehmet.kbvdemo.entity.Unit;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitRepository extends CrudRepository<Unit,Long>
{


  /*@Query("SELECT u FROM Unit u WHERE u.department.id = :departmentId")
  Unit findUnitByDepartment_Id(@Param("departmentId") Long departmentId);*/


}
