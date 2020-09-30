package com;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Andrey Klyuev on 27/09/2020.
 */
public class SimpleEmployee {

  private long id;
  private String name;

  public SimpleEmployee(long id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}
