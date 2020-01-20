package com.mockapi.mockapi.web.dto.request;

import com.mockapi.mockapi.web.dto.BaseDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchNewsRequest extends BaseDTO {
    private String title;

    private String categoryName;
}
