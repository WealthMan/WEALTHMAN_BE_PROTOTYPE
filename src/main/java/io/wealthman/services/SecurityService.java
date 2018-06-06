package io.wealthman.services;

import io.wealthman.db.dao.UsersMapper;
import io.wealthman.db.entity.UserEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class SecurityService {

    private final UsersMapper usersMapper;

    public Long getCurrentUserId() {
        final UserDetails principal = (UserDetails) SecurityContextHolder.getContext()
                .getAuthentication()
                .getPrincipal();
        return usersMapper.getByEmail(principal.getUsername()).getId();
    }

    public UserEntity getCurrentUserEntity() {
        final UserDetails principal = (UserDetails) SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getPrincipal();
        return usersMapper.getByEmail(principal.getUsername());
    }
}
