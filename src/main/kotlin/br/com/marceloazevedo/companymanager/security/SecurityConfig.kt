package br.com.marceloazevedo.companymanager.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
class SecurityConfig(private val userDetailsService: UserDetailsService) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity?) {
        http!!
                .httpBasic().disable()
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/clients")
                    .permitAll() // resource to register a user client
                .and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/session").permitAll() // get session
                    .anyRequest().authenticated()
                .and()

                    // filter the requisition of the login
                    .addFilterBefore(JWTSessionFilter("/session", authenticationManager()),
                            UsernamePasswordAuthenticationFilter::class.java)

                    // filter the others requisitions to verify the JWT presence in header
                    .addFilterBefore(JWTAuthorizationFilter(authenticationManager()),
                            UsernamePasswordAuthenticationFilter::class.java)
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth!!.userDetailsService(userDetailsService)
    }

}