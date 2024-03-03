package com.neoris.proy.utilities;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

import static com.neoris.proy.utilities.Constantes.DATE_PATTERN;

public class Date {

    public Date(){

    }

    public static String dateNow() {
        return DateTimeFormatter.ofPattern(DATE_PATTERN)
                .withZone(ZoneOffset.UTC)
                .format(LocalDateTime.now());
    }


}
