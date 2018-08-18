package edu.crowdFun.model;


import java.util.Date;
import java.util.List;

public class User {
    private int id;
    private String nickname;
    private List<Idea> ideas;
    private String firstName;
    private String lastName;
    private String description;
    private Date birthday;
    private String password;
    private String imgUrl;
    private Date joinDate;

    public User(){}
    public User(String nickname, List<Idea> ideas, String firstName, String lastName, String description,
                Date birthday, String password, String imgUrl, Date joinDate){
        this.nickname = nickname;
        this.ideas = ideas;
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
        this.birthday = birthday;
        this.password = password;
        this.imgUrl = imgUrl;
        this.joinDate = joinDate;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getNickname(){
        return nickname;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public List<Idea> getIdeas(){
        return ideas;
    }
    public void setIdeas(List<Idea> ideas){
        this.ideas = ideas;
    }
    public String getFirstName(){
        return firstName;
    }
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Date getBirthday(){
        return birthday;
    }
    public void setBirthday(Date birthday){
        this.birthday = birthday;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public String getImgUrl(){
        return imgUrl;
    }
    public void setImgUrl(String imgUrl){
        this.imgUrl = imgUrl;
    }
    public Date getJoinDate(){
        return joinDate;
    }
    public void setJoinDate(Date joinDate){
        this.joinDate = joinDate;
    }
}