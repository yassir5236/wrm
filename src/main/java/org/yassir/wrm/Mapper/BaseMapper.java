package org.yassir.wrm.Mapper;

public interface BaseMapper <E, D , R> {


    E toEntity(D dto);

    R toResponseDto(E entity);

    E toEntityFromResponseDto(R responseDto);
}