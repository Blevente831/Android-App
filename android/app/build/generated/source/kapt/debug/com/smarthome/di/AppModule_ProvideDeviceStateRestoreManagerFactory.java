package com.smarthome.di;

import android.content.Context;
import com.smarthome.data.utils.DeviceStateManager;
import com.smarthome.data.utils.DeviceStateRestoreManager;
import com.smarthome.data.utils.SharedToggleStateManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppModule_ProvideDeviceStateRestoreManagerFactory implements Factory<DeviceStateRestoreManager> {
  private final Provider<Context> contextProvider;

  private final Provider<DeviceStateManager> deviceStateManagerProvider;

  private final Provider<SharedToggleStateManager> sharedToggleStateManagerProvider;

  public AppModule_ProvideDeviceStateRestoreManagerFactory(Provider<Context> contextProvider,
      Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    this.contextProvider = contextProvider;
    this.deviceStateManagerProvider = deviceStateManagerProvider;
    this.sharedToggleStateManagerProvider = sharedToggleStateManagerProvider;
  }

  @Override
  public DeviceStateRestoreManager get() {
    return provideDeviceStateRestoreManager(contextProvider.get(), deviceStateManagerProvider.get(), sharedToggleStateManagerProvider.get());
  }

  public static AppModule_ProvideDeviceStateRestoreManagerFactory create(
      Provider<Context> contextProvider, Provider<DeviceStateManager> deviceStateManagerProvider,
      Provider<SharedToggleStateManager> sharedToggleStateManagerProvider) {
    return new AppModule_ProvideDeviceStateRestoreManagerFactory(contextProvider, deviceStateManagerProvider, sharedToggleStateManagerProvider);
  }

  public static DeviceStateRestoreManager provideDeviceStateRestoreManager(Context context,
      DeviceStateManager deviceStateManager, SharedToggleStateManager sharedToggleStateManager) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDeviceStateRestoreManager(context, deviceStateManager, sharedToggleStateManager));
  }
}
