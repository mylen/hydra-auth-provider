package com.richemont.sso.demo.usermgt.dto.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.richemont.sso.demo.usermgt.dto.common.Client;
import com.richemont.sso.demo.usermgt.dto.common.Context;
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
public class ConsentResponse {
    public String acr;
    public String challenge;
    public Client client;
    public Context context;
    @JsonProperty("login_challenge")
    public String loginChallenge;
    @JsonProperty("login_session_id")
    public String loginSessionId;
    @JsonProperty("oidc_context")
    public OidcContext oidcContext;
    @JsonProperty("request_url")
    public String requestUrl;
    @JsonProperty("requested_access_token_audience")
    public String[] requestedAccessTokenAudience;
    @JsonProperty("requested_scope")
    public String[] requestedScope;
    public boolean skip;
    public String subject;
}
