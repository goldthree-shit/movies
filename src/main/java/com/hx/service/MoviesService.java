package com.hx.service;

import com.hx.entity.Movies;

import java.util.List;
import java.util.Map;

public interface MoviesService {

    Boolean deleteMovie(Integer mid);

    List<Movies> findAllMovies();

    Boolean insertMovies(Map<String, String> map);

    List<Movies> findAllByGroup(int page);
}
