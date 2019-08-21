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
public class IdToken {
    @JsonProperty("birthdate")
    private String birthDate;
    @JsonProperty("email")
    private String email;
    @JsonProperty("email_verified")
    private Boolean emailVerified;
    @JsonProperty("family_name")
    private String familyName;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("given_name")
    private String givenName;
    @JsonProperty("locale")
    private String locale;
    @JsonProperty("middle_name")
    private String middleName;
    @JsonProperty("name")
    private String name;
    @JsonProperty("nickname")
    private String nickName;
    @JsonProperty("phone_number")
    private String phoneNumber;
    @JsonProperty("phone_number_verified")
    private Boolean phoneNumberVerified;
    @JsonProperty("picture")
    private String picture;
    @JsonProperty("preferred_username")
    private String preferredUsername;
    @JsonProperty("profile")
    private String profile;
    @JsonProperty("sub")
    private String sub;
    @JsonProperty("updated_at")
    private Integer updatedAt;
    @JsonProperty("website")
    private String website;
    @JsonProperty("zoneinfo")
    private String zoneInfo;
}
