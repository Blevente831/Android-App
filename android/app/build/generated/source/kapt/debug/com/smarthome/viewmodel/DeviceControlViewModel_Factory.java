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
public final class DeviceControlViewModel_Factory implements Factory<DeviceControlViewModel> {
  private final Provider<String> deviceIdProvider;

  private final Provider<DeviceRepository> deviceRepositoryProvider;

  private final Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider;

  private final Provider<SharedToggleStateManager> sharedToggleStateManagerProvider;

  public DeviceControlViewModel_Factory(Provider<String> deviceIdProvider,
      Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    this.deviceIdProvider = deviceIdProvider;
    this.deviceRepositoryProvider = deviceRepositoryProvider;
    this.deviceStateRestoreManagerProvider = deviceStateRestoreManagerProvider;
    this.sharedToggleStateManagerProvider = sharedToggleStateManagerProvider;
  }

  @Override
  public DeviceControlViewModel get() {
    return newInstance(deviceIdProvider.get(), deviceRepositoryProvider.get(), deviceStateRestoreManagerProvider.get(), sharedToggleStateManagerProvider.get());
  }

  public static DeviceControlViewModel_Factory create(Provider<String> deviceIdProvider,
      Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    return new DeviceControlViewModel_Factory(deviceIdProvider, deviceRepositoryProvider, deviceStateRestoreManagerProvider, sharedToggleStateManagerProvider);
  }

  public static DeviceControlViewModel newInstance(String deviceId,
      DeviceRepository deviceRepository, DeviceStateRestoreManager deviceStateRestoreManager,
      SharedToggleStateManager sharedToggleStateManager) {
    return new DeviceControlViewModel(deviceId, deviceRepository, deviceStateRestoreManager, sharedToggleStateManager);
  }
}
