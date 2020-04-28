package net.benfro.curiae.plannerbackend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   private UserService userDetailService;


   @Override
   public void configure(WebSecurity web) throws Exception {
      web.ignoring().antMatchers("/h2-console/**");
   }

   @Override
   protected void configure(HttpSecurity security) throws Exception {
      //security.httpBasic().disable();
      //security.mvcMatcher("/h2-console/**").authorizeRequests().anyRequest().authenticated();
      security.formLogin()
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
