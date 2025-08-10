package com.smarthome.data.repository;

import com.smarthome.data.api.ApiService;
import com.smarthome.data.utils.DeviceStateManager;
import com.smarthome.data.utils.NetworkErrorHandler;
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
public final class DeviceRepositoryImpl_Factory implements Factory<DeviceRepositoryImpl> {
  private final Provider<ApiService> apiServiceProvider;

  private final Provider<DeviceStateManager> deviceStateManagerProvider;

  private final Provider<NetworkErrorHandler> networkErrorHandlerProvider;

  public DeviceRepositoryImpl_Factory(Provider<ApiService> apiServiceProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<NetworkErrorHandler> networkErrorHandlerProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.deviceStateManagerProvider = deviceStateManagerProvider;
    this.networkErrorHandlerProvider = networkErrorHandlerProvider;
  }

  @Override
  public DeviceRepositoryImpl get() {
    return newInstance(apiServiceProvider.get(), deviceStateManagerProvider.get(), networkErrorHandlerProvider.get());
  }

  public static DeviceRepositoryImpl_Factory create(Provider<ApiService> apiServiceProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<NetworkErrorHandler> networkErrorHandlerProvider) {
    return new DeviceRepositoryImpl_Factory(apiServiceProvider, deviceStateManagerProvider, networkErrorHandlerProvider);
  }

  public static DeviceRepositoryImpl newInstance(ApiService apiService,
      DeviceStateManager deviceStateManager, NetworkErrorHandler networkErrorHandler) {
    return new DeviceRepositoryImpl(apiService, deviceStateManager, networkErrorHandler);
  }
}
