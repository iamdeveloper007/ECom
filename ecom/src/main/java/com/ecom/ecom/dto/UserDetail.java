package com.ecom.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDetail {
  Long userId;
  String name;
  String password;
  String primaryEmailId;
  String secEmailId;
  String mobileNumber;
  Long walletAmount;
}