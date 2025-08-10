package com.smarthome.viewmodel;

import com.smarthome.data.repository.DeviceRepository;
import com.smarthome.data.repository.UserRepository;
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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<DeviceRepository> deviceRepositoryProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  public DashboardViewModel_Factory(Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider) {
    this.deviceRepositoryProvider = deviceRepositoryProvider;
    this.userRepositoryProvider = userRepositoryProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(deviceRepositoryProvider.get(), userRepositoryProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<DeviceRepository> deviceRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider) {
    return new DashboardViewModel_Factory(deviceRepositoryProvider, userRepositoryProvider);
  }

  public static DashboardViewModel newInstance(DeviceRepository deviceRepository,
      UserRepository userRepository) {
    return new DashboardViewModel(deviceRepository, userRepository);
  }
}
