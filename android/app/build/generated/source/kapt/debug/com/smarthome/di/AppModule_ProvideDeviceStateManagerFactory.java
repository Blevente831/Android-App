package com.smarthome.di;

import android.content.Context;
import com.smarthome.data.utils.DeviceStateManager;
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
public final class AppModule_ProvideDeviceStateManagerFactory implements Factory<DeviceStateManager> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideDeviceStateManagerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public DeviceStateManager get() {
    return provideDeviceStateManager(contextProvider.get());
  }

  public static AppModule_ProvideDeviceStateManagerFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideDeviceStateManagerFactory(contextProvider);
  }

  public static DeviceStateManager provideDeviceStateManager(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideDeviceStateManager(context));
  }
}
