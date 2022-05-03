/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */
public class App {
    public static void main(String[] args) {
       Register v = new Register();
       Login l = new Login();
       MovieView mov = new MovieView();
       UserController c = new UserController(l, v, mov);
       c.initController();
    }
}


