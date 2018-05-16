package io.wealthman.web.controller;

import io.wealthman.common.Methods;
import io.wealthman.common.Paths;
import io.wealthman.db.entity.User;
import io.wealthman.requests.CreateUserArguments;
import io.wealthman.services.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * GET Dialog with Investor, POST
 * GET List of requests from Investor + UPDATE (Approve, Cancel)
 * GET List of portfolios + UPDATE
 */
@RestController
@RequestMapping(value = Paths.MANAGERS)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@SuppressWarnings("PMD.AvoidDuplicateLiterals")
public class ManagerController {

    private final ManagerService managerService;

    @PreAuthorize("hasAuthority('Manager')")
    @GetMapping(value = Methods.CREATE)
    public void createNewManager(@RequestBody final CreateUserArguments arguments) {
        managerService.create(arguments);
    }

    @PreAuthorize("hasAnyAuthority('Manager')")
    @DeleteMapping(Methods.DELETE)
    public User delete(@PathVariable final Long userID) {
        return managerService.delete(userID);
    }

    @PreAuthorize("hasAnyAuthority('Manager')")
    @PostMapping(value = Methods.SEARCH)
    public User userSearch(@PathVariable final Long id) {
        return
    }
}
