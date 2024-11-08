package org.minh.common.repository;

import org.minh.common.entity.BankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccountEntity, String> {
    List<BankAccountEntity> findAllByCif(String cif);
}
