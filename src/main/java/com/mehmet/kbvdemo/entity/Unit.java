package com.mehmet.kbvdemo.entity;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "unit")
public class Unit implements Serializable
{

  @Id
  @SequenceGenerator(name = "UNIT_ID_GENERATOR",sequenceName = "UNIT_ID_GEN",allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "UNIT_ID_GENERATOR")
  @Column(unique = true, nullable = false)
  private Long id;

  @Column(name="unit_name")
  private String name;

  @Column(name = "creating_date")
  private LocalDate creatingDate;

  //@OneToMany(mappedBy = "unit")
  //private List<Department> departments ;


}
