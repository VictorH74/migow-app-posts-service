package com.service.posts.migow.migow_posts_service.domain.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    private UUID id;
    @Column(name = "username", nullable = false, length = 25)
    @NonNull
    private String username;
    @Column(name = "password", nullable = false, length = 25)
    @NonNull
    private String password;
    @Column(name = "name", nullable = false, length = 50)
    @NonNull
    private String name;
    @Column(name = "email", nullable = false, length = 50)
    @Email(message = "Invalid email")
    @NonNull
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserRole> roles = new HashSet<>();

    public User(UUID id, @NonNull String username, @NonNull String password, @NonNull String name,
            @Email(message = "Invalid email") @NonNull String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
    }

}
