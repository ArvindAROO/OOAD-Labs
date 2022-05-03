/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */



public class Director implements Cast{
    private final String name;
    private final int age;
    private final String castID;

    public Director(String name, int age, String castID){
        this.name = name;
        this.age = age;
        this.castID = castID;
    }

    @Override
    public String getCastID(){
        return castID;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getAge(){
        return age;
    }
}