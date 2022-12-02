package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class MovieService {
    @Autowired
    MovieRepository movieRepository;
    public void addMovie(Movie movie) {
        movieRepository.addMovie(movie);
    }

    public void addDirector(Director director) {
        movieRepository.addDirector(director);
    }

    public void addAllMovieDirectorPair(String mName, String dName) {
         movieRepository.addMovieDirectorPairToDB(mName,dName);
    }

    public Movie getMovieByName(String name) {
     return movieRepository.getMovieDirectorPairFromDB(name);
    }


    public Director getAllDirectorsByName(String name) {
        return movieRepository.getDirectorByNameFromDB(name);
    }
    public List<String> getAllMoviesByDirectorName(String dName) {
        return movieRepository.getMoviesByDirectorNameFromDB(dName);}
    public List<String> findAllMovies() {
        return movieRepository.findAllMoviesFromDB();}
    public void deleteAllDirectorsByName(String dName) {
        movieRepository.deleteDirectorByNameFromDB(dName);}
    public void deleteAllDirectors() {
        movieRepository.deleteAllDirectorsFromDB();}
}
