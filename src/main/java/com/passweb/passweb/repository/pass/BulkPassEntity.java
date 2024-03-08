package com.passweb.passweb.repository.pass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bulk_pass")
public class BulkPassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임합니다. (AUTO_INCREMENT)
    private Integer bulkPassSeq;
    private Integer packageSeq;
    private String userGroupId;

    @Enumerated(EnumType.STRING)
    private BulkPassStatus status;
    private Integer count;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    public void setEndedAt(Integer period) {
        /**
         * 종료 날짜를 설정합니다.
         *
         * @param period 기간 (일 단위)
         */
        if (period == null) {
            /**
             * period가 null이면 종료 날짜를 설정하지 않습니다.
             */
            return;
        }
        /**
         * 시작 날짜에 period를 더하여 종료 날짜를 계산합니다.
         */
        this.endedAt = this.startedAt.plusDays(period);
    }

    public void setEndedAt(LocalDateTime endedAt) {
        /**
         * 종료 날짜를 직접 설정합니다.
         *
         * @param endedAt 종료 날짜
         */
        this.endedAt = endedAt;
    }

}
