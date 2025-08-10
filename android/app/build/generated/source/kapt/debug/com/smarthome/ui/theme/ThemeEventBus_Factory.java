package com.smarthome.ui.theme;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class ThemeEventBus_Factory implements Factory<ThemeEventBus> {
  @Override
  public ThemeEventBus get() {
    return newInstance();
  }

  public static ThemeEventBus_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ThemeEventBus newInstance() {
    return new ThemeEventBus();
  }

  private static final class InstanceHolder {
    private static final ThemeEventBus_Factory INSTANCE = new ThemeEventBus_Factory();
  }
}
