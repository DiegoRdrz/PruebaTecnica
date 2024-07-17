package com.DiegoRdrz.PruebaTecnica.Controller;

import com.DiegoRdrz.PruebaTecnica.DTO.RequestResponseDTO;
import com.DiegoRdrz.PruebaTecnica.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    private AuthenticationService authenticationService;
    @PostMapping("/signin")
    public ResponseEntity<RequestResponseDTO> signIn(@RequestBody RequestResponseDTO signInRequest){
        return ResponseEntity.ok(authenticationService.signIn(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<RequestResponseDTO> signUp(@RequestBody RequestResponseDTO signUpRequest){
        return  ResponseEntity.ok(authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/refresh")
    public ResponseEntity<RequestResponseDTO> refreshToken(@RequestBody RequestResponseDTO refreshTokenRequest){
        return ResponseEntity.ok(authenticationService.refreshToken(refreshTokenRequest));
    }



}
