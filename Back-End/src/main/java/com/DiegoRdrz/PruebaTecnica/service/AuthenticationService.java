package com.DiegoRdrz.PruebaTecnica.service;

import com.DiegoRdrz.PruebaTecnica.DTO.RequestResponseDTO;
import com.DiegoRdrz.PruebaTecnica.Model.User;
import com.DiegoRdrz.PruebaTecnica.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AuthenticationService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private JWTUtils jwtUtils;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public RequestResponseDTO signUp(RequestResponseDTO registrationRequest){
        RequestResponseDTO response = new RequestResponseDTO();
        try{
            User user = new User();
            user.setEmail(registrationRequest.getEmail());
            user.setPassword(passwordEncoder.encode(registrationRequest.getPassword()));
            user.setRole(registrationRequest.getRole());
            User userResult = userRepository.save(user);
            if(userResult.getId() != null){
                response.setUser(userResult);
                response.setMessage("User saved seccessfully");
                response.setStatusCode(200);
            }
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public RequestResponseDTO signIn(RequestResponseDTO signinRequest){
        RequestResponseDTO response = new RequestResponseDTO();
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signinRequest.getEmail(),signinRequest.getPassword()));
            var user = userRepository.findByEmail(signinRequest.getEmail()).orElseThrow();
            System.out.println("USER IS: "+ user);
            var jwt = jwtUtils.generateToken(user);
            var refreshToken = jwtUtils.generateRefreshToken(new HashMap<>(), user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshToken);
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Signed In");
        }catch (Exception e){
            response.setStatusCode(500);
            response.setError(e.getMessage());
        }
        return response;
    }

    public RequestResponseDTO refreshToken(RequestResponseDTO refreshTokenReqiest){
        RequestResponseDTO response = new RequestResponseDTO();
        String Email = jwtUtils.extractUserName(refreshTokenReqiest.getToken());
        User user = userRepository.findByEmail(Email).orElseThrow();
        if (jwtUtils.isTokenValid(refreshTokenReqiest.getToken(), user)) {
            var jwt = jwtUtils.generateToken(user);
            response.setStatusCode(200);
            response.setToken(jwt);
            response.setRefreshToken(refreshTokenReqiest.getToken());
            response.setExpirationTime("24Hr");
            response.setMessage("Successfully Refreshed Token");
        }
        response.setStatusCode(500);
        return response;
    }
}