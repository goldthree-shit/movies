package com.hx.mapper;

import com.hx.entity.Movies;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MoviesMapper {

    Boolean deleteMovie(Integer mid);

    Boolean insertMovie(Movies movies);

    List<Movies> findAllMovies();

    List<Movies> findAllByGroup(@Param("start") String start, @Param("pageSize") String pageSize);
}
