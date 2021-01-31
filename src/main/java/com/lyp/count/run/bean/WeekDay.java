package com.lyp.count.run.bean;

public enum WeekDay{
  MONDAY("一"), TUESDAY("二"), WEDNESDAY("三"), THURSDAY("四"), FRIDAY("五"), SATURDAY("六"), SUNDAY("日");

  private String name;

  WeekDay(String name){
    this.name = name;
  }

  public String getName(){
    return name;
  }

}