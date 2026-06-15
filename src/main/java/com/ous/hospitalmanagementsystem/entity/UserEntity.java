package com.ous.hospitalmanagementsystem.entity;
import com.ous.hospitalmanagementsystem.utils.Gender;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;

@Entity
@Builder @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "phoneNumber")
})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String userId;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

    @Column(length = 20)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Builder.Default
    private Boolean credentialsNonExpired=true;
    @Builder.Default
    private Boolean accountNonLocked=true;
    @Builder.Default
    private Boolean enabled=true;

    private LocalDate dateOfBirth;
    private String profilePicture;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns= @JoinColumn(name="role_id"))
    private Set<RoleEntity> roles;
}
