package com.team03.monew.notification.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "notification")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Notification {
    @Id
    private UUID id;

    @Column(name = "user_id", nullable = false)
    private UUID userId;

    @Column(nullable = false)
    private String context;

    @Column(length = 10, nullable = false)
    private noticeResourceType resource;

    @Column(nullable = false, columnDefinition = "default false")
    private boolean isChecked;

    @Column
    private LocalDateTime creationAt;

    @Column
    private LocalDateTime updatedAt;

    private Notification(
            UUID id,
            UUID userId,
            String context,
            noticeResourceType resource,
            boolean isChecked,
            LocalDateTime creationAt,
            LocalDateTime updatedAt
    ) {
        this.id = id;
        this.userId = userId;
        this.context = context;
        this.resource = resource;
        this.isChecked = isChecked;
        this.creationAt = creationAt;
        this.updatedAt = updatedAt;
    }

    /*
    * 내부 로직에 따른 변경이 있는 것
    * userId   : 받는 대상 (요청자x)
    * context  : 보내는 내용 (댓글-불변 / 뉴스-가변)
    * resource : 무엇인지 (댓글, 뉴스)
    * */
    private Notification(
            UUID userId,
            String context,
            noticeResourceType resource
    ) {
        this(
                null,
                userId,
                context,
                resource,
                false,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
    }

    public static Notification from(
            UUID userId,
            String context,
            noticeResourceType resource
    ) {
        return new Notification(userId, context, resource);
    }

    public Notification check() {
        this.isChecked = true;
        this.updatedAt = LocalDateTime.now();
        return this;
    }
}
