package com.mockapi.mockapi.service.impl;

import com.mockapi.mockapi.model.NewsCategory;
import com.mockapi.mockapi.repository.NewsCategoryRepo;
import com.mockapi.mockapi.service.ISNewsCategoryService;
import com.mockapi.mockapi.web.dto.response.GetListDataResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SNewsCategoryImpl implements ISNewsCategoryService {
    private  static final Logger log = LoggerFactory.getLogger(SNewsCategoryImpl.class);

    @Autowired
    private NewsCategoryRepo newsCategoryRepo;
    @Override
    public GetListDataResponseDTO<NewsCategory> getAll() {
        GetListDataResponseDTO<NewsCategory> result = new GetListDataResponseDTO<>();
        try{
            List<NewsCategory> newsCategory = newsCategoryRepo.findAll();
            result.setValue(newsCategory);
            return result;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.value(null);
            result.setMessage("Not have record!");
        }
        log.info("--response SNeweCategoryImpl!!!,{}");
        return result;
    }
}
