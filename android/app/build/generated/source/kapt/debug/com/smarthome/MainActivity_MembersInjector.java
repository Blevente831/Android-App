package com.smarthome;

import com.smarthome.data.utils.DeviceStateManager;
import com.smarthome.data.utils.DeviceStateRestoreManager;
import com.smarthome.data.utils.SharedToggleStateManager;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<DeviceStateManager> deviceStateManagerProvider;

  private final Provider<SharedToggleStateManager> sharedToggleStateManagerProvider;

  private final Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider;

  public MainActivity_MembersInjector(Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider,
      Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider) {
    this.deviceStateManagerProvider = deviceStateManagerProvider;
    this.sharedToggleStateManagerProvider = sharedToggleStateManagerProvider;
    this.deviceStateRestoreManagerProvider = deviceStateRestoreManagerProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider,
      Provider<DeviceStateRestoreManager> deviceStateRestoreManagerProvider) {
    return new MainActivity_MembersInjector(deviceStateManagerProvider, sharedToggleStateManagerProvider, deviceStateRestoreManagerProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectDeviceStateManager(instance, deviceStateManagerProvider.get());
    injectSharedToggleStateManager(instance, sharedToggleStateManagerProvider.get());
    injectDeviceStateRestoreManager(instance, deviceStateRestoreManagerProvider.get());
  }

  @InjectedFieldSignature("com.smarthome.MainActivity.deviceStateManager")
  public static void injectDeviceStateManager(MainActivity instance,
      DeviceStateManager deviceStateManager) {
    instance.deviceStateManager = deviceStateManager;
  }

  @InjectedFieldSignature("com.smarthome.MainActivity.sharedToggleStateManager")
  public static void injectSharedToggleStateManager(MainActivity instance,
      SharedToggleStateManager sharedToggleStateManager) {
    instance.sharedToggleStateManager = sharedToggleStateManager;
  }

  @InjectedFieldSignature("com.smarthome.MainActivity.deviceStateRestoreManager")
  public static void injectDeviceStateRestoreManager(MainActivity instance,
      DeviceStateRestoreManager deviceStateRestoreManager) {
    instance.deviceStateRestoreManager = deviceStateRestoreManager;
  }
}
