package com.smarthome.viewmodel;

import com.smarthome.data.repository.DeviceRepository;
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
public final class AddDeviceViewModel_Factory implements Factory<AddDeviceViewModel> {
  private final Provider<DeviceRepository> deviceRepositoryProvider;

  public AddDeviceViewModel_Factory(Provider<DeviceRepository> deviceRepositoryProvider) {
    this.deviceRepositoryProvider = deviceRepositoryProvider;
  }

  @Override
  public AddDeviceViewModel get() {
    return newInstance(deviceRepositoryProvider.get());
  }

  public static AddDeviceViewModel_Factory create(
      Provider<DeviceRepository> deviceRepositoryProvider) {
    return new AddDeviceViewModel_Factory(deviceRepositoryProvider);
  }

  public static AddDeviceViewModel newInstance(DeviceRepository deviceRepository) {
    return new AddDeviceViewModel(deviceRepository);
  }
}
