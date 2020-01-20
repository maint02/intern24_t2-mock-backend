package com.mockapi.mockapi.web.dto.request;

import com.mockapi.mockapi.web.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Getter
@Setter
public class SearchNewsRequest extends BaseDTO {
    private long id;

    private String content;

    private String posted;

    private String summary;

    private String thumbnail;

    private Date time_post;

    @NotBlank
    private String title;

    private String username;

    @NotBlank
    private String name;
}