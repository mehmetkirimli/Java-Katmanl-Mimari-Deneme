package com.mehmet.kbvdemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
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

  public String toString(){
    return "Department {" +
            "id = " + id +
            ",consTeam = " + consTeam +

            ",name = " + name +
            "}";
  }


}
