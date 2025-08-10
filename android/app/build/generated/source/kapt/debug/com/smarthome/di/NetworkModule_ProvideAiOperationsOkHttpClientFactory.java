package com.smarthome.di;

import com.smarthome.data.network.SmartNetworkInterceptor;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.smarthome.di.AppModule.AiClient")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NetworkModule_ProvideAiOperationsOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<SmartNetworkInterceptor> smartNetworkInterceptorProvider;

  private final Provider<Interceptor> authInterceptorProvider;

  public NetworkModule_ProvideAiOperationsOkHttpClientFactory(
      Provider<SmartNetworkInterceptor> smartNetworkInterceptorProvider,
      Provider<Interceptor> authInterceptorProvider) {
    this.smartNetworkInterceptorProvider = smartNetworkInterceptorProvider;
    this.authInterceptorProvider = authInterceptorProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideAiOperationsOkHttpClient(smartNetworkInterceptorProvider.get(), authInterceptorProvider.get());
  }

  public static NetworkModule_ProvideAiOperationsOkHttpClientFactory create(
      Provider<SmartNetworkInterceptor> smartNetworkInterceptorProvider,
      Provider<Interceptor> authInterceptorProvider) {
    return new NetworkModule_ProvideAiOperationsOkHttpClientFactory(smartNetworkInterceptorProvider, authInterceptorProvider);
  }

  public static OkHttpClient provideAiOperationsOkHttpClient(
      SmartNetworkInterceptor smartNetworkInterceptor, Interceptor authInterceptor) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideAiOperationsOkHttpClient(smartNetworkInterceptor, authInterceptor));
  }
}
