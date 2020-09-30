package com;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Andrey Klyuev on 27/09/2020.
 */
public class Employee implements Serializable {

  private long id;
  private String name;
  private Integer size;
  private Sex sex;
  private List<Employee> folks;

  public Employee(long id, String name, Integer size, Sex sex, List<Employee> folks) {
    this.id = id;
    this.name = name;
    this.size = size;
    this.sex = sex;
    this.folks = folks;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSize() {
    return size;
  }

  public void setSize(Integer size) {
    this.size = size;
  }

  public Sex getSex() {
    return sex;
  }

  public void setSex(Sex sex) {
    this.sex = sex;
  }

  public List<Employee> getFolks() {
    return folks;
  }

  public void setFolks(List<Employee> folks) {
    this.folks = folks;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
