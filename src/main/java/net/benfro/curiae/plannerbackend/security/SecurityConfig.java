package net.benfro.curiae.plannerbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserService userDetailService;


   @Override
   public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/h2-console/**", "/fragments/**");
   }

   @Override
   protected void configure(HttpSecurity security) throws Exception {
      //security.httpBasic().disable();
      //security.mvcMatcher("/h2-console/**").authorizeRequests().anyRequest().authenticated();
      security.formLogin()
              .defaultSuccessUrl("/")
              .and()
              .logout()
              .permitAll()
              .and()
              .authorizeRequests()
              .antMatchers("/**")
              .hasRole("USER");
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
      auth.inMemoryAuthentication()
              .withUser("user")
              .password(encoder.encode("password"))
              .roles("USER").and()
              .withUser("admin")
              .password(encoder.encode("password"))
              .roles("USER", "ADMIN");
   }

   @Override
   protected UserDetailsService userDetailsService() {
      return userDetailService;
   }


}
