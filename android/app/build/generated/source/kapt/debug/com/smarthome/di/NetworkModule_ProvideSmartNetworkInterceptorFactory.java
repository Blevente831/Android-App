package com.smarthome.di;

import android.content.Context;
import com.smarthome.data.network.SmartNetworkInterceptor;
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
public final class NetworkModule_ProvideSmartNetworkInterceptorFactory implements Factory<SmartNetworkInterceptor> {
  private final Provider<Context> contextProvider;

  public NetworkModule_ProvideSmartNetworkInterceptorFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public SmartNetworkInterceptor get() {
    return provideSmartNetworkInterceptor(contextProvider.get());
  }

  public static NetworkModule_ProvideSmartNetworkInterceptorFactory create(
      Provider<Context> contextProvider) {
    return new NetworkModule_ProvideSmartNetworkInterceptorFactory(contextProvider);
  }

  public static SmartNetworkInterceptor provideSmartNetworkInterceptor(Context context) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideSmartNetworkInterceptor(context));
  }
}
