package com.neoris.proy.response;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private Long id;
    private String created;
    private String modified;
    private String lastLogin;
    private String token;
    private boolean active;
}
