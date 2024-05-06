package dev.idriz.easyauth.provider;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class AuthProviderLoader {

    private final Map<Class<?>, AuthProvider<?, ?>> providers = new ConcurrentHashMap<>();
    private String baseEndpoint = "/api/auth";
    private String errorRedirectUrl = "/api/auth/error";

    private AuthProviderLoader(AuthProvider<?, ?>[] providers) {
        for (AuthProvider<?, ?> provider : providers) {
            this.providers.put(provider.getClass(), provider);
        }
    }

    /**
     * Creates a new instance of the AuthProviderLoader.
     *
     * @param providers The authentication providers.
     * @return The newly-created AuthProviderLoader
     */
    public static AuthProviderLoader create(AuthProvider<?, ?>... providers) {
        return new AuthProviderLoader(providers);
    }

    /**
     * Returns a provider based on the class.
     * @param clazz The class.
     * @return The provider.
     */
    public AuthProvider<?, ?> getProvider(Class<?> clazz) {
        return providers.get(clazz);
    }

    /**
     * Sets the base endpoint.
     *
     * @param baseEndpoint The base endpoint.
     * @return The current AuthProviderLoader instance.
     */
    public AuthProviderLoader baseEndpoint(String baseEndpoint) {
        this.baseEndpoint = baseEndpoint;
        return this;
    }

    /**
     * Sets the error redirect URL.
     *
     * @param errorRedirectUrl The error redirect URL.
     * @return The current AuthProviderLoader instance.
     */
    public AuthProviderLoader errorRedirectUrl(String errorRedirectUrl) {
        this.errorRedirectUrl = errorRedirectUrl;
        return this;
    }

    /**
     * The base endpoint.
     *
     * @return The base endpoint.
     */
    public String getBaseEndpoint() {
        return baseEndpoint;
    }

    /**
     * The error redirect url.
     *
     * @return The error redirect url.
     */
    public String getErrorRedirectUrl() {
        return errorRedirectUrl;
    }
}
