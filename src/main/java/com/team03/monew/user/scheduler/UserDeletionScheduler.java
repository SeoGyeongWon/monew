package com.team03.monew.user.scheduler;

import com.team03.monew.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class UserDeletionScheduler {

    private final UserService userService;

    /**
     * 논리 삭제 후 5분 경과한 사용자를 자동으로 물리 삭제
     * 프로토타입: 5분마다 실행
     * 프로덕션: 1일(24시간) 경과 후 삭제하도록 변경 필요
     */
    @Async
    @Scheduled(cron = "0 */5 * * * *") // 5분마다 실행
    public void deleteExpiredUsers() {
        log.info("논리 삭제된 사용자 자동 물리 삭제 스케줄러 실행");
        try {
            userService.hardDeleteExpiredUsers();
        } catch (Exception e) {
            log.error("사용자 자동 삭제 중 오류 발생", e);
        }
    }
}

