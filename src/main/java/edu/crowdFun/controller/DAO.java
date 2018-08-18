package edu.crowdFun.controller;

import edu.crowdFun.model.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DAO {
    private static SessionFactory factory;

    public DAO(){
        try {
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Failed to create sessionFactory object." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    public User getUser(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        User user = null;

        try {
            tx = session.beginTransaction();
            user = (User)session.get(User.class, id);
            List<Object[]> allIdeas = session.createQuery(
                    "FROM Idea AS idea INNER JOIN idea.user").list();
            List<Idea> userIdeas = new ArrayList<Idea>();
            for(Object[] objectPair : allIdeas){
                if(((User)objectPair[1]).getID() == user.getID())
                userIdeas.add((Idea)objectPair[0]);
            }
            user.setIdeas(userIdeas);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }
    public Idea getIdea(int id){
        Session session = factory.openSession();
        Transaction tx = null;
        Idea idea = null;

        try {
            tx = session.beginTransaction();
            List<Object[]> results = session.createQuery(
                    "FROM Idea AS idea INNER JOIN idea.user INNER JOIN idea.category").list();
            for(Object[] pair : results){
                Idea currentIdea = (Idea)pair[0];
                if(currentIdea.getID() == id) {
                    idea = currentIdea;
                    idea.setUser((User) pair[1]);
                    idea.setCategory((Category) pair[2]);
                    break;
                }
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return idea;
    }
    public List<Idea> getIdeas(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Idea> ideas = new ArrayList<Idea>();

        try {
            tx = session.beginTransaction();
            List<Object[]> results = session.createQuery(
                    "FROM Idea AS idea INNER JOIN idea.user INNER JOIN idea.category").list();
            for(Object[] pair : results){
                    Idea idea = (Idea)pair[0];
                    idea.setUser((User) pair[1]);
                    idea.setCategory((Category) pair[2]);
                ideas.add(idea);
            }
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ideas;
    }
    public List<Category> getCategories(){
        Session session = factory.openSession();
        Transaction tx = null;
        List<Category> categories = null;

        try {
            tx = session.beginTransaction();
            categories = session.createQuery(
                    "FROM Category").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return categories;
    }
    public Integer addIdea(String title, String description, double rating,
                           double targetSum, double currentSum,
                           int userID, Date endDate, int voiceCount,
                           int categoryID, String photoUrl, String videoUrl){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer ideaID = null;
        try {
            tx = session.beginTransaction();
            User user = (User)session.get(User.class, userID);
            Category category = (Category)session.get(Category.class, categoryID);
            Idea idea = new Idea(title, description, rating, targetSum, currentSum,
            user, endDate, voiceCount, category, photoUrl, videoUrl);
            ideaID = (Integer) session.save(idea);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ideaID;
    }

    public Integer addUser(String nickname, List<Idea> ideas, String firstName,
                           String lastName, String description,
                           Date birthday, String password, String imgUrl, Date joinDate){
        Session session = factory.openSession();
        Transaction tx = null;
        Integer userID = null;
        try {
            tx = session.beginTransaction();
            User user = new User(nickname, ideas, firstName,
                    lastName, description,
                    birthday, password, imgUrl, joinDate);
            userID = (Integer) session.save(user);
            tx.commit();
        } catch (HibernateException e) {
            if (tx!=null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return userID;
    }
}
