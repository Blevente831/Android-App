package com.smarthome.ui.theme;

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
public final class ThemeViewModel_Factory implements Factory<ThemeViewModel> {
  private final Provider<PreferencesManager> preferencesManagerProvider;

  private final Provider<ThemeEventBus> themeEventBusProvider;

  public ThemeViewModel_Factory(Provider<PreferencesManager> preferencesManagerProvider,
      Provider<ThemeEventBus> themeEventBusProvider) {
    this.preferencesManagerProvider = preferencesManagerProvider;
    this.themeEventBusProvider = themeEventBusProvider;
  }

  @Override
  public ThemeViewModel get() {
    return newInstance(preferencesManagerProvider.get(), themeEventBusProvider.get());
  }

  public static ThemeViewModel_Factory create(
      Provider<PreferencesManager> preferencesManagerProvider,
      Provider<ThemeEventBus> themeEventBusProvider) {
    return new ThemeViewModel_Factory(preferencesManagerProvider, themeEventBusProvider);
  }

  public static ThemeViewModel newInstance(PreferencesManager preferencesManager,
      ThemeEventBus themeEventBus) {
    return new ThemeViewModel(preferencesManager, themeEventBus);
  }
}
