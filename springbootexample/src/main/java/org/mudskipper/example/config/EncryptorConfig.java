package org.mudskipper.example.config;

import org.jasypt.encryption.StringEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EncryptorConfig {

	@Bean("jasyptStringEncryptor")
    public StringEncryptor stringEncryptor() {
        StringEncryptor encryptor = new AesEncryptor();
        return encryptor;
    }
}
