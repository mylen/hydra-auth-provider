package com.richemont.sso.demo.usermgt.client;

import com.richemont.sso.demo.usermgt.dto.consent.ConsentAcceptResponse;
import com.richemont.sso.demo.usermgt.dto.consent.ConsentResponse;
import com.richemont.sso.demo.usermgt.dto.login.LoginAcceptRequest;
import com.richemont.sso.demo.usermgt.dto.login.LoginAcceptResponse;
import com.richemont.sso.demo.usermgt.dto.consent.ConsentAcceptRequest;
import com.richemont.sso.demo.usermgt.dto.login.LoginResponse;
import com.richemont.sso.demo.usermgt.dto.logout.LogoutAcceptRequest;
import com.richemont.sso.demo.usermgt.dto.logout.LogoutAcceptResponse;
import com.richemont.sso.demo.usermgt.dto.logout.LogoutResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * The HTTP client interface that models the inveni store API
 */
@FeignClient(value = "${demo.auth.name}",
        url = "${demo.auth.base-url}")
public interface AuthClient {

    /**
     *  Fetches information on a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @GetMapping(value = "/requests/login")
    LoginResponse loginRequest(@RequestParam(name = "challenge") final String challenge);

    /**
     *  Accepts a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "/requests/login/accept")
    LoginAcceptResponse loginAcceptRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final LoginAcceptRequest body);

    /**
     *  Rejects a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "/requests/login/reject")
    ResponseEntity<String> loginRejectRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final String body);

    /**
     *  Fetches information on a login request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @GetMapping(value = "/requests/consent")
    ConsentResponse consentRequest(@RequestParam(name = "challenge") final String challenge);

    /**
     *  Accepts a consent request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "/requests/consent/accept")
    ConsentAcceptResponse consentAcceptRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final ConsentAcceptRequest body);

    /**
     *  Rejects a consent request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "/requests/consent/reject")
    ResponseEntity<String> consentRejectRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final String body);

    /**
     *  Fetches information on a logout request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @GetMapping(value = "/requests/logout")
    LogoutResponse logoutRequest(@RequestParam(name = "challenge") final String challenge);

    /**
     *  Accepts a logout request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "/requests/logout/accept")
    LogoutAcceptResponse logoutAcceptRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final LogoutAcceptRequest body);

    /**
     *  Reject a logout request.
     *
     * @param challenge the id of the request login
     * @return The response of login service
     */
    @PutMapping(value = "/requests/logout/reject")
    ResponseEntity<String> logoutRejectRequest(@RequestParam(name = "challenge") final String challenge, @RequestBody final String body);
}
