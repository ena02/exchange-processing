package com.ena.bank.processing.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ResourceServerConfiguration {

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-uri}")
    private String introspectionUri;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.resourceserver.opaque.introspection-client-secret}")
    private String clientSecret;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize.anyRequest().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .opaqueToken(opaqueToken -> opaqueToken
                                .introspectionUri(introspectionUri)
                                .introspectionClientCredentials(clientId, clientSecret))
                );
        return http.build();
    }


    /*public OpaqueTokenIntrospector introspector() {
        return new NimbusOpaqueTokenIntrospector(introspectionUri, clientId, clientSecret);
    }*/
}
