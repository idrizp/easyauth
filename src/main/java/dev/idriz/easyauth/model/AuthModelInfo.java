package dev.idriz.easyauth.model;

import dev.idriz.easyauth.provider.AuthProvider;
import org.jetbrains.annotations.NotNull;

public @interface AuthModelInfo {

    /**
     * The providers the authentication model supports.
     * @return The providers the authentication model supports.
     */
    @NotNull Class<? extends AuthProvider>[] providers();

    /**
     * Whether the model requires email verification to be authorized.
     * @return Whether the model requires email verification to be authorized.
     */
    boolean requiresEmailVerification() default true;
}
