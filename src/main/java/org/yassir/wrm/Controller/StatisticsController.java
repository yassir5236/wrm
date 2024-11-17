package org.yassir.wrm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.yassir.wrm.Service.impl.StatisticsService;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/statistics")
public class StatisticsController {

    private final StatisticsService statisticsService;

    @Autowired
    public StatisticsController(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @GetMapping("/{waitingListId}")
    public ResponseEntity<Map<String, Object>> getStatistics(@PathVariable Long waitingListId) {
        Map<String, Object> stats = new HashMap<>();
        stats.put("satisfactionRate", statisticsService.calculateSatisfactionRate(waitingListId));
        stats.put("averageWaitingTime", statisticsService.calculateAverageWaitingTime(waitingListId));
        stats.put("visitorRotation", statisticsService.calculateVisitorRotation(waitingListId));
        return ResponseEntity.ok(stats);
    }
}
