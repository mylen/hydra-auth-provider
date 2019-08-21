package com.richemont.sso.demo.usermgt.dto.common;

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
public class IdTokenHintClaims {
    Property1 property1;
    Property2 property2;

    class Property1 {
    }

    class Property2 {
    }
}
