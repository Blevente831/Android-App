package com.smarthome.data.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DeviceStateRestoreManager_Factory implements Factory<DeviceStateRestoreManager> {
  private final Provider<Context> contextProvider;

  private final Provider<DeviceStateManager> deviceStateManagerProvider;

  private final Provider<SharedToggleStateManager> sharedToggleStateManagerProvider;

  public DeviceStateRestoreManager_Factory(Provider<Context> contextProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    this.contextProvider = contextProvider;
    this.deviceStateManagerProvider = deviceStateManagerProvider;
    this.sharedToggleStateManagerProvider = sharedToggleStateManagerProvider;
  }

  @Override
  public DeviceStateRestoreManager get() {
    return newInstance(contextProvider.get(), deviceStateManagerProvider.get(), sharedToggleStateManagerProvider.get());
  }

  public static DeviceStateRestoreManager_Factory create(Provider<Context> contextProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    return new DeviceStateRestoreManager_Factory(contextProvider, deviceStateManagerProvider, sharedToggleStateManagerProvider);
  }

  public static DeviceStateRestoreManager newInstance(Context context,
      DeviceStateManager deviceStateManager, SharedToggleStateManager sharedToggleStateManager) {
    return new DeviceStateRestoreManager(context, deviceStateManager, sharedToggleStateManager);
  }
}
