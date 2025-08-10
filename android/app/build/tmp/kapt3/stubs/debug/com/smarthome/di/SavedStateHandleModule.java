package com.smarthome.di;

/**
 * Provides ViewModels for dependency injection
 * This approach helps when there are complex ViewModel initializations
 * or when you need to provide mock implementations for testing
 */
@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\u0007"}, d2 = {"Lcom/smarthome/di/SavedStateHandleModule;", "", "()V", "provideDeviceId", "", "savedStateHandle", "Landroidx/lifecycle/SavedStateHandle;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.android.components.ViewModelComponent.class})
public final class SavedStateHandleModule {
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.di.SavedStateHandleModule INSTANCE = null;
    
    private SavedStateHandleModule() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final java.lang.String provideDeviceId(@org.jetbrains.annotations.NotNull
    androidx.lifecycle.SavedStateHandle savedStateHandle) {
        return null;
    }
}