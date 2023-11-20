package com.unicaes.TheBBQPlace.web.controller;

import com.unicaes.TheBBQPlace.domain.service.ClientService;
import com.unicaes.TheBBQPlace.domain.service.ReserveService;
import com.unicaes.TheBBQPlace.domain.service.dto.ReservaDto;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import com.unicaes.TheBBQPlace.persistence.entity.ReserveEntity;
import com.unicaes.TheBBQPlace.web.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/reserve")
public class ReserveController {
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;
    @Autowired
    public ReserveService reserveService;
    @Autowired
    public ClientService clientService;
    @Autowired
    public ReserveController(JwtUtil jwtUtil, AuthenticationManager authenticationManager) {
        this.jwtUtil = jwtUtil;
        this.authenticationManager = authenticationManager;
    }
    @PostMapping("/date")
    public ResponseEntity<ReserveEntity> save(@RequestBody ReserveEntity reserve, @RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            if (!jwtUtil.validateToken(token.substring(7), userDetails)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        return reserveService.save(reserve);
    }

   /* @GetMapping("/history")
    public ResponseEntity<?> gethistory(Authentication authentication) {
        String email = ((UserDetails) authentication.getPrincipal()).getUsername();

        ClientEntity client = clientService.getprofile(email);

        if (client == null) {
            return ResponseEntity.notFound().build();
        }
        Map<String, Object> profile = new HashMap<>();
        profile.put("name", client.getName());

        return ResponseEntity.ok(profile);
    }*/

}
