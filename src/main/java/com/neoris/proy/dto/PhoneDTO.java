package com.neoris.proy.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PhoneDTO implements Serializable {

    //@NotNull(message = NUMBER_NULL_ERROR_MESSAGE)
    //@NotBlank(message = NUMBER_EMPTY_ERROR_MESSAGE)
    private String number;

    //@NotNull(message = CITYWIDE_NULL_ERROR_MESSAGE)
    //@NotBlank(message = CITYWIDE_EMPTY_ERROR_MESSAGE)
    private String cityCode;

    //@NotNull(message = COUNTRYSIDE_NULL_ERROR_MESSAGE)
    //@NotBlank(message = COUNTRYSIDE_EMPTY_ERROR_MESSAGE)
    private String countryCode;

}
