package com.team03.monew.common.logging;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class LogFilter extends OncePerRequestFilter {

  @Override
  protected void doFilterInternal(
      HttpServletRequest request,
      HttpServletResponse response,
      FilterChain filterChain
  ) throws ServletException, IOException
  {
  String requestId = UUID.randomUUID().toString();
  String clientIp = request.getRemoteAddr();

    MDC.put("requestId", requestId);
    MDC.put("clientIp", clientIp);

    // 응답 헤더 추가
    response.setHeader("X-Request-Id", requestId);
    response.setHeader("X-Client-IP", clientIp);

    try{
      filterChain.doFilter(request, response);
    }finally {
      MDC.clear();
    }
  }
}
