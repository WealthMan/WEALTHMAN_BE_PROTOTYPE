package io.wealthman.config;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@AllArgsConstructor(onConstructor = @__(@Autowired))
@SuppressWarnings("PMD.MethodArgumentCouldBeFinal")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

   // private UsersService usersService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests().antMatchers(
                "/"
                , "/**/login.html"
                , "/**/header.html"
                , "/**/footer.html").permitAll()
                .antMatchers("/**/investorDashboard.html"
                        , "/**/adminDashboard.html"
                        , "/**/managerDashboard.html"
                        , "/**/algorithmPage.html"
                        , "/**/requestPage.html"
                        , "resultPage.html").authenticated().and()
                .httpBasic().and().csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    }
}