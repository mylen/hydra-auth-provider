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
public class AccessToken {
    public Property1 property1;
    public Property2 property2;

    public class Property1 {
    }

    public class Property2 {
    }
}
