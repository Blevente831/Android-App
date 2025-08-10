package com.smarthome.di;

@dagger.Module
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0007J\u0012\u0010\r\u001a\u00020\u00062\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/smarthome/di/NetworkModule;", "", "()V", "provideAiOperationsOkHttpClient", "Lokhttp3/OkHttpClient;", "smartNetworkInterceptor", "Lcom/smarthome/data/network/SmartNetworkInterceptor;", "authInterceptor", "Lokhttp3/Interceptor;", "provideOkHttpClient", "provideRetrofit", "Lretrofit2/Retrofit;", "okHttpClient", "provideSmartNetworkInterceptor", "context", "Landroid/content/Context;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class NetworkModule {
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.di.NetworkModule INSTANCE = null;
    
    private NetworkModule() {
        super();
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final com.smarthome.data.network.SmartNetworkInterceptor provideSmartNetworkInterceptor(@dagger.hilt.android.qualifiers.ApplicationContext
    @org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull
    com.smarthome.data.network.SmartNetworkInterceptor smartNetworkInterceptor, @org.jetbrains.annotations.NotNull
    okhttp3.Interceptor authInterceptor) {
        return null;
    }
    
    /**
     * Provides an OkHttpClient specifically configured for AI operations with longer timeouts
     */
    @dagger.Provides
    @javax.inject.Singleton
    @com.smarthome.di.AppModule.AiClient
    @org.jetbrains.annotations.NotNull
    public final okhttp3.OkHttpClient provideAiOperationsOkHttpClient(@org.jetbrains.annotations.NotNull
    com.smarthome.data.network.SmartNetworkInterceptor smartNetworkInterceptor, @org.jetbrains.annotations.NotNull
    okhttp3.Interceptor authInterceptor) {
        return null;
    }
    
    @dagger.Provides
    @javax.inject.Singleton
    @org.jetbrains.annotations.NotNull
    public final retrofit2.Retrofit provideRetrofit(@org.jetbrains.annotations.NotNull
    okhttp3.OkHttpClient okHttpClient) {
        return null;
    }
}