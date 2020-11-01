package com.ecom.ecom.sorter;

import com.ecom.ecom.dto.CartDetail;
import com.ecom.ecom.entity.ProductDetail;

import java.util.Comparator;

public class PriceSorter implements Comparator<ProductDetail> {

  @Override
  public int compare(ProductDetail o1, ProductDetail o2) {
    return (int) (o2.getPrice() - o1.getPrice());
  }
}
