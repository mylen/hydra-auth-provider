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
public class JwksKey {
    private String alg;
    private String crv;
    private String d;
    private String dp;
    private String dq;
    private String e;
    private String k;
    private String kid;
    private String kty;
    private String n;
    private String p;
    private String q;
    private String qi;
    private String use;
    private String x;
    private String[] x5c;
    private String y;
}
