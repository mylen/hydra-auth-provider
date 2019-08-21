package com.richemont.sso.demo.usermgt.dto.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.richemont.sso.demo.usermgt.dto.common.Client;
import com.richemont.sso.demo.usermgt.dto.common.OidcContext;
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
    String challenge;
    Client client;
    @JsonProperty("oidc_context")
    OidcContext oidcContext;
    @JsonProperty("request_url")
    String requestUrl;
    @JsonProperty("requested_access_token_audience")
    String[] requestedAccessTokenAudience;
    @JsonProperty("requested_scope")
    String[] requestedScope;
    @JsonProperty("session_id")
    String sessionId;
    boolean skip;
    String subject;
}
