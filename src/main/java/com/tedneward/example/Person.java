package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  
  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
  }

  public void setSSN(String value) {
    String old = ssn;
    ssn = value;
    
    this.pcs.firePropertyChange("ssn", old, value);
    propertyChangeFired = true;
  }
  public boolean getPropertyChangeFired() {
    return propertyChangeFired;
  }

  public double calculateBonus() {
    return salary * 1.10;
  }
  
  public String becomeJudge() {
    return "The Honorable " + name;
  }
  
  public int timeWarp() {
    return age + 10;
  }
  
  public String tostring() {
    return "{{FIXME}}";
  }

  




  ///////// added by me //////////////
  public String getName() {
    String n = name;
    return n; 
  }

  public int getAge() {
    int a = age;
    return a; 
  }
  public double getSalary() {
    double s = salary;
    return s;
  }

  public String getSsn() {
    String ss = ssn;
    return ss; 
  }

  public void setSalary() {

  }

  public void setAge(int newAge) {
    if (newAge < 0) {
      throw new IllegalArgumentExcecption() //when passed value < 0  
    } else {
      age = newAge; //access global private variable??
    }
  }

  public void setName(String newName) {
    if (newName == null) {
      throw new IllegalArgumentExcecption(); //when passed a null string  
    } else {
      name = newName; 
    }
  }

  public int count() {

  }

  public boolean equals(Person a, Person b) {
    if (a.name == b.name && a.age == b.age) {
      return true; 
    } else {
      return false;
    }
  }

  **public nested class AgeComparator() {}
  **make person comparable() {
    by salary, in descending order
  }

  public static List<Person> getNewardFamily() {
    List<Person> newardFam = new ArrayList<Person>(); 

    //Ted, age 41, salary 250000; 
    //Charlotte, age 43, salary 150000; 
    //Michael, age 22, salary 10000;
    //Matthew, age 15, salary 0.
    newardFam.add(new Person("Ted", 41, 250000.00));
    newardFam.add(new Person("Charlotte", 43, 150000.00));
    newardFam.add(new Person("Michael", 22, 10000.00));
    newardFam.add(new Person("Matthew", 15, 0.00));
    
    return newardFam;
  }


  ////////////////////////////////////





  // PropertyChangeListener support; you shouldn't need to change any of
  // these two methods or the field
  //
  private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
  public void addPropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.addPropertyChangeListener(listener);
  }
  public void removePropertyChangeListener(PropertyChangeListener listener) {
      this.pcs.removePropertyChangeListener(listener);
  }
}
