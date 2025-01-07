package com.kelmerdev.model;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequest {
    private String email;
    private String password;
    private String displayName;
}
