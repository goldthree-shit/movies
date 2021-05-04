package com.hx.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("电影实体类")
public class Movies {
    @ApiModelProperty("电影id")
    private Long mid;
    @ApiModelProperty("电影名称")
    private String moviesName;
    @ApiModelProperty("电影描述，如：动作片")
    private String description;
    @ApiModelProperty("导演")
    private String director;
    @ApiModelProperty("地区，如：中国")
    private String area;
    @ApiModelProperty("演员")
    private String actor;
    @ApiModelProperty("年代，如：2001")
    private String era;
    @ApiModelProperty("电影的资源路径")
    private String url;

}
