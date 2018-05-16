package io.wealthman.services;

import io.wealthman.db.entity.User;
import io.wealthman.requests.CreateUserArguments;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ManagerService {

    final User userEntity = new User();

    public void create(final CreateUserArguments arguments) {
        userEntity.setName(arguments.getName());
        userEntity.setParams(arguments.getParams());
        userEntity.setEmail(arguments.getEmail());
        userEntity.setRoles(arguments.getRoles());
        userEntity.setState(arguments.getState());
        userEntity.setWallet(arguments.getWallet());
    }

    public void delete(final Long id) {

    }

}
