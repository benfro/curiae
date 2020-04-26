package net.benfro.curiae.plannerbackend.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Override
   protected void configure(HttpSecurity security) throws Exception {
      //security.httpBasic().disable();
      security.mvcMatcher("/h2-console/**").authorizeRequests().anyRequest().authenticated();
   }

   @Override
   protected void configure(AuthenticationManagerBuilder auth) throws Exception {
      auth.inMemoryAuthentication()
              .withUser("user").password("password").roles("USER").and()
              .withUser("admin").password("password").roles("USER", "ADMIN");

   }

   // Expose the UserDetailsService as a Bean
   //@Bean
   //@Override
   //public UserDetailsService userDetailsServiceBean() throws Exception {
   //   return super.userDetailsServiceBean();
   //}

}
