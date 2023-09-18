package com.mehmet.kbvdemo.spec;

import com.mehmet.kbvdemo.dto.filter.DepartmentFilter;
import com.mehmet.kbvdemo.entity.Department;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;

public class DepartmentSpec implements Specification<Department>
{
  @Override
  public Predicate toPredicate(Root<Department> root, CriteriaQuery<?> query,
      CriteriaBuilder criteriaBuilder)
  {
    return null;
  }


  public static Specification<Department> findByFilter(DepartmentFilter filter){


    return ((root, query, criteriaBuilder) ->
    {
      Predicate p = criteriaBuilder.disjunction();
      List<Predicate> predicateList = new ArrayList<>();


      if (filter!=null)
      {
        if(filter.getConsTeam()!=null)
        {
          predicateList.add(criteriaBuilder.equal(root.get("consTeam"),filter.getConsTeam()));
        }
        if(filter.getDepartmentGroup()!=null)
        {
          predicateList.add(criteriaBuilder.equal(root.get("departmentGroup"),filter.getDepartmentGroup()));
        }
        if(filter.getName()!=null)
        {
          predicateList.add(criteriaBuilder.like(root.get("name"),"%" + filter.getName() + "%"));
        }
      }

      p.getExpressions().add(criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()])));
      return p;
    }
    );
  }



}