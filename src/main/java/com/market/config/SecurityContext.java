package com.market.config;

import com.market.model.UserRoleEnum;
import com.market.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by saniaky on 7/1/14.
 */
@Configuration
@EnableWebSecurity
public class SecurityContext extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().withUser("")
        auth.inMemoryAuthentication().withUser("saniaky").password("123").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("kaki").password("321").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                    .antMatchers("/assets/**").permitAll()
                    .antMatchers("/admin/**").hasRole("ADMIN")
                    .antMatchers("/profile/**").hasAnyRole("ADMIN", "USER")
                .and()
                    .formLogin()
                        .loginPage("/login")
                        .defaultSuccessUrl("/profile")
                        .failureUrl("/login?error")
                        .usernameParameter("username")
                        .passwordParameter("password")
                        .permitAll()
                .and()
                    .logout()
                    .permitAll();
    }
}
