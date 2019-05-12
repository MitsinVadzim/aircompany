package com.mitin.aircompany.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usr")
@Data
public class UserEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    private String username;

    private String password;

    private String email;


    @ElementCollection(targetClass = RoleEntity.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<RoleEntity> roles;

    @OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
    private List<TicketEntity> tickets;

    @ManyToMany(mappedBy = "subscribers")
    private Set<RouteEntity> subscriptions = new HashSet<>();

    public UserEntity(String username, String password, String email, Set<RoleEntity> roles) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.roles = roles;
    }

    public UserEntity() {
    }
}
