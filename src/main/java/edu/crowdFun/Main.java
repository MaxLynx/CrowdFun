package edu.crowdFun;

import edu.crowdFun.controller.DAO;
import edu.crowdFun.controller.JSONWriter;
import edu.crowdFun.model.Category;
import edu.crowdFun.model.Idea;
import edu.crowdFun.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        new JSONWriter().writeUser(1);
/*        new DAO().addUser("user0", new ArrayList<Idea>(), "Max",
                "Maximov", "have large ambitions",
                new Date(1), "0000", "", new Date(1000));
        new DAO().addIdea("TEST2", "test2", 5.0,
        100.00, 1.00,
        1, new Date(766666), 1,
        1, "", "");*/
    }

}
