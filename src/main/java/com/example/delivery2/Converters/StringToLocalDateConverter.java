package com.example.delivery2.Converters;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.springframework.core.convert.converter.Converter;

public class StringToLocalDateConverter implements Converter<String, LocalDate> {
    @Override
    public LocalDate convert(String source) {
        if (source.isEmpty()) {
            return null;
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(source, formatter);
    }
}
