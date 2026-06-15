package com.ous.hospitalmanagementsystem.entity;


import com.ous.hospitalmanagementsystem.utils.RoleName;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.Set;
import java.util.UUID;

@Entity @Getter @Setter @Builder @NoArgsConstructor
@AllArgsConstructor
@Table(name = "roles")
public class RoleEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Enumerated(EnumType.STRING)
    private RoleName name;

    private String description;

    @CreationTimestamp
    private Timestamp createdAt;

    @ManyToMany(mappedBy = "roles")
    private Set<UserEntity> users;
}
