package com.smarthome.data.repository;

import android.content.SharedPreferences;
import com.smarthome.data.api.ApiService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class UserRepositoryImpl_Factory implements Factory<UserRepositoryImpl> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public UserRepositoryImpl_Factory(Provider<ApiService> apiServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public UserRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), sharedPreferencesProvider.get());
  }

  public static UserRepositoryImpl_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new UserRepositoryImpl_Factory(apiServiceProvider, sharedPreferencesProvider);
  }

  public static UserRepositoryImpl newInstance(ApiService apiService,
      SharedPreferences sharedPreferences) {
    return new UserRepositoryImpl(apiService, sharedPreferences);
  }
}
