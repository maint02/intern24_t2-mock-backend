package com.mockapi.mockapi.web.rest;

import com.mockapi.mockapi.model.NewsCategory;
import com.mockapi.mockapi.service.ISNewsCategoryService;
import com.mockapi.mockapi.web.dto.response.GetListDataResponseDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/newCategory")
@CrossOrigin("*")
public class NewsCategoryRest {
    private static final Logger log = LoggerFactory.getLogger(NewsCategoryRest.class);

    @Autowired
    private ISNewsCategoryService newsCategoryService;

    @GetMapping(value = "/all",consumes = "application/json")
    public ResponseEntity<GetListDataResponseDTO<NewsCategory>> getAll(){
        log.info("-----start request to get all NewsCategory----");
        GetListDataResponseDTO<NewsCategory> result = newsCategoryService.getAll();
        if(result== null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        log.info("-----response to get all NewsCategory :{}");
        return new ResponseEntity<>(result,HttpStatus.OK);
    }
}
