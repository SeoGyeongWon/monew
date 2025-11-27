package com.team03.monew.notification.repository;

import com.team03.monew.notification.domain.Notification;
import org.springframework.data.domain.Slice;

import java.time.LocalDateTime;
import java.util.UUID;

public interface NotificationRepositoryCustom {

    // 커서 페이지네이션, 미확인 알림 조회, QueryDSL 사용
    Slice<Notification> findUncheckedNotificationsWithCursor(
            UUID userId,
            LocalDateTime cursor,
            int size
    );

    // 미확인 알림 조회 (첫 페이지 용도), QueryDSL 사용
    Slice<Notification> findUncheckedNotifications(
            UUID userId,
            int size
    );
}
