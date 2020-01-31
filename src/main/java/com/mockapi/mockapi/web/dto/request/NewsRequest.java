package com.mockapi.mockapi.web.dto.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
public class NewsRequest {
    private long id;

    @NotBlank
    private String content;
    @NotBlank
    private String posted;
    @NotBlank
    private String summary;
    @NotBlank
    private String thumbnail;
    @NotBlank
    private String title;
}
