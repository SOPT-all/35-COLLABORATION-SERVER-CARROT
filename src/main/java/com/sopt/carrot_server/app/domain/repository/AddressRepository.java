package com.sopt.carrot_server.app.domain.repository;

import com.sopt.carrot_server.app.domain.Address;
import com.sopt.carrot_server.app.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
