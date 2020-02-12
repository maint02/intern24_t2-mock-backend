package com.mockapi.mockapi.repository;

import com.mockapi.mockapi.model.NewsCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsCategoryRepo extends JpaRepository<NewsCategory, Long> {
    @Query(nativeQuery = true,value = "SELECT nc.NAME FROM  NEWS_CATEGORY nc INNER JOIN NEWS n on nc.ID = n.NEWSCATEGORY_ID WHERE n.NEWSCATEGORY_ID=?1")
    NewsCategory findNameByIdNews(Long id);
}
