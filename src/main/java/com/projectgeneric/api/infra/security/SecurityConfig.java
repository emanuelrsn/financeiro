/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.projectgeneric.api.infra.security;

import com.projectgeneric.api.security.jwt.JwtAuthenticationFilter;
import com.projectgeneric.api.security.jwt.JwtAuthorizationFilter;
import com.projectgeneric.api.security.jwt.handler.AccessDeniedHandler;
import com.projectgeneric.api.security.jwt.handler.UnauthorizedHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier(value = "userDetailsService")
    UserDetailsService userDetailservice;
    
    @Autowired
    private UnauthorizedHandler unauthorizedHandler;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        AuthenticationManager authManager = authenticationManager();

        http
                .authorizeRequests()
                .antMatchers(HttpMethod.GET, "/api/v1/login").permitAll()


//                //REMOVER QUANDO IMPLMENTAR NO PROJETO LOGIN
//                .antMatchers(HttpMethod.POST, "/api/v1/categoria*/**").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/v1/categoria").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/v1/categoria*/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/v1/categoria*/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/v1/categoria*/**").permitAll()
//
//                //REMOVER QUANDO IMPLMENTAR NO PROJETO LOGIN
//                 .antMatchers(HttpMethod.POST, "/api/v1/entrada*/**").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/v1/entrada").permitAll()
//                .antMatchers(HttpMethod.PUT, "/api/v1/entrada*/**").permitAll()
//                .antMatchers(HttpMethod.GET, "/api/v1/entrada*/**").permitAll()
//                .antMatchers(HttpMethod.DELETE, "/api/v1/entrada*/**").permitAll()
                
                
                .antMatchers(HttpMethod.POST, "/api/v1/usuario").permitAll()
                .antMatchers("/v2/api-docs", "/configuration/**", "/swagger*/**", "/webjars/**")
                .permitAll()
                .anyRequest().authenticated()
                .and().csrf().disable()
                .addFilter(new JwtAuthenticationFilter(authManager))
                .addFilter(new JwtAuthorizationFilter(authManager, userDetailservice))
                .exceptionHandling()
                .accessDeniedHandler(accessDeniedHandler)
                .authenticationEntryPoint(unauthorizedHandler)
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        auth.userDetailsService(userDetailservice).passwordEncoder(encoder);

//        auth
//                .inMemoryAuthentication().passwordEncoder(encoder)
//                .withUser("user").password(encoder.encode("user")).roles("USER")
//                .and()
//                .withUser("admin").password(encoder.encode("admin")).roles("USER", "ADMIN");
    }
    
    /*
    
    Caso queria usar o fitro do CORS para habilitar por URL
    @Bean
    public FilterRegistrationBean processCorsFilter() {
        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        final CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("http://localhost:4200");
        config.addAllowedOrigin("http://localhost:4201");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        final FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
        bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return bean;
    }
*/
}
