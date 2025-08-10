package com.smarthome.viewmodel;

import com.smarthome.data.repository.DeviceRepository;
import com.smarthome.data.utils.DeviceStateRestoreManager;
import com.smarthome.data.utils.SharedToggleStateManager;
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
public final class DevicesViewModel_Factory implements Factory<DevicesViewModel> {
  private final Provider<DeviceRepository> deviceRepositoryProvider;

  private final Provider<SharedToggleStateManager> sharedToggleStateManagerProvider;

  private final Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider;

  public DevicesViewModel_Factory(Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider,
      Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider) {
    this.deviceRepositoryProvider = deviceRepositoryProvider;
    this.sharedToggleStateManagerProvider = sharedToggleStateManagerProvider;
    this.deviceStateRestoreManagerProvider = deviceStateRestoreManagerProvider;
  }

  @Override
  public DevicesViewModel get() {
    return newInstance(deviceRepositoryProvider.get(), sharedToggleStateManagerProvider.get(), deviceStateRestoreManagerProvider.get());
  }

  public static DevicesViewModel_Factory create(Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider,
      Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider) {
    return new DevicesViewModel_Factory(deviceRepositoryProvider, sharedToggleStateManagerProvider, deviceStateRestoreManagerProvider);
  }

  public static DevicesViewModel newInstance(DeviceRepository deviceRepository,
      SharedToggleStateManager sharedToggleStateManager,
      DeviceStateRestoreManager deviceStateRestoreManager) {
    return new DevicesViewModel(deviceRepository, sharedToggleStateManager, deviceStateRestoreManager);
  }
}
