package com.passweb.passweb.service.user;

import com.passweb.passweb.repository.user.UserEntity;
import com.passweb.passweb.repository.user.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * 사용자 ID에 해당하는 사용자 정보를 가져옵니다.
     *
     * @param userId 사용자 ID
     * @return 해당 사용자 정보 (UserEntity 또는 null)
     */
    public User getUser(final String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId);
        return UserModelMapper.INSTANCE.toUser(userEntity);

    }
}
