package org.minh.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String cif;
    private String accountNumber;
    private String accountClass;
    private String branchCode;
    private String totalAmount;
    private String status;
    private LocalDateTime createDate;
    private LocalDateTime updateDate;
}
