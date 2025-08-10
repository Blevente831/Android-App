package com.smarthome.di;

import com.smarthome.data.api.ApiService;
import com.smarthome.data.repository.DeviceRepository;
import com.smarthome.data.utils.DeviceStateManager;
import com.smarthome.data.utils.NetworkErrorHandler;
import com.smarthome.data.utils.SharedToggleStateManager;
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
public final class AppModule_ProvideDeviceRepositoryFactory implements Factory<DeviceRepository> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<DeviceStateManager> deviceStateManagerProvider;

  private final Provider<NetworkErrorHandler> networkErrorHandlerProvider;

  private final Provider<SharedToggleStateManager> sharedToggleStateManagerProvider;

  public AppModule_ProvideDeviceRepositoryFactory(Provider<ApiService> apiServiceProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<NetworkErrorHandler> networkErrorHandlerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.deviceStateManagerProvider = deviceStateManagerProvider;
    this.networkErrorHandlerProvider = networkErrorHandlerProvider;
    this.sharedToggleStateManagerProvider = sharedToggleStateManagerProvider;
  }

  @Override
  public DeviceRepository get() {
    return provideDeviceRepository(apiServiceProvider.get(), deviceStateManagerProvider.get(), networkErrorHandlerProvider.get(), sharedToggleStateManagerProvider.get());
  }

  public static AppModule_ProvideDeviceRepositoryFactory create(
      Provider<ApiService> apiServiceProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<NetworkErrorHandler> networkErrorHandlerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    return new AppModule_ProvideDeviceRepositoryFactory(apiServiceProvider, deviceStateManagerProvider, networkErrorHandlerProvider, sharedToggleStateManagerProvider);
  }

  public static DeviceRepository provideDeviceRepository(ApiService apiService,
      DeviceStateManager deviceStateManager, NetworkErrorHandler networkErrorHandler,
      SharedToggleStateManager sharedToggleStateManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDeviceRepository(apiService, deviceStateManager, networkErrorHandler, sharedToggleStateManager));
  }
}
