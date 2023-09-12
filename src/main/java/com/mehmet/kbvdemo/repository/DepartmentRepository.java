package com.mehmet.kbvdemo.repository;


import com.mehmet.kbvdemo.entity.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface DepartmentRepository extends CrudRepository<Department,Long>
{

}
