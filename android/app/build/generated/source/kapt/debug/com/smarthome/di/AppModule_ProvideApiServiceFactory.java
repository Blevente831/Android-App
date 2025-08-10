package com.smarthome.di;

import com.smarthome.data.api.ApiService;
import com.squareup.moshi.Moshi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
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
public final class AppModule_ProvideApiServiceFactory implements Factory<ApiService> {
  private final Provider<OkHttpClient> aiOkHttpClientProvider;

  private final Provider<Moshi> moshiProvider;

  public AppModule_ProvideApiServiceFactory(Provider<OkHttpClient> aiOkHttpClientProvider,
      Provider<Moshi> moshiProvider) {
    this.aiOkHttpClientProvider = aiOkHttpClientProvider;
    this.moshiProvider = moshiProvider;
  }

  @Override
  public ApiService get() {
    return provideApiService(aiOkHttpClientProvider.get(), moshiProvider.get());
  }

  public static AppModule_ProvideApiServiceFactory create(
      Provider<OkHttpClient> aiOkHttpClientProvider, Provider<Moshi> moshiProvider) {
    return new AppModule_ProvideApiServiceFactory(aiOkHttpClientProvider, moshiProvider);
  }

  public static ApiService provideApiService(OkHttpClient aiOkHttpClient, Moshi moshi) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideApiService(aiOkHttpClient, moshi));
  }
}
