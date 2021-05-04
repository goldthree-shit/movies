package com.hx.service;

import com.hx.entity.Movies;
import com.hx.mapper.MoviesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class MoviesServiceImpl implements MoviesService{

    @Autowired
    MoviesMapper moviesMapper;

    @Override
    public Boolean deleteMovie(Integer mid) {
        return moviesMapper.deleteMovie(mid);
    }

    @Override
    public List<Movies> findAllMovies() {
        return moviesMapper.findAllMovies();
    }

    @Override
    public Boolean insertMovies(Map<String, String> map) {
        String moviesName = map.get("moviesName");
        String description = map.get("description");
        String director = map.get("director");
        String area = map.get("area");
        String actor = map.get("actor");
        String era = map.get("era");
        String url = map.get("url");

        return moviesMapper.insertMovie(new Movies(null, moviesName, description, director, area
                , actor, era, url));
    }

    @Override
    public List<Movies> findAllByGroup(int page) {
        return moviesMapper.findAllByGroup((page - 1) * 20 + "", "20");
    }
}
