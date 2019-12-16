package com.briup.coursesystem.config;

import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Spring Security配置，目前不需要使用
 */
//@Configuration
//@EnableWebSecurity(debug = false)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

//        http.authorizeRequests()
//                .antMatchers("/").permitAll()
//                .anyRequest().hasAnyRole("USER", "ADMIN")
//        .and().formLogin();
        http.authorizeRequests()
	        .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
        	.antMatchers("/**").authenticated()
        	.and()
        	.oauth2Login();
    }

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        super.configure(web);
//        web.ignoring().antMatchers("/favicon.ico") ;
//    }

}
