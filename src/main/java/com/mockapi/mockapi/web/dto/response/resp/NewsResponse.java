package com.mockapi.mockapi.web.dto.response.resp;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NewsResponse {

    private long id;

    private String content;

    private String posted;

    private String summary;

    private String thumbnail;

    private Date timePost;

    private String title;

    private String username;

    private String name;
}
