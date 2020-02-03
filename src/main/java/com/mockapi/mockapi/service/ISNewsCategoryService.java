package com.mockapi.mockapi.service;

import com.mockapi.mockapi.model.NewsCategory;
import com.mockapi.mockapi.web.dto.response.GetListDataResponseDTO;

import java.util.List;

public interface ISNewsCategoryService {
    GetListDataResponseDTO<NewsCategory> getAll();
}
