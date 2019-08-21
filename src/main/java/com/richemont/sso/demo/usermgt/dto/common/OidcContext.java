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
public class OidcContext {
    @JsonProperty("acr_values")
    String[] acrValues;
    String display;
    @JsonProperty("id_token_hint_claims")
    IdTokenHintClaims idTokenHintClaims;
    @JsonProperty("login_hint")
    String loginHint;
    @JsonProperty("ui_locales")
    String[] uiLocales;
}
