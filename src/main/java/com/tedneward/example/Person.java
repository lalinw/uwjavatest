package com.tedneward.example;

import java.beans.*;
import java.util.*;

public class Person implements Comparable<Person> {
  private int age;
  private String name;
  private double salary;
  private String ssn;
  private boolean propertyChangeFired = false;
  private static int instances;

  public Person() {
    this("", 0, 0.0d);
  }
  
  public Person(String n, int a, double s) {
    name = n;
    age = a;
    salary = s;
    ssn = "";
    instances++;
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

  @Override
  public String toString() {
    //sample => [Person name:Fird Birfle age:20 salary:195750.22]
    String readable = "[Person name:" + name + " age:" + age + " salary:" + salary + "]";
    return readable;
  }

  ///////// added by me //////////////
  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }
  public double getSalary() {
    return this.salary;
  }

  public String getSSN() {
    return this.ssn;
  }

  public void setSalary(double newSalary) {
    if (newSalary < 0.00) {
      throw new IllegalArgumentException();
      //?? would not make sense if salary is negative???  
    } else {
      this.salary = newSalary; //global private variable
    }
  }

  public void setAge(int newAge) {
    if (newAge < 0) {
      throw new IllegalArgumentException("Age must be more than 0."); //when passed value < 0
    } else {
      this.age = newAge;
    }
  }

  public void setName(String newName) {
    if (newName == null) {
      throw new IllegalArgumentException("Name cannot be null."); //when passed a null string
    } else {
      this.name = newName;
    }
  }

  //counts static global field
  public int count() {
    return instances; 
  }

  @Override
  public boolean equals(Object x) {
    if (x instanceof Person) {
      Person p = (Person)x;
      return (this.name.equals(p.name) && this.age == p.age);
    }
    return false;
  }

  public static List<Person> newardFam = new ArrayList<Person>();
    static {
      newardFam.add(new Person("Ted", 41, 250000.00));
      newardFam.add(new Person("Charlotte", 43, 150000.00));
      newardFam.add(new Person("Michael", 22, 10000.00));
      newardFam.add(new Person("Matthew", 15, 0.00));
    }

  public static List<Person> getNewardFamily() {
    return newardFam;
  }

  @Override
  public int compareTo(Person x) {
    //descending order by salary
    double diff = this.salary - x.salary;
    if (diff > 0.00) {
      return -1;
    } else if (diff < 0.00) {
      return 1;
    } else {
      return 0;
    }
  }

  public static class AgeComparator implements Comparator<Person> {
    public int compare(Person a, Person b) {
      //comparator
      //ascending order by age
      return a.age - b.age;
    }
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

