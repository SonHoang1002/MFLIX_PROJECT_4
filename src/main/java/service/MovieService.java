package service;

import DAO.MovieDAO;
import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieService {

    public List<Movie> getMoviesforHomePage() {
        List<Movie> list = new MovieDAO().getMovies(6);
        if (list == null) {
            list = new ArrayList<>();
            //add some sample movies;
        }
        return list;
    }
}