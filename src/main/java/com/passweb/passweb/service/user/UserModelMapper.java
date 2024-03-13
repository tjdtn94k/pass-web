package com.passweb.passweb.service.user;

import com.passweb.passweb.repository.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserModelMapper {
    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    /**
     * UserEntity 객체를 UserModel 객체로 변환합니다.
     *
     * @param userEntity 변환할 UserEntity 객체
     * @return 변환된 UserModel 객체
     */
    User toUser(UserEntity userEntity);

}
