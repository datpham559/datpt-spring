package rest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import rest.dto.LoginRequest;
import rest.dto.LoginResponse;
import rest.security.jwt.JwtTokenProvider;
import rest.security.userDetails.CustomUserDetails;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api")
public class JwtController {
    private final Logger log = LoggerFactory.getLogger(JwtController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider tokenProvider;

    public JwtController(AuthenticationManager authenticationManager, JwtTokenProvider tokenProvider) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
    }


    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) throws Exception {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );
            SecurityContextHolder.getContext().setAuthentication(authentication);
            String jwt = tokenProvider.createJwtToken((CustomUserDetails) authentication.getPrincipal());
            return ResponseEntity.ok(new LoginResponse(jwt));
        }catch (Exception e){
            log.error("");
        }
        throw new Exception("Lỗi ở login");
    }
    @GetMapping(value = {"/","/home"})
    public ResponseEntity<String> home(){
        return ResponseEntity.ok("Chào mừng bạn đến với trang chủ");
    }
}
