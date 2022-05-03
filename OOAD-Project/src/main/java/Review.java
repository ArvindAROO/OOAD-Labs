/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author anura
 */


class Rating implements Movie{
    private String movieid;
    private final String title;
    private final String genre;
    private final int year;
    private final String description;
    private final String rating;

    public Rating(String title, String genre, int year, String description, String rating){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.rating = rating;
    }
    public String getMovieID(){
        return movieid;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getGenre(){
        return genre;
    }

    @Override
    public int getYear(){
        return year;
    }

    @Override
    public String getDescription(){
        return description;
    }

    public String getRating(){
        return rating;
    }
}


class Comment implements Movie{
    private String movieid;
    private final String title;
    private final String genre;
    private final int year;
    private final String description;
    private final String rating;

    public Comment(String title, String genre, int year, String description, String rating){
        this.title = title;
        this.genre = genre;
        this.year = year;
        this.description = description;
        this.rating = rating;
    }
    public String getMovieID(){
        return movieid;
    }

    @Override
    public String getTitle(){
        return title;
    }

    @Override
    public String getGenre(){
        return genre;
    }

    @Override
    public int getYear(){
        return year;
    }

    @Override
    public String getDescription(){
        return description;
    }

    public String getComments(){
        return rating;
    }
}