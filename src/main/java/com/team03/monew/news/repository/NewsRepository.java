package com.team03.monew.news.repository;

import com.team03.monew.news.domain.News;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, UUID>{

}
