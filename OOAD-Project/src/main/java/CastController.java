
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */

public final class CastController {
    //private final User user;
    private final CastView cast;
//    private final Login log;



    public CastController(CastView c) {
    //    this.user = u;
        this.cast = (CastView) c;
        initCastView();
    }

  

    public void initCastView() {
        cast.setVisible(true);
    }


    public void initCastController() {

        cast.getActorSaveButton().addActionListener(e -> addActor());
        cast.getDirectorSaveButton().addActionListener(e -> addDirector());
    }
    
private void addActor(){
    try
        {
//            JOptionPane.showMessageDialog(null, "here");                

            Actor a = new Actor(cast.getNameTextfield().getText(), Integer.parseInt(cast.getAgeTextfield().getText()), cast.getCastIDTextfield().getText());
            
            
            Connection con = Database.getInstance().getConnection();
            Statement stmt=(Statement)con.createStatement();

            //JOptionPane.showMessageDialog(null, "here");                

            String insert="INSERT INTO moviedatabase.cast VALUES('"+a.getCastID()+"','Actor','"
                                                                    +a.getName()+"','"
                                                                    +a.getAge()+"');";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Actor Added to database");


        }
        catch (SQLException e) {
            while (e != null) {
                System.out.println("\n Message: " + e.getMessage());
                System.out.println("\n SQLState: " + e.getSQLState());
                System.out.println("\n ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }

        }  
}    

private void addDirector(){
    try
        {
//            JOptionPane.showMessageDialog(null, "here");                

            Director a = new Director(cast.getNameTextfield().getText(), Integer.parseInt(cast.getAgeTextfield().getText()), cast.getCastIDTextfield().getText());
            
            
            Connection con = Database.getInstance().getConnection();
            Statement stmt=(Statement)con.createStatement();

            //JOptionPane.showMessageDialog(null, "here");                

            String insert="INSERT INTO moviedatabase.cast VALUES('"+a.getCastID()+"','Director','"
                                                                    +a.getName()+"','"
                                                                    +a.getAge()+"');";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Director Added to database");


        }
        catch (SQLException e) {
            while (e != null) {
                System.out.println("\n Message: " + e.getMessage());
                System.out.println("\n SQLState: " + e.getSQLState());
                System.out.println("\n ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }

        }

}
}
