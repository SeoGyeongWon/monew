package com.team03.monew.news.dto;

import com.team03.monew.news.domain.NewsSourceType;

public record NewsCreateRequest(
    NewsSourceType source,
    String resourceLink,
    String title,
    String postDate,
    String overView
) {

}
