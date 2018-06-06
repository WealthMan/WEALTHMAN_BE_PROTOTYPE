package io.wealthman.services;

import io.wealthman.db.dao.UsersMapper;
import io.wealthman.db.entity.UserEntity;
import io.wealthman.enums.UserRole;
import io.wealthman.enums.UserStatus;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CompletableFuture;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class UserService implements UserDetailsService {


    private final SecurityService securityService;
    private final UsersMapper usersMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final UserEntity userEntity = usersMapper.getByEmail(username);

        if (userEntity == null)
            throw new UsernameNotFoundException("Such user doesn't exist");

        final List<GrantedAuthority> list = new ArrayList<>();
        list.add(new SimpleGrantedAuthority(userEntity.getRole().toString()));

        final User userDetails = new User(userEntity.getEmail(),
                userEntity.getPasswordHash(),
                userEntity.getStatus() != UserStatus.Disabled,
                true,
                true,
                userEntity.getStatus() != UserStatus.Disabled,
                list);

        return userDetails;
    }

    private UserRole getUserRoleFromString(final String value) {
        final String validUserRoleName = StringUtils.capitalize(value.toLowerCase(Locale.ENGLISH));
        try {
            return UserRole.valueOf(validUserRoleName);
        } catch (IllegalArgumentException ex) {
            throw new IllegalArgumentException("Incorrect User Role");
        }
    }

    public void delete(final long id) {
        if (securityService.getCurrentUserId() == id)
            System.out.println("It is impossible to delete your own account");

        final UserEntity deletedUser = usersMapper.getById(id);
        deletedUser.setRegistrationDate(null);
        usersMapper.delete(id);
    }
}
