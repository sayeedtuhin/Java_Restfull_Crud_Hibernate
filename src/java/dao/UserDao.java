/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.User;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import util.CountryNotFoundException;
import util.HibernateUtil;

/**
 *
 * @author sakib
 */
public class UserDao {
    public List<User> getAllUsers() {
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        Query query=s.createQuery("from User");
        List<User> uList=query.list();
        s.close();
        return uList;
    }
    
    public List<User> getUser(int id)  {
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        Query q=s.createQuery("from User where id=?");
        q.setParameter(0, id);
        List<User> iuser=q.list();
        s.close();
        return iuser;
       
    }
    
    public User addUser(User user) {
        user.setUname(user.getUname());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        s.save(user);
        s.getTransaction().commit();
        s.close();
        return user;
        
    }
    
    public List<User> getIUser(int id)  {
       
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        Query q=s.createQuery(" from User where id=?");
        q.setParameter(0, id);
        List<User> uList=q.list();
        s.getTransaction().commit();
        s.close();
        if(uList.size()>0){
            return uList;
        }else{
        throw new CountryNotFoundException("Country with id " + id + " not found");
        }
        
    }
    
     public User updateUser(User user) {
        if (user.getId() <= 0) {
            return null;
        }
       
        user.setUname(user.getUname());
        user.setEmail(user.getEmail());
        user.setPassword(user.getPassword());
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        s.update(user);
        s.getTransaction().commit();
        s.close();
        return user;
        

    }
     
    public void deleteUser(int id) {
        
        SessionFactory sf=HibernateUtil.getSessionFactory();
        Session s=sf.openSession();
        s.beginTransaction();
        Query q=s.createQuery("delete from User where id=?");
        q.setParameter(0, id);
        q.executeUpdate();
         s.getTransaction().commit();
        
        s.close();
        
    } 
}
