package com.richemont.sso.authprovider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "sso.auth")
public class AuthProviderConfig {
    private String baseUrl;
    private String version;
    private Endpoints endpoints;

    /**
     * compile absolute URI to the endpoint
     * @param endpoint the targeted endpoint
     * @return the absolute URI to the endpoint
     */
    public String getUri(String endpoint) {
        return baseUrl + version + endpoint;
    }

    @Data
    public static class Endpoints {
        private String login;
        private String consent;
        private String logout;
    }
}
