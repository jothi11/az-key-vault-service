package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

@Configuration
public class SecretClientConfig {
	
	@Bean
	public SecretClient getSecretClient() {
		return new SecretClientBuilder().buildClient();
	}

}
