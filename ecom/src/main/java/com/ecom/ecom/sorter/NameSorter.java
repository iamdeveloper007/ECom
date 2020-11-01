package com.ecom.ecom.sorter;


import com.ecom.ecom.dto.CartDetail;
import com.ecom.ecom.entity.ProductDetail;

import java.util.Comparator;

public class NameSorter implements Comparator<ProductDetail> {

  @Override
  public int compare(ProductDetail o1, ProductDetail o2) {
    return o1.getProductName().compareTo(o2.getProductName());
  }
}
