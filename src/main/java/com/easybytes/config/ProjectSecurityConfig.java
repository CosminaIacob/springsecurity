package com.easybytes.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration // during the startup spring will scan for all the beans that we gave define din this class
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        /**
         * Custom security configuration
         */
        http.authorizeHttpRequests(requests -> requests
                        .requestMatchers("/myAccount", "myBalance", "myLoans", "myCards").authenticated()
                        .requestMatchers("/notices", "/contact").permitAll())
                .formLogin(withDefaults())
                .httpBasic(withDefaults());

        /**
         * Configuration to deny all the requests
         */
//        http.authorizeHttpRequests(requests -> requests
//                        .anyRequest().denyAll())
//                .formLogin(withDefaults())
//                .httpBasic(withDefaults());
        /**
         * Configuration to permit all the requests
         */
//        http.authorizeHttpRequests(requests -> requests
//                        .anyRequest().permitAll())
//                .formLogin(withDefaults())
//                .httpBasic(withDefaults());
        return http.build();
    }
}
