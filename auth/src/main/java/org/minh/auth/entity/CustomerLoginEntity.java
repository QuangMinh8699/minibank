package org.minh.auth.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerLoginEntity {

    @Id
    private String id;
    private String username;
    private String password;
    private String idType;
    private String idNumber;

}
