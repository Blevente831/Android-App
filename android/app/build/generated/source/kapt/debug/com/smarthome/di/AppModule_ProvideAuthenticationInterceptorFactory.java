package com.smarthome.di;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.Interceptor;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
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
public final class AppModule_ProvideAuthenticationInterceptorFactory implements Factory<Interceptor> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public AppModule_ProvideAuthenticationInterceptorFactory(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public Interceptor get() {
    return provideAuthenticationInterceptor(sharedPreferencesProvider.get());
  }

  public static AppModule_ProvideAuthenticationInterceptorFactory create(
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new AppModule_ProvideAuthenticationInterceptorFactory(sharedPreferencesProvider);
  }

  public static Interceptor provideAuthenticationInterceptor(SharedPreferences sharedPreferences) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAuthenticationInterceptor(sharedPreferences));
  }
}
