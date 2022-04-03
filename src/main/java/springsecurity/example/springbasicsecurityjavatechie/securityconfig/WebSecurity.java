package springsecurity.example.springbasicsecurityjavatechie.securityconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurity extends WebSecurityConfigurerAdapter {

    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication().withUser("phakocy").password("1234").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("ekwe").password("lamba").roles("USER");
    }

    // SECURITY FOR ALL THE API     (When testing close the browser and start again) localhost:8086/rest/auth/getmessage

    /*
     *  protected void configure(HttpSecurity http) throws Exception {
     *  http.csrf().disable();
     *  http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic();}
     */

    //SECURITY BASED ON URL

    /*
     *  protected void configure(HttpSecurity http) throws Exception {
     *  http.csrf().disable();
     * http.authorizeRequests().antMatchers("/rest/**").fullyAuthenticated().and().httpBasic();
     * }
     */

       //ROLE BASE SECURITY      (Check Roles under authenticationManagerBuilder method)

       protected void configure(HttpSecurity http) throws Exception {
           http.csrf().disable();
           http.authorizeRequests().antMatchers("/rest/**").hasAnyRole("ADMIN").anyRequest().fullyAuthenticated().and().httpBasic();
       }


    //No password encryption
@Bean
    public static NoOpPasswordEncoder passwordEncoder(){
      return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }
}
