
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Singleton.java to edit this template
 */

/**
 *
 * @author anura
 */

//Singleton Class 

public class Database {

    private static Database dbIsntance;
    private static Connection con ;
//    private static Statement stmt;


    private Database() {
      // private constructor //
    }

    public static Database getInstance(){
    if(dbIsntance==null){
        dbIsntance= new Database();
    }
    return dbIsntance;
    }

    public  Connection getConnection(){

        if(con==null){
            try {
                String host = "jdbc:mysql://localhost:3306/moviedatabase";
                String username = "jeevan";
                String password = "Anurag_Khanra@123!";
                con = DriverManager.getConnection( host, username, password );
            } catch (SQLException ex) {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return con;
    }
}