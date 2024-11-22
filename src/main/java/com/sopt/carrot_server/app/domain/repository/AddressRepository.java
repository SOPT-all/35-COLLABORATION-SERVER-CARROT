package com.sopt.carrot_server.app.domain.repository;

import com.sopt.carrot_server.app.domain.Address;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}
