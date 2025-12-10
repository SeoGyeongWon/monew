package com.team03.monew.user.mapper;

import com.team03.monew.user.domain.User;
import com.team03.monew.user.dto.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    UserDto toDto(User user);
}

