package com.smarthome.di;

import androidx.lifecycle.SavedStateHandle;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class SavedStateHandleModule_ProvideDeviceIdFactory implements Factory<String> {
  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public SavedStateHandleModule_ProvideDeviceIdFactory(
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public String get() {
    return provideDeviceId(savedStateHandleProvider.get());
  }

  public static SavedStateHandleModule_ProvideDeviceIdFactory create(
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new SavedStateHandleModule_ProvideDeviceIdFactory(savedStateHandleProvider);
  }

  public static String provideDeviceId(SavedStateHandle savedStateHandle) {
    return Preconditions.checkNotNullFromProvides(SavedStateHandleModule.INSTANCE.provideDeviceId(savedStateHandle));
  }
}
