package com.team03.monew.news.service;

import com.team03.monew.news.domain.News;
import com.team03.monew.news.dto.NewsCreateRequest;
import com.team03.monew.news.dto.NewsDto;
import com.team03.monew.news.dto.NewsResponseDto;
import com.team03.monew.news.exception.CustomException.SameResourceLink;
import com.team03.monew.news.repository.NewsRepository;
import java.time.LocalDateTime;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BasicNewsService implements NewsService {

  private final NewsRepository newsRepository;

  @Override
  public NewsResponseDto createNews(NewsCreateRequest newsCreateRequest) {
    return null;
  }
}
