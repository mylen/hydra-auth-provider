package com.richemont.sso.demo.usermgt.dto.common;

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
    String[] allowedCorsOrigins;
    String[] audience;
    @JsonProperty("backchannel_logout_session_required")
    boolean backchannelLogoutSessionRequired;
    @JsonProperty("backchannel_logout_uri")
    String backchannelLogoutUri;
    @JsonProperty("client_id")
    String clientId;
    @JsonProperty("client_name")
    String clientName;
    @JsonProperty("client_secret")
    String clientSecret;
    @JsonProperty("client_secret_expires_at")
    long clientSecretExpiresAt;
    @JsonProperty("client_uri")
    String clientUri;
    String[] contacts;
    @JsonProperty("created_at")
    String createdAt;
    @JsonProperty("frontchannel_logout_session_required")
    boolean frontChannelLogoutSessionRequired;
    @JsonProperty("frontchannel_logout_uri")
    String frontChannelLogoutUri;
    @JsonProperty("grant_types")
    String[] grantTypes;
    Jwks jwks;
    @JsonProperty("jwks_uri")
    String jwksUri;
    @JsonProperty("logo_uri")
    String logoUri;
    String owner;
    @JsonProperty("policy_uri")
    String policyUri;
    @JsonProperty("post_logout_redirect_uris")
    String[] postLogoutRedirectUris;
    @JsonProperty("redirect_uris")
    String[] redirectUris;
    @JsonProperty("request_object_signing_alg")
    String requestObjectSigningAlg;
    @JsonProperty("request_uris")
    String[] requestUris;
    @JsonProperty("response_types")
    String[] responseTypes;
    String scope;
    @JsonProperty("sector_identifier_uri")
    String sectorIdentifierUri;
    @JsonProperty("subject_type")
    String subjectType;
    @JsonProperty("token_endpoint_auth_method")
    String tokenEndpointAuthMethod;
    @JsonProperty("tos_uri")
    String tosUri;
    @JsonProperty("updated_at")
    String updatedAt;
    @JsonProperty("userinfo_signed_response_alg")
    String userInfoSignedResponseAlg;
}
