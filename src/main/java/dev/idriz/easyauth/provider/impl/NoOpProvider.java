package dev.idriz.easyauth.provider.impl;

import dev.idriz.easyauth.provider.AuthProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class NoOpProvider implements AuthProvider<Object, Object> {

    @Nullable
    @Override
    public Object findById(@NotNull Object id) {
        throw new UnsupportedOperationException("No-Op provider does not support this function.");
    }

    @Override
    public void save(@NotNull Object id, @NotNull Object model) {
        throw new UnsupportedOperationException("No-op provider does not support this function.");
    }
}
