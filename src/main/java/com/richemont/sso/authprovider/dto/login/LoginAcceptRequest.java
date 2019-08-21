package com.richemont.sso.authprovider.dto.login;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "acr",
        "force_subject_identifier",
        "remember",
        "remember_for",
        "subject"
})
public class LoginAcceptRequest {
    @JsonProperty("acr")
    private String acr;
    @JsonProperty("force_subject_identifier")
    private String forceSubjectIdentifier;
    @JsonProperty("remember")
    private Boolean remember;
    @JsonProperty("remember_for")
    private Integer rememberFor;
    @JsonProperty("subject")
    private String subject;
}
