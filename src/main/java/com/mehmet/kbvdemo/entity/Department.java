package com.mehmet.kbvdemo.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "DEPARTMENT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor


public class Department implements Serializable {


  @Id
  @SequenceGenerator(name = "DEPARTMENT_ID_GENERATOR",sequenceName = "DEPARTMENT_ID_GEN",allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "DEPARTMENT_ID_GENERATOR")
  @Column(unique = true,nullable = false)
  private Long id;

  @Column(length = 30)
  private String name;

  @Column(length = 1)
  private String consTeam ;

  @Column(name = "DEPARTMENT_GROUP")
  private Long departmentGroup;


  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "UNIT_ID")
  private Unit unit;

  public String toString(){
    return "Department {" +
            "id = " + id +
            ",consTeam = " + consTeam +

            ",name = " + name +
            "}";
  }


}
