package io.wealthman.web.controller;

import io.wealthman.common.Methods;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class Authorization {
    @PreAuthorize("permitAll()")
    @GetMapping(Methods.SIGN_IN)
    public LoginInfo signIn() {
        return usersService.signIn();
    }

    @PreAuthorize("isAuthenticated()")
    @PostMapping(Methods.SIGN_OUT)
    public void signOut() {
        usersService.signOut();
    }

    @PreAuthorize("permitAll()")
    @PostMapping(Methods.SIGN_UP)
    public void signUp(@RequestBody final SignUpRequestArguments arguments, final HttpServletRequest request) {
        final String hostName = request.getHeader("referer");
        usersService.signUp(arguments, hostName);
    }

    @PreAuthorize("permitAll()")
    @PutMapping(Methods.VERIFY_SIGN_UP)
    public void
    verifySignUp(@RequestBody final VerifySignUpRequestArguments arguments) {
        usersService.verifySignUp(arguments.getEmail(), arguments.getToken());
    }
}
