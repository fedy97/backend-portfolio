package com.fedy97.springbootserver.security;

import com.fedy97.springbootserver.utils.handlers.AuthEntryPointHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * this class manages basic auth and authentication/authorization routes
 */
@Configuration
public class BasicAuthWebSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, AuthEntryPointHandler unauthorizedHandler) throws Exception {
        http
                .cors().and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/portfolio/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager userDetailsService(Environment environment) {
        UserDetails user = User
                .withUsername(environment.getProperty("environment.basic.username"))
                .password("{noop}" + environment.getProperty("environment.basic.password"))
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }
}
