package com.ecom.ecom.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter
@Entity(name = "ProductDetail")
@Table(name = "ProductDetail")
@Data
public class ProductDetail {

  @Column(name = "productId")
  Long productId;

  @Column(name = "productName")
  String productName;

  @Column(name = "price")
  Float price;

  @Column(name = "description")
  String description;

}
