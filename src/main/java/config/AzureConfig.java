package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureConfig {

  @Value("${azure.keyvault.client-id}")
  private String clientId;

  @Value("${azure.keyvault.client-key}")
  private String clientSecret;

 // @Bean
/*  public KeyVaultClient keyVaultClient() {
    ServiceClientCredentials credentials = new AzureKeyVaultCredential(clientId, clientSecret);
    return new KeyVaultClient(credentials);
  }*/
}