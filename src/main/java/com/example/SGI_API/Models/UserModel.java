package com.example.SGI_API.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
    private String username;
    private String password;
    private String role;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime created_at;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime updated_at;


    // Se ejecuta antes de persistir el objeto
    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    // Se ejecuta antes de actualizar el objeto
    @PreUpdate
    protected void onUpdate() {
        this.updated_at = LocalDateTime.now();
    }
    // Relación bidireccional con ItemModel
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemModel> items;
}



