package com.richemont.sso.authprovider.dto.logout;

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
public class LogoutResponse {
    @JsonProperty("request_url")
    private String requestUrl;
    @JsonProperty("rp_initiated")
    private Boolean rpInitiated;
    private String sid;
    private String subject;
}
