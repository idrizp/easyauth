package dev.idriz.easyauth.provider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Is used to extract parameters from a certain provider, if applicable.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ExtractFromProvider {

    /**
     * The class of the provider we want to extract the field from.
     * @return The class of the provider we want to extract the field from.
     */
    Class<? extends AuthProvider> provider();

    /**
     * The ID of the field that we want to obtain from the provider.
     * @return The ID of the field that we want to obtain from the provider.
     */
    String id();
}
