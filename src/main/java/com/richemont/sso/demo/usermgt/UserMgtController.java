package com.richemont.sso.demo.usermgt;

import com.richemont.sso.demo.usermgt.client.AuthClient;
import com.richemont.sso.demo.usermgt.dto.common.IdToken;
import com.richemont.sso.demo.usermgt.dto.common.Session;
import com.richemont.sso.demo.usermgt.dto.consent.ConsentAcceptResponse;
import com.richemont.sso.demo.usermgt.dto.consent.ConsentResponse;
import com.richemont.sso.demo.usermgt.dto.login.LoginAcceptRequest;
import com.richemont.sso.demo.usermgt.dto.login.LoginAcceptResponse;
import com.richemont.sso.demo.usermgt.dto.consent.ConsentAcceptRequest;
import com.richemont.sso.demo.usermgt.dto.login.LoginResponse;
import com.richemont.sso.demo.usermgt.dto.logout.LogoutAcceptRequest;
import com.richemont.sso.demo.usermgt.dto.logout.LogoutAcceptResponse;
import com.richemont.sso.demo.usermgt.dto.logout.LogoutResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * The API implementation
 */
@Api("SSO Demo User Management Service")
@ApiResponses({
        @ApiResponse(code = 200, message = "If the submitted request has been processed"),
        @ApiResponse(code = 400, message = "If the submitted inputs are not valid"),
        @ApiResponse(code = 500, message = "If an unexpected exception occurs on server side"),
        @ApiResponse(code = 502, message = "If service returns an unexpected response"),
        @ApiResponse(code = 503, message = "If service is unavailable"),
        @ApiResponse(code = 504, message = "If service is timeout")})
@Slf4j
@RequestMapping("/v1/")
@RequiredArgsConstructor
@RestController
public class UserMgtController {

    private final AuthClient authClient;

    /**
     * Entry-point to handle login request
     *
     * @param challenge the id of the login request
     * @return the sum of the args ad of firstArg + secondArg
     */
    @ApiOperation(value = "Entry-point to handle login request")
    @GetMapping("/login")
    public ResponseEntity<Void> login(@RequestParam("login_challenge") String challenge, UriComponentsBuilder builder) {
        log.info("received incoming request: login");
        LoginResponse loginResponse = authClient.loginRequest(challenge);
        log.info(loginResponse.toString());
        URI redirectTo;
        if (loginResponse.isSkip()) {
            LoginAcceptRequest acceptLoginRequest = LoginAcceptRequest.builder().subject(loginResponse.getSubject()).build();
            LoginAcceptResponse loginAcceptResponse = authClient.loginAcceptRequest(challenge, acceptLoginRequest);
            redirectTo = URI.create(loginAcceptResponse.getRedirectTo());
        } else {
            UriComponents uriComponents = builder
                    .scheme("http").host("localhost").port(4200).path("login")
                    .queryParam("login_challenge", challenge)
                    .queryParam("redirect_uri", "http://localhost:8087/v1/login")
                    .build();
            redirectTo = uriComponents.toUri();
        }
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(redirectTo)
                .build();
    }

    /**
     * Entry-point to handle login request
     *
     * @param userName  the credentials username of the login request
     * @param password  the credentials password of the login request
     * @param challenge the auth server challenge
     * @return the sum of the args ad of firstArg + secondArg
     */
    @ApiOperation(value = "Entry-point to handle login request")
    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> loginResponse(
            @RequestParam("username") String userName,
            @RequestParam("password") String password,
            @RequestParam("login_challenge") String challenge) {
        log.info("received incoming request: login check");
        LoginAcceptRequest acceptLoginRequest = LoginAcceptRequest.builder()
                .subject(userName)
                .remember(true)
                .rememberFor(3600)
                .build();
        LoginAcceptResponse loginAcceptResponse = authClient.loginAcceptRequest(challenge, acceptLoginRequest);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(loginAcceptResponse.getRedirectTo()))
                .build();
    }

    /**
     * Entry-point to handle consent request
     *
     * @param challenge the id of the consent request
     * @return the sum of the args ad of firstArg + secondArg
     */
    @ApiOperation(value = "Entry-point to handle consent request")
    @GetMapping("/consent")
    public ResponseEntity<Void> consent(@RequestParam("consent_challenge") String challenge, UriComponentsBuilder builder) {
        log.info("received incoming request consent");
        ConsentResponse consentResponse = authClient.consentRequest(challenge);
        log.info(consentResponse.toString());
        URI redirectTo;
        if (consentResponse.isSkip()) {
            ConsentAcceptRequest consentAcceptRequest = ConsentAcceptRequest.builder()
                    .remember(true)
                    .rememberFor(3600*24*30)
                    .grantScope(consentResponse.requestedScope)
                    .session(Session.builder()
                            .idToken(IdToken.builder()
                                    .email("eskava@gmail.com")
                                    .build())
                            .build())
                    .build();
            ConsentAcceptResponse consentAcceptResponse = authClient.consentAcceptRequest(challenge, consentAcceptRequest);
            redirectTo = URI.create(consentAcceptResponse.getRedirectTo());
        } else {
            UriComponents uriComponents = builder
                    .scheme("http").host("localhost").port(4200).path("consent")
                    .queryParam("consent_challenge", challenge)
                    .queryParam("client_name", consentResponse.getClient().getClientName())
                    .queryParam("requested_scope", consentResponse.requestedScope)
                    .queryParam("redirect_uri", "http://localhost:8087/v1/consent")
                    .build();
            redirectTo = uriComponents.toUri();
        }

        return ResponseEntity.status(HttpStatus.FOUND)
                .location(redirectTo)
                .build();
    }

    /**
     * Entry-point to handle consent request
     *
     * @param challenge the id of the consent request
     * @return the sum of the args ad of firstArg + secondArg
     */
    @ApiOperation(value = "Entry-point to handle consent response")
    @PostMapping(value = "/consent", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<Void> consentResponse(
            @RequestParam("consent_challenge") String challenge,
            @RequestParam("authorized_scope") String[] authorizedScope) {
        log.info("received incoming consent response");
        ConsentAcceptRequest consentAcceptRequest = ConsentAcceptRequest.builder()
                .remember(true)
                .rememberFor(3600*24*30)
                .grantScope(authorizedScope)
                .session(Session.builder()
                        .idToken(IdToken.builder()
                                .email("eskava@gmail.com")
                                .build())
                        .build())
                .build();
        ConsentAcceptResponse consentAcceptResponse = authClient.consentAcceptRequest(challenge, consentAcceptRequest);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(consentAcceptResponse.getRedirectTo()))
                .build();
    }

    /**
     * Entry-point to handle logout request
     *
     * @param challenge the id of the logout request
     * @return the sum of the args ad of firstArg + secondArg
     */
    @ApiOperation(value = "Entry-point to handle logout request")
    @GetMapping("/logout")
    public ResponseEntity<Void> logout(@RequestParam("logout_challenge") String challenge) {
        log.info("received incoming request");
        LogoutResponse logoutResponse = authClient.logoutRequest(challenge);
        LogoutAcceptResponse logoutAcceptResponse = authClient.logoutAcceptRequest(challenge, LogoutAcceptRequest.builder().build());
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(logoutAcceptResponse.getRedirectTo()))
                .build();
    }
}
