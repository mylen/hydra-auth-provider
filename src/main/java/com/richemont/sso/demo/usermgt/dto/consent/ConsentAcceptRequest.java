package com.richemont.sso.demo.usermgt.dto.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.richemont.sso.demo.usermgt.dto.common.Session;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ConsentAcceptRequest {
    @JsonProperty("consent_request")
    public ConsentResponse consentResponse;
    @JsonProperty("grant_access_token_audience")
    public String[] grantAccessTokenAudience;
    @JsonProperty("grant_scope")
    public String[] grantScope;
    public boolean remember;
    @JsonProperty("remember_for")
    public long rememberFor;
    public Session session;
}
