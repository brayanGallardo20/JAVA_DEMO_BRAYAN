package com.neoris.proy.request;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class PhoneRequest {

    private String number;
    private String cityCode;
    private String countryCode;

}
