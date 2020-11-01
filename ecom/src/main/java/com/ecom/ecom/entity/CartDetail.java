package com.ecom.ecom.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity(name = "ProductDetail")
@Table(name = "ProductDetail")
@Data
public class CartDetail {

  @Column(name = "userId")
  Long userId;

  @Column(name = "quantity")
  int quantity;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "productId", referencedColumnName = "productId")
  ProductDetail productDetail;

}