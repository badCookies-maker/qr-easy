package com.qrdemo.controllers;

import com.qrdemo.controllers.model.UserAuthenticationResponse;
import com.qrdemo.controllers.model.UserAuthenticationRequest;
import com.qrdemo.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtil jwtUtil;

    @RequestMapping(method = RequestMethod.POST, value = "/authenticate")
    public ResponseEntity<UserAuthenticationResponse> login(@RequestBody UserAuthenticationRequest authenticationRequest) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                authenticationRequest.getUserName(), authenticationRequest.getPassword());
        try {

            authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        } catch (BadCredentialsException ex) {

        }

        UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUserName());
        String jwt = jwtUtil.generateToken(userDetails);
        return ResponseEntity.ok(new UserAuthenticationResponse(jwt));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/logout")
    public UserAuthenticationResponse logout(@RequestBody UserAuthenticationRequest authenticationRequest) {
        return new UserAuthenticationResponse("");
    }
}
