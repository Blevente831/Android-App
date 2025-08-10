package com.smarthome.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c7\u0002\u0018\u00002\u00020\u0001:\u0001%B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J(\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u0018\u001a\u00020\u00132\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\"\u0010\u001b\u001a\u00020\u001c2\b\b\u0001\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u001d\u001a\u00020\nH\u0007J\u0012\u0010\u001e\u001a\u00020\u00152\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\u0012\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\u0012\u0010!\u001a\u00020\u000e2\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\u0012\u0010\"\u001a\u00020\u00172\b\b\u0001\u0010\u0019\u001a\u00020\u001aH\u0007J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/smarthome/di/AppModule;", "", "()V", "API_BASE_URL", "", "provideApiService", "Lcom/smarthome/data/api/ApiService;", "aiOkHttpClient", "Lokhttp3/OkHttpClient;", "moshi", "Lcom/squareup/moshi/Moshi;", "provideAuthenticationInterceptor", "Lokhttp3/Interceptor;", "sharedPreferences", "Landroid/content/SharedPreferences;", "provideDeviceRepository", "Lcom/smarthome/data/repository/DeviceRepository;", "apiService", "deviceStateManager", "Lcom/smarthome/data/utils/DeviceStateManager;", "networkErrorHandler", "Lcom/smarthome/data/utils/NetworkErrorHandler;", "sharedToggleStateManager", "Lcom/smarthome/data/utils/SharedToggleStateManager;", "provideDeviceStateManager", "context", "Landroid/content/Context;", "provideDeviceStateRestoreManager", "Lcom/smarthome/data/utils/DeviceStateRestoreManager;", "provideMoshi", "provideNetworkErrorHandler", "providePreferencesManager", "Lcom/smarthome/ui/theme/PreferencesManager;", "provideSharedPreferences", "provideSharedToggleStateManager", "provideUserRepository", "Lcom/smarthome/data/repository/UserRepository;", "AiClient", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class AppModule {
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String API_BASE_URL = "https://smart-home-backend-467137186193.us-central1.run.app/";
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.di.AppModule INSTANCE = null;
    
    private AppModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final android.content.SharedPreferences provideSharedPreferences(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.squareup.moshi.Moshi provideMoshi() {
        return null;
    }
    
    /**
     * Creates an authentication interceptor
     * This provides only the authentication logic, separate from the network module
     */
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.Interceptor provideAuthenticationInterceptor(@org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences) {
        return null;
    }
    
    /**
     * Provides the Retrofit service with an OkHttpClient that has extended timeouts
     * for AI operations which take longer to process
     */
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.api.ApiService provideApiService(@com.smarthome.di.AppModule.AiClient
    @org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient aiOkHttpClient, @org.jetbrains.annotations.NotNull
    com.squareup.moshi.Moshi moshi) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.DeviceStateManager provideDeviceStateManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.SharedToggleStateManager provideSharedToggleStateManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.DeviceStateRestoreManager provideDeviceStateRestoreManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateManager deviceStateManager, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.repository.DeviceRepository provideDeviceRepository(@org.jetbrains.annotations.NotNull
    com.smarthome.data.api.ApiService apiService, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.DeviceStateManager deviceStateManager, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.NetworkErrorHandler networkErrorHandler, @org.jetbrains.annotations.NotNull
    com.smarthome.data.utils.SharedToggleStateManager sharedToggleStateManager) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.utils.NetworkErrorHandler provideNetworkErrorHandler(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.repository.UserRepository provideUserRepository(@org.jetbrains.annotations.NotNull
    com.smarthome.data.api.ApiService apiService, @org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.ui.theme.PreferencesManager providePreferencesManager(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    /**
     * Special qualifier for the AI-specific OkHttpClient with longer timeouts
     */
    @javax.inject.Qualifier
    @kotlin.annotation.Retention(value = kotlin.annotation.AnnotationRetention.BINARY)
    @java.lang.annotation.Retention(value = java.lang.annotation.RetentionPolicy.CLASS)
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/smarthome/di/AppModule$AiClient;", "", "app_debug"})
    public static abstract @interface AiClient {
    }
}