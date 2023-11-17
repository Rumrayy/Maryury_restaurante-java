package com.unicaes.TheBBQPlace.web.controller;

import com.unicaes.TheBBQPlace.domain.service.ClientService;
import com.unicaes.TheBBQPlace.domain.service.dto.LoginDto;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import com.unicaes.TheBBQPlace.persistence.entity.LoginResponse;
import com.unicaes.TheBBQPlace.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class ClientController {
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    @Autowired
    private ClientService clientService;

    @Autowired
    public ClientController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/signup")
    public ClientEntity save(@RequestBody ClientEntity client){
        return clientService.save(client);
    }

    @GetMapping("/{id}")
    public ClientEntity getId(@PathVariable("id") int clientId) {
        return clientService.getId(clientId);
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginDto loginDto){
        UsernamePasswordAuthenticationToken login = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
        Authentication authentication = this.authenticationManager.authenticate(login);

        System.out.println(authentication.isAuthenticated());
        System.out.println(authentication.getPrincipal());

        String jwt = this.jwtUtil.create(loginDto.getEmail());

        LoginResponse response = new LoginResponse("Login exitoso", loginDto.getEmail(), jwt);


        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, jwt).body(response);
    }

    @GetMapping("/login/profile")
    public ResponseEntity<?> getProfile(Authentication authentication) {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();
        ClientEntity client = clientService.getprofile(email);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        Map<String, Object> profile = new HashMap<>();
        profile.put("name", client.getName());
        profile.put("lastname", client.getLastname());
        profile.put("email", client.getEmail());
        profile.put("cellphone", client.getCellphone());

        return ResponseEntity.ok(profile);
    }

}
