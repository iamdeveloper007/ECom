package com.ecom.ecom.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDetail {
  int quantity;
  Long productId;
  String productName;
  Float price;
  String description;
}