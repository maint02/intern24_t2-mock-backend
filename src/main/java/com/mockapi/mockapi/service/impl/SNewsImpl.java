package com.mockapi.mockapi.service.impl;

import com.mockapi.mockapi.model.Employee;
import com.mockapi.mockapi.model.News;
import com.mockapi.mockapi.repository.EmployeeRepo;
import com.mockapi.mockapi.repository.NewsCategoryRepo;
import com.mockapi.mockapi.repository.NewsDao;
import com.mockapi.mockapi.repository.NewsRepo;
import com.mockapi.mockapi.service.ISNewsService;
import com.mockapi.mockapi.web.dto.NewsDTO;
import com.mockapi.mockapi.web.dto.request.NewsRequest;
import com.mockapi.mockapi.web.dto.request.SearchNewsRequest;
import com.mockapi.mockapi.web.dto.response.GetListDataResponseDTO;
import com.mockapi.mockapi.web.dto.response.GetSingleDataResponseDTO;
import com.mockapi.mockapi.web.dto.response.resp.NewsResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
@Slf4j
public class SNewsImpl implements ISNewsService {

    @Autowired
    private NewsRepo newsRepo;

    @Autowired
    private NewsCategoryRepo newsCategoryRepo;

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private NewsDao newsDao;

    @Override
    public GetListDataResponseDTO<NewsResponse> getAllNews(SearchNewsRequest request) {
        log.info("--request News to getAllByParmas is -----");
        GetListDataResponseDTO<NewsResponse> result = new GetListDataResponseDTO<>();
        Page<NewsResponse> rawDatas = newsDao.getAll(request);
        System.out.println("content!!!!!!"+rawDatas.getContent() +"---- size"+rawDatas.getSize());
        result.setResult(rawDatas.getContent(),rawDatas.getTotalElements(),rawDatas.getTotalPages());
        log.info("--response to get list employee by params: " + result.getMessage());
        return result;
    }

    @Override
    public GetSingleDataResponseDTO<NewsDTO> delete(Long id) {
        GetSingleDataResponseDTO<NewsDTO> result = new GetSingleDataResponseDTO<>();
        News news = newsRepo.findById(id).get();
        if(news != null){
            newsRepo.deleteById(id);
        }
        result.setResult(modelMapper.map(news,NewsDTO.class));
        return result;
    }

    @Override
    public GetSingleDataResponseDTO<NewsDTO> update(NewsDTO newsDTO) {
        GetSingleDataResponseDTO<NewsDTO> result = new GetSingleDataResponseDTO<>();
        try {
            News news = newsRepo.findById(newsDTO.getId()).get();
            if(news !=null){
                news.setContent(newsDTO.getContent());
                news.setPosted(newsDTO.getContent());
                news.setSummary(newsDTO.getSummary());
                news.setThumbnail(newsDTO.getThumbnail());
                news.setTime_post(newsDTO.getTime_post());
                news.setTitle(newsDTO.getTitle());
                newsRepo.save(news);
                result.setResult(modelMapper.map(news,NewsDTO.class));
                return result;
            }
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setResult(null);
        }

        return result;
    }

    @Override
    public GetSingleDataResponseDTO<NewsDTO> add(NewsRequest newsRequest) {
        GetSingleDataResponseDTO<NewsDTO> result = new GetSingleDataResponseDTO<>();
       // Employee employee = (Employee) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       // System.out.println("employee pricical-- "+ employee.getId()+"---"+employee.getUsername());
        try {
            News news = modelMapper.map(newsRequest,News.class);
            news.setTime_post(new Date());
           // news.getEmployee().getId();
            news = newsRepo.save(news);
            result.setResult(modelMapper.map(news,NewsDTO.class));
            log.info("response ----" +result.getMessage());
            return  result;
        }catch (Exception ex){
            log.error(ex.getMessage(),ex);
            result.setResult(null);
        }
        return result;
    }
}
