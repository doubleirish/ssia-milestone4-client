package com.manning.ssia.milestone4_client.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.client.OAuth2AuthorizeRequest;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.stereotype.Component;

@Component
public class ClientTokenService {


  @Value("${spring.security.oauth2.client.registration.app.client-id}")
  private String clientId;

  @Value("${client.registration.name}")
  private String clientRegName;

  private final OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager;

  public ClientTokenService(OAuth2AuthorizedClientManager oAuth2AuthorizedClientManager) {
    this.oAuth2AuthorizedClientManager = oAuth2AuthorizedClientManager;
  }

  public OAuth2AccessToken getAccessToken() {
    //build an authorization request
    OAuth2AuthorizeRequest oAuth2AuthorizeRequest =
            OAuth2AuthorizeRequest.withClientRegistrationId(clientRegName)
                .principal(clientId)
                .build();
    //submit your authorization request
    OAuth2AuthorizedClient oAuth2AuthorizedClient =
            this.oAuth2AuthorizedClientManager.authorize(oAuth2AuthorizeRequest);

    //extract access token from authorized client
   return oAuth2AuthorizedClient.getAccessToken();

  }
}
