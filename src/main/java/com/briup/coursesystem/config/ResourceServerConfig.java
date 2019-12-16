package com.briup.coursesystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

import com.briup.coursesystem.constant.CourseSystemConstants;


/**
 * 资源服务器配置类
 */
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.resourceId(CourseSystemConstants.RESOURCE_ID);
    }


    @Override
    public void configure(HttpSecurity http) throws Exception {

        // /user/**端口作为资源服务器的资源
    	// hasRole('USER') hasRole('ROLE_USER') 都可以，但是大小写敏感
        http
    		.requestMatchers().antMatchers("/user/**")
            .and()
            .authorizeRequests()
            .antMatchers(HttpMethod.OPTIONS, "**").permitAll()
//            可以在这设置权限，也可以在方法上使用注解
//            .antMatchers("/user").access("#oauth2.hasScope('all')")
//            .antMatchers("/user").access("hasRole('ROLE_USER')")
//            .antMatchers("/user").hasAnyAuthority("ROLE_USER")
//            .antMatchers("/oauth/token").permitAll()
            .anyRequest().authenticated();

    }

}
