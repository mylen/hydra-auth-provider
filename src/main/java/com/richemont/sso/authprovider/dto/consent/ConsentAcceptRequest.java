package com.richemont.sso.authprovider.dto.consent;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.richemont.sso.authprovider.dto.common.Session;
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
    private ConsentResponse consentResponse;
    @JsonProperty("grant_access_token_audience")
    private String[] grantAccessTokenAudience;
    @JsonProperty("grant_scope")
    private String[] grantScope;
    private Boolean remember;
    @JsonProperty("remember_for")
    private Long rememberFor;
    private Session session;
}
