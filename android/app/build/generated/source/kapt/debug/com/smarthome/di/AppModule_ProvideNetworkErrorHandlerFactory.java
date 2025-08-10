package com.smarthome.di;

import android.content.Context;
import com.smarthome.data.utils.NetworkErrorHandler;
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
public final class AppModule_ProvideNetworkErrorHandlerFactory implements Factory<NetworkErrorHandler> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideNetworkErrorHandlerFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NetworkErrorHandler get() {
    return provideNetworkErrorHandler(contextProvider.get());
  }

  public static AppModule_ProvideNetworkErrorHandlerFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideNetworkErrorHandlerFactory(contextProvider);
  }

  public static NetworkErrorHandler provideNetworkErrorHandler(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNetworkErrorHandler(context));
  }
}
