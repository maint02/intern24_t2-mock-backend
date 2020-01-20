package com.mockapi.mockapi.web.dto.request;

import javax.validation.constraints.NotNull;
import java.util.Date;

public class NewsRequest {
    private long id;

    @NotNull
    private String thumbnail;

    @NotNull
    private String title;

    @NotNull
    private String posted;

    @NotNull
    private Date time_post;

    @NotNull
    private String summary;

    @NotNull
    private String content;
}
