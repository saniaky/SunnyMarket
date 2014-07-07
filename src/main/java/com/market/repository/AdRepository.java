package com.market.repository;

import com.market.model.Ad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by saniaky on 7/4/14.
 */
@Repository
public interface AdRepository extends JpaRepository<Ad, Long> {

}
