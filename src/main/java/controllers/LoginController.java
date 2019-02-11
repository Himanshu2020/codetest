package controllers;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import repository.UserMongoRepository;

/**
 * Created by G510 on 11-02-2019.
 */

@RestController
@RequestMapping("/user")
public class LoginController {

    @Autowired
    UserMongoRepository userRepository;

    @RequestMapping(value = "/userName/{userName}/{password}/{value}")
    public User read(@PathVariable String userName, @PathVariable String password) {
        return userRepository.getUser(userName,password);
    }


}

