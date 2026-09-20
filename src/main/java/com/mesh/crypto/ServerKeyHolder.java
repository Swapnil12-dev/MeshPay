package com.mesh.crypto;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

@Component
public class ServerKeyHolder {

    private static final String PRIVATE_KEY_RESOURCE =
            "keys/server_private.key";

    private static final String PUBLIC_KEY_RESOURCE =
            "keys/server_public.key";

    private static KeyPair keyPair;

    public ServerKeyHolder() {
        try {
            if (keyPair == null) {
                keyPair = loadKeyPair();
            }
        } catch (Exception e) {
            throw new RuntimeException(
                    "Failed to load MeshPay RSA key pair", e
            );
        }
    }

    private KeyPair loadKeyPair() throws Exception {

        String privateKeyBase64 = readResource(PRIVATE_KEY_RESOURCE);
        String publicKeyBase64 = readResource(PUBLIC_KEY_RESOURCE);

        byte[] privateKeyBytes =
                Base64.getDecoder().decode(privateKeyBase64);

        byte[] publicKeyBytes =
                Base64.getDecoder().decode(publicKeyBase64);

        KeyFactory keyFactory = KeyFactory.getInstance("RSA");

        PrivateKey privateKey = keyFactory.generatePrivate(
                new PKCS8EncodedKeySpec(privateKeyBytes)
        );

        PublicKey publicKey = keyFactory.generatePublic(
                new X509EncodedKeySpec(publicKeyBytes)
        );

        return new KeyPair(publicKey, privateKey);
    }

    private String readResource(String resourceName) throws Exception {

        try (InputStream inputStream =
                     getClass().getClassLoader()
                             .getResourceAsStream(resourceName)) {

            if (inputStream == null) {
                throw new IllegalStateException(
                        "Missing RSA key resource: " + resourceName
                );
            }

            return new String(
                    inputStream.readAllBytes(),
                    StandardCharsets.UTF_8
            ).trim();
        }
    }

    public static PublicKey getPublicKey() {
        return keyPair.getPublic();
    }

    public PrivateKey getPrivateKey() {
        return keyPair.getPrivate();
    }
}
