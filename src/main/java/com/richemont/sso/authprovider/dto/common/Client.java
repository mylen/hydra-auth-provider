package com.richemont.sso.authprovider.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Client {
    @JsonProperty("allowed_cors_origins")
    private String[] allowedCorsOrigins;
    private String[] audience;
    @JsonProperty("backchannel_logout_session_required")
    private Boolean backchannelLogoutSessionRequired;
    @JsonProperty("backchannel_logout_uri")
    private String backchannelLogoutUri;
    @JsonProperty("client_id")
    private String clientId;
    @JsonProperty("client_name")
    private String clientName;
    @JsonProperty("client_secret")
    private String clientSecret;
    @JsonProperty("client_secret_expires_at")
    private Long clientSecretExpiresAt;
    @JsonProperty("client_uri")
    private String clientUri;
    private String[] contacts;
    @JsonProperty("created_at")
    private String createdAt;
    @JsonProperty("frontchannel_logout_session_required")
    private Boolean frontChannelLogoutSessionRequired;
    @JsonProperty("frontchannel_logout_uri")
    private String frontChannelLogoutUri;
    @JsonProperty("grant_types")
    private String[] grantTypes;
    private Jwks jwks;
    @JsonProperty("jwks_uri")
    private String jwksUri;
    @JsonProperty("logo_uri")
    private String logoUri;
    private String owner;
    @JsonProperty("policy_uri")
    private String policyUri;
    @JsonProperty("post_logout_redirect_uris")
    private String[] postLogoutRedirectUris;
    @JsonProperty("redirect_uris")
    private String[] redirectUris;
    @JsonProperty("request_object_signing_alg")
    private String requestObjectSigningAlg;
    @JsonProperty("request_uris")
    private String[] requestUris;
    @JsonProperty("response_types")
    private String[] responseTypes;
    private String scope;
    @JsonProperty("sector_identifier_uri")
    private String sectorIdentifierUri;
    @JsonProperty("subject_type")
    private String subjectType;
    @JsonProperty("token_endpoint_auth_method")
    private String tokenEndpointAuthMethod;
    @JsonProperty("tos_uri")
    private String tosUri;
    @JsonProperty("updated_at")
    private String updatedAt;
    @JsonProperty("userinfo_signed_response_alg")
    private String userInfoSignedResponseAlg;
}
