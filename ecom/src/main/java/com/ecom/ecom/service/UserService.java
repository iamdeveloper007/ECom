package com.ecom.ecom.service;

import com.auth0.jwt.Algorithm;
import com.ecom.ecom.entity.ProductDetail;
import com.ecom.ecom.entity.UserDetail;
import com.ecom.ecom.repository.ProductRespository;
import com.ecom.ecom.repository.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

  @Autowired
  UserRespository userRespository;

  public String aunthenticateUser(String name, String password) throws UserPrincipalNotFoundException {
    UserDetail userDetail = userRespository.aunthenticateUser(name, password);
    if(null == userDetail)
      throw new UserPrincipalNotFoundException("name");
    else
      return createToken(userDetail.getUserId());
  }

  public String createToken(Long userId) {
    try {
      String token = JWT.create()
          .withClaim("userId", userId.toString())
          .withClaim("createdAt", new Date())
          .sign(Algorithm.HS256);
      return token;
    } catch (UnsupportedEncodingException exception) {
      exception.printStackTrace();
    } catch (JWTCreationException exception) {
    }
    return null;
  }
}
