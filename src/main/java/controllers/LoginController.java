package controllers;

import jwt.JwtTokenProvider;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserMongoRepository;

import javax.naming.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by G510 on 11-02-2019.
 */

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider jwtTokenProvider;



    @Autowired
    UserMongoRepository userRepository;

    @RequestMapping(value = "/username/{userName}/{password}/{password}")
    public Map<Object, Object> read(@PathVariable String username, @PathVariable String password) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username,password));
            String token = jwtTokenProvider.createToken(username, userRepository.getUser(username).getRoles());

            Map<Object, Object> model = new HashMap<>();
            model.put("username", username);
            model.put("token", token);
            return model;
        } catch (Exception e) {
            throw new BadCredentialsException("Invalid username/password supplied");
        }
    }




}

