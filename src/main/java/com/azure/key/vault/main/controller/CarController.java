package com.azure.key.vault.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.key.vault.main.entity.Car;
import com.azure.key.vault.main.repository.CarRepository;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;
import com.azure.security.keyvault.secrets.models.KeyVaultSecret;

@RestController
@RequestMapping("api/v1/car")
public class CarController {

    @Autowired
    private CarRepository carRepository;

   
    @GetMapping(value="/all")
    public  ResponseEntity<List<Car>> getBooks() {
        List<Car> bookList = carRepository.findAll();
        return new ResponseEntity<List<Car>>(bookList, HttpStatus.OK);
    }
    
    
    @RequestMapping("/")
    public String getKeyvaultValue()
    {
       return getStoredValue("keyName");
    }
  
    private String getStoredValue(String keyName){
    //   String keyVaultName = System.getenv("KEY_VAULT_NAME");
       String keyVaultUri = "https://db-cred.vault.azure.net";
       SecretClient secretClient = new SecretClientBuilder()
       .vaultUrl(keyVaultUri)
       .credential(new DefaultAzureCredentialBuilder().build())
       .buildClient();
       KeyVaultSecret storedSecret = secretClient.getSecret("mysqldbusername");
       return storedSecret.getValue();
    }
}
