package org.yassir.wrm.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.yassir.wrm.Model.Enum.Algorithm;

@Configuration
public class WaitingListConfig {

    @Value("${waiting-list.default-algorithm}")
    private String defaultAlgorithm;

    public Algorithm getDefaultAlgorithm() {
        return Algorithm.valueOf(defaultAlgorithm);
    }
}

