package com.ecom.ecom.rest.controller;

import com.ecom.ecom.entity.ProductDetail;
import com.ecom.ecom.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.xml.xpath.XPath;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;

@RestController
public class CartController {
  @Autowired
  StoreService storeService;

  @GetMapping(path = "/findProducts/{searchstring}/{sortBy}", produces = MediaType.APPLICATION_JSON_VALUE)
  public List<ProductDetail> getProductsbyString(@PathVariable("searchstring") String searchString,
                                                 @PathVariable("sortBy") String sortBy) {
    return storeService.findProducts(searchString, sortBy);
  }

  @PostMapping(path = "/order/{userId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public Boolean confirmOrder(@PathVariable("userId") Long userId) throws UserPrincipalNotFoundException, InterruptedException {
    return storeService.confirmOrder(userId);
  }
}
