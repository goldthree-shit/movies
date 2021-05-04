package com.hx.controller;

import com.hx.entity.Movies;
import com.hx.entity.User;
import com.hx.service.MoviesService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@Api(description = "电影相关的api")
public class MoviesController {

    @Autowired
    MoviesService moviesService;

    @GetMapping("/user/movies")
    @ApiOperation("获取全部的电影")
    public Map<String,Object> index() {
        Map<String,Object> result = new HashMap<>();
        result.put("movies", moviesService.findAllMovies());
        return result;
    }

    @PostMapping("/user/movies/insert")
    @ApiOperation("增加电影")
    public Map<String,Object> insert(@RequestBody Map<String, String> map) {
        Map<String,Object> result = new HashMap<>();
        result.put("msg", moviesService.insertMovies(map));
        return result;
    }

    @GetMapping("/user/movies/select/{page}")
    @ApiOperation("分页查询电影")
    public Map<String,Object> everPage(@PathVariable("page") Integer page) {
        Map<String,Object> result = new HashMap<>();
        result.put("movies", moviesService.findAllByGroup(page));
        return result;
    }

    @DeleteMapping("/user/movies/delete/{mid}")
    @ApiOperation("删除电影")
    public Map<String,Object> deleteMovie(@ApiParam("电影id") @PathVariable("mid") Integer mid) {
        Map<String,Object> result = new HashMap<>();
        result.put("msg", moviesService.deleteMovie(mid));
        return result;
    }

    @PostMapping("/user/movies/update")
    @ApiOperation("更新电影信息")
    public Map<String,Object> updateMovie(@RequestBody Map<String, String> map) {
        Map<String,Object> result = new HashMap<>();
        result.put("msg", moviesService.insertMovies(map));
        return result;
    }

    @GetMapping("/getMovies")
    public Movies getUser() {
        return new Movies();
    }
}
