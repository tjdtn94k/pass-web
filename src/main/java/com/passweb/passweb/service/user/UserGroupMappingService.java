package com.passweb.passweb.service.user;

import com.passweb.passweb.repository.user.UserGroupMappingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserGroupMappingService {

    private final UserGroupMappingRepository userGroupMappingRepository;

    public UserGroupMappingService(UserGroupMappingRepository userGroupMappingRepository) {
        this.userGroupMappingRepository = userGroupMappingRepository;
    }

    /**
     * 모든 사용자 그룹 ID 목록을 가져옵니다.
     * 중복 제거된 사용자 그룹 ID만 반환합니다.
     *
     * @return 모든 사용자 그룹 ID 목록 (중복 제거됨)
     */
    public List<String> getAllUserGroupIds() {
        /**
         * UserGroupMappingRepository 를 사용하여 중복 제거된 사용자 그룹 ID 목록을 조회합니다.
         */
        return userGroupMappingRepository.findDistinctUserGroupId();
    }
}
