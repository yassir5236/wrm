package org.yassir.wrm.Service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yassir.wrm.Model.Entity.Visit;
import org.yassir.wrm.Repository.VisitRepository;

import java.time.Duration;
import java.util.List;

@Service
public class StatisticsService {

    private final VisitRepository visitRepository;

    @Autowired
    public StatisticsService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public double calculateSatisfactionRate(Long waitingListId) {
        List<Visit> visits = visitRepository.findByWaitingListId(waitingListId);
        if (visits.isEmpty()) {
            return 0;
        }
        double totalScore = visits.stream()
                .filter(visit -> visit.getSatisfactionScore() != null)
                .mapToDouble(Visit::getSatisfactionScore)
                .sum();
        return totalScore / visits.size();
    }

    public double calculateAverageWaitingTime(Long waitingListId) {
        List<Visit> visits = visitRepository.findByWaitingListId(waitingListId);
        if (visits.isEmpty()) {
            return 0;
        }
        double totalWaitTime = visits.stream()
                .filter(visit -> visit.getArriveTime() != null && visit.getStartTime() != null)
                .mapToDouble(visit -> Duration.between(visit.getArriveTime(), visit.getStartTime()).toMinutes())
                .sum();
        return totalWaitTime / visits.size();
    }

    public long calculateVisitorRotation(Long waitingListId) {
        List<Visit> visits = visitRepository.findByWaitingListId(waitingListId);
        return visits.stream()
                .filter(visit -> visit.getEndTime() != null)
                .count();
    }
}

