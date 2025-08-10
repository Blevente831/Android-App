package com.smarthome.di;

import android.content.SharedPreferences;
import com.smarthome.data.api.ApiService;
import com.smarthome.data.repository.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class AppModule_ProvideUserRepositoryFactory implements Factory<UserRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public AppModule_ProvideUserRepositoryFactory(Provider<ApiService> apiServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public UserRepository get() {
    return provideUserRepository(apiServiceProvider.get(), sharedPreferencesProvider.get());
  }

  public static AppModule_ProvideUserRepositoryFactory create(
      Provider<ApiService> apiServiceProvider,
      Provider<SharedPreferences> sharedPreferencesProvider) {
    return new AppModule_ProvideUserRepositoryFactory(apiServiceProvider, sharedPreferencesProvider);
  }

  public static UserRepository provideUserRepository(ApiService apiService,
      SharedPreferences sharedPreferences) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUserRepository(apiService, sharedPreferences));
  }
}
