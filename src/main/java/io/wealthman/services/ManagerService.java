package io.wealthman.services;

import io.wealthman.db.dao.ManagersMapper;
import io.wealthman.db.dao.UsersMapper;
import io.wealthman.db.entity.ManagerEntity;
import io.wealthman.db.entity.User;
import io.wealthman.requests.CreateUserArguments;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class ManagerService {
    private UsersMapper usersMapper;
    private ManagersMapper managersMapper;
    final User userEntity = new User();

    public void create(final CreateUserArguments arguments) {
        userEntity.setName(arguments.getName());
        userEntity.setParams(arguments.getParams());
        userEntity.setEmail(arguments.getEmail());
        userEntity.setRoles(arguments.getRoles());
        userEntity.setState(arguments.getState());
        userEntity.setWallet(arguments.getWallet());
    }

    public final void delete(final Long id) {
        if (!usersMapper.delete(id))
            System.out.println("Failed to create group");
    }

    public ManagerEntity searchUser(final Long id) {

    }

    public void updateUser(final  CreateUserArguments arguments){

    }

    public final ManagerEntity getListOfPortfolio(final Long id) {

    }

    public final ManagerEntity getInvestorRequests(final String  requests) {

    }

    public final ManagerEntity getAlgorithms(final Long id) {

    }


}
