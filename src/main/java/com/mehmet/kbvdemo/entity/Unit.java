package com.mehmet.kbvdemo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
