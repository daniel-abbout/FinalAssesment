package com.example.finaleAssignment.config;

import com.example.finaleAssignment.Filter.JWTTokenGeneratorFilter;
import com.example.finaleAssignment.Filter.JWTTokenValidatorFilter;
import com.example.finaleAssignment.Security.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.ldap.authentication.ad.ActiveDirectoryLdapAuthenticationProvider;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Autowired
    private Environment env;

    @Autowired
    private JwtTokenProvider jwtTokenProvider; 

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        CsrfTokenRequestAttributeHandler requestHandler = new CsrfTokenRequestAttributeHandler();
        requestHandler.setCsrfRequestAttributeName("_csrf");
        http
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeRequests(authorize -> authorize
                         .requestMatchers("/users", "/albums", "/Photos").hasRole("ADMIN")
                )
                .addFilterBefore(new JWTTokenValidatorFilter(jwtTokenProvider), BasicAuthenticationFilter.class) 
                .addFilterAfter(new JWTTokenGeneratorFilter(jwtTokenProvider), BasicAuthenticationFilter.class) 
                .sessionManagement(session -> session.maximumSessions(1))
                .httpBasic(withDefaults())
                .formLogin(withDefaults())
                .httpBasic(withDefaults())
                .authenticationProvider(activeDirectoryLdapAuthenticationProvider());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public ActiveDirectoryLdapAuthenticationProvider activeDirectoryLdapAuthenticationProvider() {
        ActiveDirectoryLdapAuthenticationProvider provider =
                new ActiveDirectoryLdapAuthenticationProvider(env.getProperty("ldap.domain"),
                        env.getProperty("ldap.url"));
        provider.setConvertSubErrorCodesToExceptions(true);
        provider.setUseAuthenticationRequestCredentials(true);
        return provider;
    }
}
