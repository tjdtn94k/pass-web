package com.passweb.passweb.service.statistics;

import com.passweb.passweb.repository.statistics.StatisticsRepository;
import com.passweb.passweb.util.LocalDateTimeUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class StatisticsService {

    private final StatisticsRepository statisticsRepository;

    public StatisticsService(StatisticsRepository statisticsRepository) {
        this.statisticsRepository = statisticsRepository;
    }

    /**
     * 특정 날짜 범위에 대한 차트 데이터를 생성합니다.
     *
     * @param to 조회 종료 날짜 (포함)
     * @return 차트 데이터 (날짜 레이블, 참석 건수, 취소 건수 목록)
     */
    public ChartData makeChartData(final LocalDateTime to) {
        // 종료 날짜로부터 10일 전을 조회 시작 날짜로 설정
        final LocalDateTime from = to.minusDays(10);

        /**
         * 해당 날짜 범위에 속한 통계 데이터를 집계된 형태로 조회합니다.
         * statisticsRepository 를 이용하여 실제 데이터 조회 로직이 구현됩니다.
         */
        final List<AggregatedStatistics> aggregatedStatisticsList = statisticsRepository.findByStatisticsAtBetweenAndGroupBy(from, to);

        // 차트 레이블, 참석 건수, 취소 건수 데이터를 담을 리스트 생성
        List<String> labels = new ArrayList<>();
        List<Long> attendedCounts = new ArrayList<>();
        List<Long> cancelledCounts = new ArrayList<>();

        /**
         * 조회된 집계 데이터를 순회하며 차트 데이터를 구성합니다.
         */
        for (AggregatedStatistics statistics : aggregatedStatisticsList) {
            // 날짜 레이블 설정 (MM-DD 형식)
            labels.add(LocalDateTimeUtils.format(statistics.getStatisticsAt(), LocalDateTimeUtils.MM_DD));
            // 참석 건수 추출
            attendedCounts.add(statistics.getAttendedCount());
            // 취소 건수 추출
            cancelledCounts.add(statistics.getCancelledCount());
        }

        // 차트 데이터 객체 생성 및 반환
        return new ChartData(labels, attendedCounts, cancelledCounts);
    }
}
