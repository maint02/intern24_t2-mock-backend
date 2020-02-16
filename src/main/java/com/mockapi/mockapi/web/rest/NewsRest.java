package com.mockapi.mockapi.web.rest;


import com.mockapi.mockapi.service.ISNewsService;
import com.mockapi.mockapi.web.dto.NewsDTO;
import com.mockapi.mockapi.web.dto.request.NewsRequest;
import com.mockapi.mockapi.web.dto.request.SearchNewsRequest;
import com.mockapi.mockapi.web.dto.response.GetListDataResponseDTO;
import com.mockapi.mockapi.web.dto.response.GetSingleDataResponseDTO;
import com.mockapi.mockapi.web.dto.response.resp.NewsResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@CrossOrigin("*")
@RequestMapping("/news")
@Slf4j
public class NewsRest {
    @Autowired
    private ISNewsService isNewsService;

    @PostMapping("/allByParams")
    public ResponseEntity<GetListDataResponseDTO<NewsResponse>> getAll(@RequestBody SearchNewsRequest request){
        GetListDataResponseDTO<NewsResponse> resp  = isNewsService.getAllNews(request);
        if(resp == null){
            log.error("can't get all News");
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<GetSingleDataResponseDTO<NewsDTO>> add(@Valid @RequestBody NewsRequest request){
        GetSingleDataResponseDTO<NewsDTO> resp = isNewsService.add(request);
        if(resp == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<GetSingleDataResponseDTO<NewsDTO>> update(@Valid @RequestBody NewsDTO newsDTO){
        GetSingleDataResponseDTO<NewsDTO> resp = isNewsService.update(newsDTO);
        if(resp == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(resp,HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GetSingleDataResponseDTO<NewsDTO>> delete(@PathVariable("id")Long id){
        GetSingleDataResponseDTO<NewsDTO> resp  = isNewsService.delete(id);
        if(resp == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        log.info("deleted! news ");
        return new ResponseEntity<>(resp,HttpStatus.OK);

    }
    @GetMapping("/all/{id}")
    public ResponseEntity<GetSingleDataResponseDTO<NewsDTO>> getById(@PathVariable("id")Long id){
        GetSingleDataResponseDTO<NewsDTO> resp  = isNewsService.getById(id);
        if(resp == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        log.info("Get news by id ");
        return new ResponseEntity<>(resp,HttpStatus.OK);

    }
}
