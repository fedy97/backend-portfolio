package com.fedy97.springbootserver.utils;

import org.modelmapper.ModelMapper;

public class Utils {
    private static final ModelMapper modelMapper;

    private Utils() {

    }

    static {
        modelMapper = new ModelMapper();
    }

    public static <T, G> T convertEntityToDto(G entity, Class<T> dtoClass) {
        return modelMapper.map(entity, dtoClass);
    }

    public static <T, G> G convertDtoToEntity(T dto, Class<G> entityClass) {
        return modelMapper.map(dto, entityClass);
    }
}
