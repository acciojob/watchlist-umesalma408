package com.driver;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Repository
@Component
public class MovieRepository {
    HashMap<String, Movie> moviesInDB = new HashMap<>();
    HashMap<Director, List<String>> ListOfDirectorsInDB = new HashMap<>();

    public void addMovie(Movie movie) {
        moviesInDB.put(movie.getName(), movie);
    }

    public void addDirector(Director director) {
        List<String> movieListOfDirectors = new LinkedList<String>();
        ListOfDirectorsInDB.put(director, movieListOfDirectors);
    }

    public void addMovieDirectorPairToDB(String movieName, String directorName) {
        for (Director director : ListOfDirectorsInDB.keySet()) {
            if (Objects.equals(director.getName(), directorName)) {
                List<String> temp;
                temp = ListOfDirectorsInDB.get(director);
                temp.add(movieName);
                ListOfDirectorsInDB.put(director, temp);
                break;
            }
        }

    }

    public Movie getMovieDirectorPairFromDB(String name) {
        return moviesInDB.get(name);
    }


    public Director getDirectorByNameFromDB(String name) {
        for (Director director : ListOfDirectorsInDB.keySet()) {
            if (Objects.equals(director.getName(), name)) {
                return director;
            }
        }
        return null;
    }

    public List<String> getMoviesByDirectorNameFromDB(String dName) {
        for(Director director:ListOfDirectorsInDB.keySet()){
            if(Objects.equals(director.getName(),dName)){
                return ListOfDirectorsInDB.get(director);
            }
        }
        return null;
    }
    public List<String> findAllMoviesFromDB() {
        LinkedList<String> listOfMovies=new LinkedList<>();
        for(Movie movie:moviesInDB.values()){
            listOfMovies.add(movie.getName());
        }
        return listOfMovies;
    }
    public void deleteDirectorByNameFromDB(String dName) {
        for(Director director:ListOfDirectorsInDB.keySet()){
            if(Objects.equals(director.getName(),dName)){
                List<String> temp;
                temp=ListOfDirectorsInDB.get(director);
                for(String movie:temp){
                    moviesInDB.remove(movie);
                }
                ListOfDirectorsInDB.remove(director);
                break;
            }
        }
    }
    public void deleteAllDirectorsFromDB() {
        for(List<String> temp:ListOfDirectorsInDB.values()){
            for(String movie:temp){
                moviesInDB.remove(movie);
            }
        }
        ListOfDirectorsInDB.clear();
    }


}

