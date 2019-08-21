package com.richemont.sso.authprovider.dto.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccessToken {
    private Property1 property1;
    private Property2 property2;

    private class Property1 {
    }

    private class Property2 {
    }
}
