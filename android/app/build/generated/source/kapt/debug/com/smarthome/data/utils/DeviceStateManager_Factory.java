package com.smarthome.data.utils;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class DeviceStateManager_Factory implements Factory<DeviceStateManager> {
  private final Provider<Context> contextProvider;

  public DeviceStateManager_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DeviceStateManager get() {
    return newInstance(contextProvider.get());
  }

  public static DeviceStateManager_Factory create(Provider<Context> contextProvider) {
    return new DeviceStateManager_Factory(contextProvider);
  }

  public static DeviceStateManager newInstance(Context context) {
    return new DeviceStateManager(context);
  }
}
