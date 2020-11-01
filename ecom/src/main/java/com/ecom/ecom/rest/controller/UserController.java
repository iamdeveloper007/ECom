package com.ecom.ecom.rest.controller;

import com.ecom.ecom.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.nio.file.attribute.UserPrincipalNotFoundException;

@RestController
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping(path = "/findProducts/{searchstring}", produces = MediaType.APPLICATION_JSON_VALUE)
  public String getProductsbyString(@PathVariable("user") String name, @PathVariable("password") String password) throws UserPrincipalNotFoundException {
    return userService.aunthenticateUser(name, password);
  }
}
