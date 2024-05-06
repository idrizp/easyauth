package dev.idriz.easyauth.model;

import org.jetbrains.annotations.NotNull;

import java.util.Set;

public interface AuthModel {

    /**
     * Returns the set of permissions for the particular model.
     *
     * @return The set of permissions for the particular model.
     */
    @NotNull
    Set<String> getPermissions();

}
