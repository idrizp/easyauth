# EasyAuth

This is a project that has come from years of toiling away with Spring Security and how it makes.. well.. not much sense.

This isn't built to support older projects trying to migrate - this is a radically new approach to handling authentication.


Here's an example:

```java

import java.util.UUID;

@AuthModelInfo(
        providers = {
                GoogleProvider.class, 
                FacebookProvider.class,
        },
        requireEmailVerification = true
)
public class User implements AuthModel {
    
    private UUID id;
    
    private String username;
    private String email;
    
    @ExtractFromProvider(
            provider = LocalProvider.class, 
            id = "password"
    )
    private String password;
    
    @ExtractFromProvider(
            provider = GoogleProvider.class, 
            id = "googleId"
    )
    private String googleId;
    
    @ExtractFromProvider(
            provider = FacebookProvider.class, 
            id = "facebookId"
    )
    private String facebookId;
    
    @Override
    public Set<String> getPermissions() {
        return Set.of("private_endpoint");
    }
    
}
```

In a separate file, you may define the configuration for these providers. 
They should be automatically set up by the environment variables, but in any case, you may change these properties.

```java
@Bean
public AuthProviderLoader providerLoader() {
    return AuthProviderLoader.create(
            new GoogleProvider(...),
            new FacebookProvider(...),
            new LocalProvider(...)
    )
    .baseEndpoint("/api/auth")
    .errorRedirectURL("https://website.com/error/auth"); // The error will be passed as query parameters.
}
```

Then, you may have per-endpoint annotations to configure as you wish.

```java

@GetMapping("/private")
@AuthenticatedOnly(
        // Optional:
        requiredProviders = {
                GoogleProvider.class,
        },
        // Optional:
        requiredPermissions = { "private_endpoint" }
)
public String privateEndpoint() {
    return "Success!";
}

```