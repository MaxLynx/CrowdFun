package edu.crowdFun.model;


public class Category {
    private int id;
    private String name;

    public Category(){}
    public Category(String name){
        this.name = name;
    }
    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
}
