/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */

//package db;

import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.swing.JOptionPane;

import javax.swing.JOptionPane;

public final class UserController {
    //private final User user;
    private final Register reg;
    private final Login log;
    private final MovieView mov;




    public UserController(Login l, Register v, MovieView m) {
    //    this.user = u;
        this.reg = v;
        this.log = l;
        this.mov = m;
        initRegister();
    }

    public void initRegister() {
        reg.setVisible(true);
        mov.setVisible(false);
    }


    public void initController() {

        reg.getRegisterSaveButton().addActionListener(e -> registerUser());
        reg.getLoginSaveButton().addActionListener(e -> loginSwitch());
        log.getLoginSaveButton().addActionListener(e -> loginUser());
    //    view.getClearSaveButton().addActionListener(e -> clearDetails());
    }

    private void registerUser() {
        try
        {   
    //        JOptionPane.showMessageDialog(null, "here");  
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedatabase","anuragkhanra","Anurag_Khanra@123!");
            
            User u = new User(reg.getUserIDTextfield().getText(), reg.getNameTextfield().getText(), reg.getEmailTextfield().getText(), reg.getPasswordTextfield().getText());
            
            
            Connection con = Database.getInstance().getConnection();
            Statement stmt=(Statement)con.createStatement();

    //        JOptionPane.showMessageDialog(null, "here");                

            String insert="INSERT INTO moviedatabase.user VALUES('"+u.getUserID()+"','"
                                                                    +u.getName()+"','"
                                                                    +u.getEmail()+"','"
                                                                    +u.getPassword()+"');";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "You are registered");


        }
        catch (SQLException e) {
            while (e != null) {
                System.out.println("\n Message: " + e.getMessage());
                System.out.println("\n SQLState: " + e.getSQLState());
                System.out.println("\n ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }

        }}

    private void loginSwitch(){
        reg.setVisible(false);
        log.setVisible(true);
    }

    private void loginUser(){

        // Check Username and Password
        String email = log.getEmailTextfield().getText();
        String password = log.getPasswordTextfield().getText();

        try
        {   
            Connection con = Database.getInstance().getConnection();
            Statement stmt = con.createStatement();
            String SQL = "SELECT * FROM user WHERE email ='" + email + "' && password='" + password+ "';";

            stmt.executeQuery(SQL);

        }
        catch (SQLException e) 
        {
            System.out.println(e);
            JOptionPane.showMessageDialog(null, "Invalid ID/Password"); 
        }    
        
        log.setVisible(false);
        mov.setVisible(true); 
        MovieController m = new MovieController(mov, log);
        m.initMovieController();
        

    }

}