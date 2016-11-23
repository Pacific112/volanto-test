package pl.volanto.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.volanto.security.CrmUserDetailsService;

@Configuration
@EnableWebSecurity
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CrmUserDetailsService crmUserDetailsService;

    public SecurityConfig(CrmUserDetailsService crmUserDetailsService) {
        this.crmUserDetailsService = crmUserDetailsService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .userDetailsService(crmUserDetailsService);

        http
                .csrf()
                .disable();

        http
                .antMatcher("/api/**").httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/api/admin/**")
                .hasRole("ADMIN")
                .and()
                .authorizeRequests()
                .antMatchers("/registration")
                .permitAll();
    }
}
