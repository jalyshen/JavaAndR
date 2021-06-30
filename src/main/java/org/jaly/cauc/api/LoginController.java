package org.jaly.cauc.api;

import org.jaly.cauc.api.dto.LoginRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@CrossOrigin
public class LoginController {

    @PostMapping(path = "/adminUser/login")
    public String loginUser(@RequestBody LoginRequest request) {
        return UUID.randomUUID().toString();
    }

}
