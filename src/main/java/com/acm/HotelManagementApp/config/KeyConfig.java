package com.acm.HotelManagementApp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Configuration
public class KeyConfig {

    @Bean
    public KeyPair rsaKeyPair() throws Exception {

        Resource privateResource = new ClassPathResource("/keys/private_key.pem");
        Resource publicResource = new ClassPathResource("/keys/public_key.pem");

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        if(privateResource.exists() && publicResource.exists()) {

            // Load a public key as a String and remove informative text
            String publicKeyString = publicResource.getContentAsString(Charset.defaultCharset())
                    .replace("-----BEGIN PUBLIC KEY-----", "")
                    .replace("-----END PUBLIC KEY-----", "")
                    .replaceAll(System.lineSeparator(), "");
            // Convert from String to byte[]
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes); // Specification for public keys
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec); // Generate public key

            // Load a private key as a String and remove informative text
            String privateKeyString = privateResource.getContentAsString(Charset.defaultCharset())
                    .replace("-----BEGIN PRIVATE KEY-----", "")
                    .replace("-----END PRIVATE KEY-----", "")
                    .replaceAll(System.lineSeparator(), "");
            // Convert from String to byte[]
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
            PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(privateKeyBytes); // Specification for private keys
            PrivateKey privateKey = keyFactory.generatePrivate(privateKeySpec); // Generate private key

            // Return a key pair
            return new KeyPair(publicKey, privateKey);
        } else {
            throw new IOException("keys not found in classpath");
        }
    }
}
