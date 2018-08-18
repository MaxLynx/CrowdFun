package edu.crowdFun.model;


import java.util.Date;

public class Idea {
    private int id;
    private String title;
    private String description;
    private double rating;
    private double targetSum;
    private double currentSum;
    private User user;
    private Date endDate;
    private int voiceCount;
    private Category category;
    private String photoUrl;
    private String videoUrl;

    public Idea(){}
    public Idea(String title, String description, double rating, double targetSum, double currentSum,
                User user, Date endDate, int voiceCount, Category category, String photoUrl, String videoUrl){
        this.title = title;
        this.description = description;
        this.rating = rating;
        this.targetSum = targetSum;
        this.currentSum = currentSum;
        this.user = user;
        this.endDate = endDate;
        this.voiceCount = voiceCount;
        this.category = category;
        this.photoUrl = photoUrl;
        this.videoUrl = videoUrl;
    }

    public int getID(){
        return id;
    }
    public void setID(int id){
        this.id = id;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    public Double getRating(){
        return rating;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public Double getTargetSum(){
        return targetSum;
    }
    public void setTargetSum(double targetSum){
        this.targetSum = targetSum;
    }
    public Double getCurrentSum(){
        return currentSum;
    }
    public void setCurrentSum(double currentSum){
        this.currentSum = currentSum;
    }
    public User getUser(){
        return user;
    }
    public void setUser(User user){
        this.user = user;
    }
    public Date getEndDate(){
        return endDate;
    }
    public void setEndDate(Date endDate){
        this.endDate = endDate;
    }
    public int getVoiceCount(){
        return voiceCount;
    }
    public void setVoiceCount(int voiceCount){
        this.voiceCount = voiceCount;
    }
    public Category getCategory(){
        return category;
    }
    public void setCategory(Category category){
        this.category = category;
    }
    public String getPhotoUrl(){
        return photoUrl;
    }
    public void setPhotoUrl(String photoUrl){
        this.photoUrl = photoUrl;
    }
    public String getVideoUrl(){
        return videoUrl;
    }
    public void setVideoUrl(String videoUrl){
        this.videoUrl = videoUrl;
    }
}
