package io.wealthman.web.controller;

import io.wealthman.db.entity.User;
import io.wealthman.db.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    protected UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @GetMapping()
    public User getUser(@RequestParam(name="id", required = false) UUID id, @RequestParam(name = "login", required = false) String login) {
        Optional<User> optUser = Optional.empty();
        if (id != null)
            optUser = userRepository.findById(id);
        else if (StringUtils.isNotBlank(login))
            optUser = userRepository.findByLogin(login);
        return optUser.isPresent()? optUser.get(): null;
    }

    @GetMapping("/id/{id}")
    public User getById(@PathVariable(name = "id") UUID id) {
        Optional<User> optUser = id == null? Optional.empty():
                userRepository.findById(id);
        return optUser.isPresent()? optUser.get(): null;
    }

    @GetMapping("/login/{login}")
    public User getByLogin(@PathVariable(name = "login") String login) {
        Optional<User> optUser = StringUtils.isBlank(login)? Optional.empty():
                userRepository.findByLogin(login);
        return optUser.isPresent()? optUser.get(): null;
    }

    @GetMapping("/check-login/{login}")
    public Boolean checkLogin(@PathVariable(name = "login") String login) {
        if (StringUtils.isNotBlank(login)) {
            if (userRepository.existsByLogin(login))
                return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        if (user != null) {
            user.setId(UUID.randomUUID());
            user.setCreateTs(new Date());
            user.setCreatedBy("SYSTEM");
            return userRepository.save(user);
        }
        return null;
    }

    @PostMapping("/update")
    public User updateUser(@RequestBody User user) {
        if (user != null && user.getId() != null) {
            return userRepository.save(user);
        }
        return null;
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable(name="id") UUID id) {
        userRepository.deleteById(id);
    }
}
