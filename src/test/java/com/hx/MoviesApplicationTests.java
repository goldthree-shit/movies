package com.hx;

import com.hx.entity.Movies;
import com.hx.mapper.MoviesMapper;
import com.hx.service.MoviesService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;

@SpringBootTest
class MoviesApplicationTests {
    /**
     *     private String moviesName;
     *     private String description;
     *     private String director;
     *     private String area;
     *     private String actor;
     *     private String era;
     *     private String url;
     */

    @Autowired
    MoviesMapper moviesMapper;
    @Autowired
    MoviesService moviesService;
    @Test
    void contextLoads() {
        String firstNames[] =
                {"赵","钱","孙","李","周","吴","郑","王",
                "冯","卫","褚","陈","蒋","沈","韩","杨",
                "朱","秦","尤","许","何","吕","施","张",
                "孔","曹","严","华","金","魏","陶","姜"};

        String characters[] = {
                "有","陈","凯","歌","张","艺","谋","吴","子","牛",
                "田","壮","壮","黄","建","新","李","少","红","胡",
                "玫","张","绍","林","潘","霞","宋","中","国","内",
                "地","导","演","毕","业","于","北","京","电","影",
                "学","院","获","得","第","届","中","国","电","影",
                "金","鸡","奖","导","演","特","别","奖","年","执",
                "导","的","文","艺","片","霸","王","别","姬","成",
                "为","首","部","获","得","戛","纳","国","际","电",
                "影","节","金","棕","榈","奖","的","中","国","电"
        };

        String bigCharacter[] = {"A","B","C","D","E","F","G","H","I","J","K","L",
                "M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String smallCharacter[] = {"a","b","c","d","e","f","g","h","i","j","k","l",
                "m","n","o","p","q","r","s","t","u","v","w","x","y","z"};

        String descriptions[] = {"动作片","爱情片","奇幻片","喜剧片","恐怖片","纪录片","音乐片",
                "犯罪片","历史片","科幻片","战争片"};
        String areas[] = {"美国","英国","日本","法国"};
        String eras[] = {"00","01","02","03","04","05","06","07","08","09",
                "10","11","12","13","14","15","16","18","19","20"};


        Random random = new Random();
        // 电影名称
        String moviesName = "";
        // 描述
        String description;
        // 导演
        String director = "";
        // 地区
        String area;
        // 演员
        String actor = "";
        // 年代
        String era = "20";
        // url
        String url = "http://www.dy2018.com//";

        for (int j = 0; j < 3000; j++) {
            int moviesNameLength = random.nextInt(7) + 3;
            for (int i = 0; i < moviesNameLength; i++) {
                int local = random.nextInt(characters.length);
                moviesName += characters[local];
            }
            // 描述
            description = descriptions[random.nextInt(descriptions.length)];
            era += eras[random.nextInt(eras.length)];
            int urlLength = random.nextInt(10) + 10;
            for (int i = 0; i < urlLength; i++) {
                int local = random.nextInt(smallCharacter.length);
                url += smallCharacter[local];
            }
            int select  = random.nextInt(2);
            System.out.println(select);
            if (select == 0) {
                director += bigCharacter[random.nextInt(bigCharacter.length)];
                int directorLength = random.nextInt(10) + 3;
                for (int i = 0; i < directorLength; i++) {
                    int local = random.nextInt(smallCharacter.length);
                    director += smallCharacter[local];
                }

                area = areas[random.nextInt(areas.length)];

                actor += bigCharacter[random.nextInt(bigCharacter.length)];
                int actorLength = random.nextInt(10) + 3;
                for (int i = 0; i < actorLength; i++) {
                    int local = random.nextInt(smallCharacter.length);
                    actor += smallCharacter[local];
                }
            } else {
                director += firstNames[random.nextInt(firstNames.length)];
                int directorLength = random.nextInt(2) + 1;
                for (int i = 0; i < directorLength; i++) {
                    int local = random.nextInt(characters.length);
                    director += characters[local];
                }

                area = "中国";

                actor += firstNames[random.nextInt(firstNames.length)];
                int actorLength = random.nextInt(2) + 1;
                for (int i = 0; i < actorLength; i++) {
                    int local = random.nextInt(characters.length);
                    actor += characters[local];
                }
            }

            Movies movies = new Movies(null, moviesName, description, director, area, actor, era, url);
            moviesMapper.insertMovie(movies);

            moviesName = "";
            director = "";
            actor = "";
            era = "20";
            url = "http://www.dy2018.com//";
            System.out.println(movies);
        }


    }

}
