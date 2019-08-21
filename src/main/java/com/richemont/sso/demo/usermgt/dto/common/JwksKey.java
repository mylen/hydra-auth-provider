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
public class JwksKey {
    String alg;
    String crv;
    String d;
    String dp;
    String dq;
    String e;
    String k;
    String kid;
    String kty;
    String n;
    String p;
    String q;
    String qi;
    String use;
    String x;
    String[] x5c;
    String y;
}
