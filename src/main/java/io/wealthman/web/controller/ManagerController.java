package io.wealthman.web.controller;

import io.wealthman.common.Methods;
import io.wealthman.common.Paths;
import io.wealthman.db.entity.ManagerEntity;
import io.wealthman.db.entity.User;
import io.wealthman.requests.CreateUserArguments;
import io.wealthman.services.ManagerService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public ManagerEntity delete(@PathVariable final Long userID) {
        return managerService.delete(userID);
    }

    @PreAuthorize("hasAnyAuthority('Manager')")
    @PostMapping(value = Methods.SEARCH)
    public ManagerEntity userSearch(@PathVariable final Long userID) {
        return managerService.searchUser(userID);
    }

    @PreAuthorize("hasAnyAuthority('Manager')")
    @GetMapping(Methods.PORTFOLIO)
    public List<ManagerEntity> getPortfolio(@PathVariable final Long portfolioID) {
        return managerService.getListOfPortfolio(portfolioID);
    }

    @PreAuthorize("hasAnyAuthority('Manager')")
    @GetMapping(Methods.REQUESTS)
    public ManagerEntity getInvestorRequests(@PathVariable final String reauests) {
        return managerService.getInvestorRequests(reauests);
    }

    @PreAuthorize("hasAnyAuthority('Manager')")
    @GetMapping(Methods.ALGHORITHMS)
    public ManagerEntity getAlgorithms(@PathVariable final Long algorithmsID) {
        return managerService.getAlgorithms(algorithmsID);
    }



}
