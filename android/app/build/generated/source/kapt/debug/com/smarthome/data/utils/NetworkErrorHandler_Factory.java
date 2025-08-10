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
public final class NetworkErrorHandler_Factory implements Factory<NetworkErrorHandler> {
  private final Provider<Context> contextProvider;

  public NetworkErrorHandler_Factory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkErrorHandler get() {
    return newInstance(contextProvider.get());
  }

  public static NetworkErrorHandler_Factory create(Provider<Context> contextProvider) {
    return new NetworkErrorHandler_Factory(contextProvider);
  }

  public static NetworkErrorHandler newInstance(Context context) {
    return new NetworkErrorHandler(context);
  }
}
