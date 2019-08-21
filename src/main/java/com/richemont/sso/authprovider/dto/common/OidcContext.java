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
public class OidcContext {
    @JsonProperty("acr_values")
    private String[] acrValues;
    private String display;
    @JsonProperty("id_token_hint_claims")
    private IdTokenHintClaims idTokenHintClaims;
    @JsonProperty("login_hint")
    private String loginHint;
    @JsonProperty("ui_locales")
    private String[] uiLocales;
}
