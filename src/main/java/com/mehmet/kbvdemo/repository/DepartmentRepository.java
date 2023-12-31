package com.mehmet.kbvdemo.repository;


import com.mehmet.kbvdemo.entity.Department;
import java.lang.annotation.Native;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long>,JpaSpecificationExecutor<Department>
{
  @Override
  List<Department> findAll(Specification<Department> spec);
}
