package com.neoris.proy.model;

import com.neoris.proy.dto.PhoneDTO;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_seq", allocationSize = 1)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(unique = true, name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "PHONES")
    @ElementCollection
    private List<PhoneDTO> phones;

    @Column(name = "CREATED")
    private String created;

    @Column(name = "MODIFIED")
    private String modified;

    @Column(name = "LAST_LOGIN")
    private String lastLogin;

    @Column(name = "TOKEN")
    private String token;

    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> roles = new ArrayList<>();

    @Column(name = "ACTIVE")
    private boolean active;

    public User(
            final String name,
            final String email,
            final String password,
            final String created,
            final String modified,
            final String lastLogin,
            final String token,
            final List<String> roles,
            final boolean active) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.created = created;
        this.modified = modified;
        this.lastLogin = lastLogin;
        this.token = token;
        this.roles = roles;
        this.active = active;
    }



}
