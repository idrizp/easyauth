package dev.idriz.easyauth.provider;


import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Authentication Providers provide support for storing, loading, and handling requests at their respective endpoints.
 *
 * @param <T> A unique identification type.
 * @param <R> The model type.
 */
public interface AuthProvider<T, R> {

    /**
     * Obtains the authentication model from some sort of data store.
     *
     * @param id The ID of the authentication model we want to find.
     * @return The authentication model, may be null if it does not exist.
     */
    @Nullable
    R findById(@NotNull T id);

    /**
     * Saves an authentication model to some sort of data store.
     *
     * @param id    The ID of the authentication model.
     * @param model The model itself.
     */
    void save(@NotNull T id, @NotNull R model);
}
