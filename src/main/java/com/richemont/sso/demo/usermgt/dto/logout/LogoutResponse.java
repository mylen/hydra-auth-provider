package com.richemont.sso.demo.usermgt.dto.logout;

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
public class LogoutResponse {
    @JsonProperty("request_url")
    String requestUrl;
    @JsonProperty("rp_initiated")
    boolean rpInitiated;
    String sid;
    String subject;
}
