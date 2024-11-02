package org.minh.auth.repository;

import org.minh.auth.entity.CustomerLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerLoginRepository extends JpaRepository<CustomerLoginEntity, String> {
}
