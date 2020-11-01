package com.ecom.ecom.service;

import com.ecom.ecom.entity.ProductDetail;
import com.ecom.ecom.entity.UserDetail;
import com.ecom.ecom.repository.ProductRespository;
import com.ecom.ecom.repository.UserRespository;
import com.ecom.ecom.sorter.NameSorter;
import com.ecom.ecom.sorter.PriceSorter;
import com.ecom.ecom.util.ProducerConsumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Service
public class StoreService {

  BlockingQueue<Integer> sharedQ = new LinkedBlockingQueue<Integer>();

  @Autowired
  ProductRespository productRespository;

  @Autowired
  UserRespository userRespository;

  @Autowired
  ProducerConsumer producerConsumer;

  public List<ProductDetail> findProducts(String searchString, String orderBy) {
    List<ProductDetail> productDetails = productRespository.findProducts(searchString);
    if(CollectionUtils.isEmpty(productDetails))
      return null;
    if(orderBy.equalsIgnoreCase("name"))
      Collections.sort(productDetails, new NameSorter());
    else
      Collections.sort(productDetails, new PriceSorter());
    return productDetails;
  }

  public Boolean confirmOrder(Long userId) throws UserPrincipalNotFoundException, InterruptedException {
    UserDetail userDetail = userRespository.findByUserId(userId);
    if(null == userDetail)
      throw new UserPrincipalNotFoundException(userId.toString());
    producerConsumer.produce(userDetail);
    return true;
  }
}
