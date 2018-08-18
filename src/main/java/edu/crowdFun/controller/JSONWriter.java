package edu.crowdFun.controller;


import edu.crowdFun.model.Category;
import edu.crowdFun.model.Idea;
import edu.crowdFun.model.User;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


public class JSONWriter {
        private DAO dao;

        public JSONWriter(){
            dao = new DAO();
        }

        public void writeUser(int id) {
            User user = dao.getUser(id);
            JSONObject obj = new JSONObject();
            obj.put("id", user.getID());
                JSONArray ideas = new JSONArray();
                for (Idea idea : user.getIdeas()) {
                    JSONObject ideaObj = new JSONObject();
                    ideaObj.put("name", idea.getTitle());
                    ideaObj.put("id", idea.getID());
                    ideas.add(ideaObj);
                }
                obj.put("ideas", ideas);
            obj.put("nickname", user.getNickname());
            obj.put("first_name", user.getFirstName());
            obj.put("last_name", user.getLastName());
            obj.put("description", user.getDescription());
            obj.put("birthday", toISO8601UTC(user.getBirthday()));
            obj.put("img", user.getImgUrl());
            obj.put("join_date", toISO8601UTC(user.getJoinDate()));
            writeToFile(obj, "D:\\user"+user.getID()+".json");
        }
    public void writeIdea(int id) {
        Idea idea = dao.getIdea(id);
        JSONObject obj = new JSONObject();
        obj.put("id", idea.getID());
        obj.put("title", idea.getTitle());
        obj.put("description", idea.getDescription());
        obj.put("rating", idea.getRating());
        obj.put("target_sum", idea.getTargetSum());
        obj.put("current_sum", idea.getCurrentSum());
        obj.put("user_id", idea.getUser().getID());
        obj.put("end_date", idea.getEndDate());
        obj.put("voice_count", idea.getVoiceCount());
        obj.put("category_id", idea.getCategory().getID());
        obj.put("img", idea.getPhotoUrl());
        obj.put("video", idea.getVideoUrl());
        writeToFile(obj, "D:\\idea"+idea.getID()+".json");
    }
    public void writeCategories() {
        List<Category> categories = dao.getCategories();
        try (FileWriter file = new FileWriter("D:\\categories.json")) {
            file.write("");
            for (Category category : categories) {
                JSONObject obj = new JSONObject();
                obj.put("id", category.getID());
                obj.put("name", category.getName());
                file.append(obj.toJSONString() + "\r\n");
            }
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void writeIdeas() {
        List<Idea> ideas = dao.getIdeas();
        try (FileWriter file = new FileWriter("D:\\ideas.json")) {
            file.write("");
            for (Idea idea : ideas) {
                JSONObject obj = new JSONObject();
                obj.put("id", idea.getID());
                obj.put("title", idea.getTitle());
                obj.put("description", idea.getDescription());
                obj.put("rating", idea.getRating());
                obj.put("target_sum", idea.getTargetSum());
                obj.put("current_sum", idea.getCurrentSum());
                obj.put("user_id", idea.getUser().getID());
                obj.put("end_date", idea.getEndDate());
                obj.put("voice_count", idea.getVoiceCount());
                obj.put("category_id", idea.getCategory().getID());
                obj.put("img", idea.getPhotoUrl());
                obj.put("video", idea.getVideoUrl());
                file.append(obj.toJSONString() + "\r\n");
            }
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
        private void writeToFile(JSONObject object, String filename){
            try (FileWriter file = new FileWriter(filename)) {

                file.write(object.toJSONString());
                file.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print(object);
        }

        private static String toISO8601UTC(Date date) {
            TimeZone tz = TimeZone.getTimeZone("UTC");
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
            df.setTimeZone(tz);
            return df.format(date);
        }
    }

