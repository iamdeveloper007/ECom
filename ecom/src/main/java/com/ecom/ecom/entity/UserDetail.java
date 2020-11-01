package com.ecom.ecom.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity(name = "UserDetail")
@Table(name = "UserDetail")
@Data
public class UserDetail {

  @Id
  @GeneratedValue
  @Column(name = "id", nullable = false)
  Long id;

  @Column(name = "userId")
  Long userId;

  @Column(name = "name")
  String name;

  @Column(name = "primaryEmailId")
  String primaryEmailId;

  @Column(name = "secEmailId")
  String secEmailId;

  @Column(name = "mobileNumber")
  String mobileNumber;

  @Column(name = "walletAmount")
  Long walletAmount;

  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "userId", referencedColumnName = "userId")
  List<CartDetail> productDetailList;
}