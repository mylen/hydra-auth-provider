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
public class IdToken {
    @JsonProperty("birthdate")
    String birthDate;
    @JsonProperty("email")
    String email;
    @JsonProperty("email_verified")
    boolean emailVerified;
    @JsonProperty("family_name")
    String familyName;
    @JsonProperty("gender")
    String gender;
    @JsonProperty("given_name")
    String givenName;
    @JsonProperty("locale")
    String locale;
    @JsonProperty("middle_name")
    String middleName;
    @JsonProperty("name")
    String name;
    @JsonProperty("nickname")
    String nickName;
    @JsonProperty("phone_number")
    String phoneNumber;
    @JsonProperty("phone_number_verified")
    boolean phoneNumberVerified;
    @JsonProperty("picture")
    String picture;
    @JsonProperty("preferred_username")
    String preferredUsername;
    @JsonProperty("profile")
    String profile;
    @JsonProperty("sub")
    String sub;
    @JsonProperty("updated_at")
    Integer updatedAt;
    @JsonProperty("website")
    String website;
    @JsonProperty("zoneinfo")
    String zoneInfo;
}
