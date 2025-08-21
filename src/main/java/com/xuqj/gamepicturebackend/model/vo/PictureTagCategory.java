package com.xuqj.gamepicturebackend.model.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PictureTagCategory implements Serializable {

    /**
     * 标签
     */
    private List<String> tagList;

    private List<String> categoryList;

    private static final long serialVersionUID = 1L;
}
