/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */
public class User{
    String Name;
    String Email;
    String Password;
    String UserID;

    public User( String UserID, String Name, String Email, String Password){
        this.Name = Name;
        this.Email = Email;
        this.Password = Password;
        this.UserID = UserID;
    }

    public String getName(){
        return Name;
    }

    public String getEmail(){
        return Email;
    }

    public String getPassword(){
        return Password;
    }

    public String getUserID(){
        return UserID;
    }

}