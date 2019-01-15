/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDao;
import entity.User;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author sakib
 */
@Path("/users")
public class UserService {
    UserDao userdao=new UserDao();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUser(){
        List<User> listofUser=userdao.getAllUsers();
        return listofUser;
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> getUserById(@PathParam("id") int id) {
        return userdao.getIUser(id);
        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public User addCountry(User user) {
        return userdao.addUser(user);
    }
    
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    public User updateUser(User user) {
        return userdao.updateUser(user);
        
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public void deleteCountry(@PathParam("id") int id) {
        userdao.deleteUser(id);
        

    }
}
