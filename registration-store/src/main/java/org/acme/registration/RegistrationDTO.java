package org.acme.registration;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

public record RegistrationDTO(
@NotBlank
@NotNull
@Length(min = 3, max = 20)
        String name,

@NotBlank
@NotNull
@Length(min = 3, max = 20)
                String surname,

@NotBlank
@NotNull
@Length(min = 3, max = 20)
        String email
//        ,
//
//boolean selectedUser
                ) {

                }
