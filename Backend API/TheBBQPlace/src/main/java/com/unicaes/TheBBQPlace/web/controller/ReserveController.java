package com.unicaes.TheBBQPlace.web.controller;

import com.unicaes.TheBBQPlace.domain.service.ClientService;
import com.unicaes.TheBBQPlace.domain.service.ReserveService;
import com.unicaes.TheBBQPlace.domain.service.dto.ReservaDto;
import com.unicaes.TheBBQPlace.persistence.entity.ClientEntity;
import com.unicaes.TheBBQPlace.persistence.entity.ReserveEntity;
import com.unicaes.TheBBQPlace.web.config.JwtUtil;
import jakarta.persistence.EntityNotFoundException;
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
    public ResponseEntity<ReserveEntity> save(@RequestBody ReservaDto reserve, @RequestHeader("Authorization") String token) {
        String email = jwtUtil.extractUsername(token.substring(7));

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated() && !(authentication instanceof AnonymousAuthenticationToken)) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            if (!jwtUtil.validateToken(token.substring(7), userDetails)) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
            }
        }
        try {
            ReserveEntity reservation = reserveService.save(reserve, email);
            return new ResponseEntity<>(reservation, HttpStatus.CREATED);
        } catch (EntityNotFoundException e) {
            // Aquí capturamos la excepción y devolvemos un 404 Not Found
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            // Otras excepciones pueden ser manejadas aquí también
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
