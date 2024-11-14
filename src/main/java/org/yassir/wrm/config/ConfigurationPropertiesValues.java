package org.yassir.wrm.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.yassir.wrm.Model.Enum.Algorithm;
import org.yassir.wrm.Model.Enum.TypeMode;

@ConfigurationProperties("wrm.scheduling")
public record ConfigurationPropertiesValues(
        Algorithm algorithm,
        TypeMode typeMode
) {
}
