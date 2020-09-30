package com.manning.ssia.milestone4_client.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@Config
public class OAuth2ClientSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
        .oauth2Client(oauth2 -> oauth2
            .clientRegistrationRepository(this.clientRegistrationRepository())
            .authorizedClientRepository(this.authorizedClientRepository())
            .authorizedClientService(this.authorizedClientService())
            .authorizationCodeGrant(codeGrant -> codeGrant
                .authorizationRequestRepository(this.authorizationRequestRepository())
                .authorizationRequestResolver(this.authorizationRequestResolver())
                .accessTokenResponseClient(this.accessTokenResponseClient())
            )
        );
  }
}
