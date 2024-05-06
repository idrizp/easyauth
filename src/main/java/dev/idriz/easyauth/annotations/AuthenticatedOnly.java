package dev.idriz.easyauth.annotations;

import dev.idriz.easyauth.provider.AuthProvider;
import dev.idriz.easyauth.provider.impl.NoOpProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AuthenticatedOnly {
    /**
     * The provider.
     * @return The provider.
     */
    Class<? extends AuthProvider<?, ?>> requiredProvider() default NoOpProvider.class;

    /**
     * The required permissions.
     * @return The required permissions.
     */
    String[] requiredPermissions() default {};
}
