package com.richemont.sso.authprovider.dto.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.richemont.sso.authprovider.dto.common.Client;
import com.richemont.sso.authprovider.dto.common.OidcContext;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginResponse {
    private String challenge;
    private Client client;
    @JsonProperty("oidc_context")
    private OidcContext oidcContext;
    @JsonProperty("request_url")
    private String requestUrl;
    @JsonProperty("requested_access_token_audience")
    private String[] requestedAccessTokenAudience;
    @JsonProperty("requested_scope")
    private String[] requestedScope;
    @JsonProperty("session_id")
    private String sessionId;
    private Boolean skip;
    private String subject;
}
