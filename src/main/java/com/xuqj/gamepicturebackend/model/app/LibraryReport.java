package com.xuqj.gamepicturebackend.model.app;

import lombok.Data;

import java.util.List;

@Data
public class LibraryReport {

    private String title;

    List<String> suggestions;
}
