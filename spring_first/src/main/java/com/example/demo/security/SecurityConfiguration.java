package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    //Create User - in28Minutes/dummy
    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(NoOpPasswordEncoder.getInstance())
                .withUser("subbu").password("12345")
                .roles("USER","ADMIN")
                .and()
                .withUser("admin1").password("secret1")
                .roles("ADMIN");
    }
//create a form
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/login").permitAll()
                .antMatchers("/","/*todos*/**","/h2-console").access("hasRole('USER')")
                .antMatchers("/surveys/Survey1/questions").access("hasRole('ADMIN')")
                .and()
                .formLogin();

        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
}

