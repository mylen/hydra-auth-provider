package com.richemont.sso.authprovider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sso.front")
public class FrontendConfig {
    private String scheme;
    private String host;
    private Integer port;
    private String version;
    private Endpoints endpoints;

    /**
     * compile absolute URI to the endpoint
     * @param endpoint the targeted endpoint
     * @return the absolute URI to the endpoint
     */
    public String getUri(String endpoint) {
        return scheme + "://" + host + version + endpoint;
    }

    @Data
    public static class Endpoints {
        private String login;
        private String consent;
        private String logout;
    }

}
