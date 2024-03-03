package com.neoris.proy.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.List;

import static com.neoris.proy.utilities.Constantes.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class UserRequest {

    @NotNull(message = NAME_NULL_ERROR_MESSAGE)
    @NotBlank(message = NAME_EMPTY_ERROR_MESSAGE)
    private String name;
    @NotNull(message = EMAIL_NULL_ERROR_MESSAGE)
    @NotBlank(message = EMAIL_EMPTY_ERROR_MESSAGE)
    @Email(message = EMAIL_FORMAT_ERROR_MESSAGE)
    private String email;
    @NotNull(message = CREDENTIALS_NULL_ERROR_MESSAGE)
    @NotBlank(message = CREDENTIALS_EMPTY_ERROR_MESSAGE)
    @Pattern(regexp = PATTERN_CREDENTIALS, message = CREDENTIALS_FORMAT_ERROR_MESSAGE)
    private String password;
    @Valid
    @NotNull(message = PHONES_NULL_ERROR_MESSAGE)
    @NotEmpty(message = PHONES_EMPTY_ERROR_MESSAGE)
    private List<PhoneRequest> phones;

}
