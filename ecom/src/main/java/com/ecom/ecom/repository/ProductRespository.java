package com.ecom.ecom.repository;

import com.ecom.ecom.entity.ProductDetail;
import com.ecom.ecom.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<ProductDetail, Long> {
    @Query("from ProductDetail Where productName like ?1 order by price asc group by productName")
    List<ProductDetail> findProducts(String searchString);
}
