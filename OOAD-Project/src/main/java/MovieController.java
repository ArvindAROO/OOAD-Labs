
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import javax.swing.JOptionPane;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */

public final class MovieController {
    //private final User user;
    private final MovieView mov;
    private final Login log;



    public MovieController(MovieView m, Login l) {
    //    this.user = u;
        this.mov = m;
        this.log = l;
        initMovieView();
    }

    public void initMovieView() {
        mov.setVisible(true);
    }


    public void initMovieController() {

        mov.getSearchSaveButton().addActionListener(e -> searchMovie());
        mov.getRatingSaveButton().addActionListener(e -> addRating());
        mov.getCommentSaveButton().addActionListener(e -> addComment());
        mov.getAddCastSaveButton().addActionListener(e -> addActor());
    }

    public void searchMovie() {
        try
        {   
//            JOptionPane.showMessageDialog(null, "hello");
            Connection con = Database.getInstance().getConnection();
            Statement stmt=(Statement)con.createStatement();
//            
            String SQL = "select movieid, title, year, genre, description from movies where title = '"+ mov.getSearchTextfield().getText()+"';";
            ResultSet rs = stmt.executeQuery(SQL);
//            JOptionPane.showMessageDialog(null, rs);
            while (rs.next()) {
                String title = rs.getString("title");
//                JOptionPane.showMessageDialog(null, title);
                mov.setNameTextfield(title);
                int year = rs.getInt("year");
                mov.setYearTextfield(String.valueOf(year));
                String genre = rs.getString("genre");
                mov.setGenreTextfield(genre);
                String description = rs.getString("description");
                mov.setDescriptionTextArea(description);
                String movieid = rs.getString("movieid");
                mov.setMovieIDSTextField(movieid);
                System.out.println(title + ", " + year + ", " + genre +
                                   ", " + description);
            }  
            
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
    
private void addRating(){
    try{
        Connection con = Database.getInstance().getConnection();
        Statement stmt=(Statement)con.createStatement();
//        JOptionPane.showMessageDialog(null, log.getEmailTextfield().getText());
        String search="select userid from moviedatabase.user where email = '"+log.getEmailTextfield().getText()+"';";
        ResultSet rs = stmt.executeQuery(search);
        
        while(rs.next()){
            String userID = rs.getString("userid");
            int r = Integer.parseInt(mov.getRatingTextfield().getText());
//            JOptionPane.showMessageDialog(null, userID);        

            String insert="INSERT INTO moviedatabase.ratings VALUES('"+userID+"','"
                                                        +mov.getMovieIDTextfield().getText()+"',"
                                                        +r+");";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Rating Added");
        }
        
        
        
    }
    catch(SQLException e) {
            while (e != null) {
                System.out.println("\n Message: " + e.getMessage());
                System.out.println("\n SQLState: " + e.getSQLState());
                System.out.println("\n ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
}}    

private void addComment(){
    try{
        Connection con = Database.getInstance().getConnection();
        Statement stmt=(Statement)con.createStatement();
        
        String search="select userid from user where email = '"+log.getEmailTextfield().getText()+"';";
        ResultSet rs = stmt.executeQuery(search);

        while(rs.next()){
            String userID = rs.getString("userid");
        
            Random rnd = new Random();
            int number = rnd.nextInt(999999);
            String num = String.format("%06d", number);


            String insert="INSERT INTO comments VALUES('"+num+"','"+userID+"','"
                                                        +mov.getMovieIDTextfield().getText()+"','"
                                                        +mov.getCommentTextArea().getText()+"');";
            stmt.executeUpdate(insert);
            JOptionPane.showMessageDialog(null, "Comment Added");

        }
        
        
        
        
        
    }
    catch(SQLException e) {
            while (e != null) {
                System.out.println("\n Message: " + e.getMessage());
                System.out.println("\n SQLState: " + e.getSQLState());
                System.out.println("\n ErrorCode: " + e.getErrorCode());
                e = e.getNextException();
            }
}  


}

private void addActor(){
    CastView ca = new CastView();
    CastController cas = new CastController(ca);
    cas.initCastController();
}

}
