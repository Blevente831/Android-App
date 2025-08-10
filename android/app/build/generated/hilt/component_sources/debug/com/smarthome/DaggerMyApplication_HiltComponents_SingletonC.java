package com.smarthome;

import android.app.Activity;
import android.app.Service;
import android.content.SharedPreferences;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.smarthome.data.api.ApiService;
import com.smarthome.data.network.SmartNetworkInterceptor;
import com.smarthome.data.repository.DeviceRepository;
import com.smarthome.data.repository.UserRepository;
import com.smarthome.data.utils.DeviceStateManager;
import com.smarthome.data.utils.DeviceStateRestoreManager;
import com.smarthome.data.utils.NetworkErrorHandler;
import com.smarthome.data.utils.SharedToggleStateManager;
import com.smarthome.di.AppModule_ProvideApiServiceFactory;
import com.smarthome.di.AppModule_ProvideAuthenticationInterceptorFactory;
import com.smarthome.di.AppModule_ProvideDeviceRepositoryFactory;
import com.smarthome.di.AppModule_ProvideDeviceStateManagerFactory;
import com.smarthome.di.AppModule_ProvideDeviceStateRestoreManagerFactory;
import com.smarthome.di.AppModule_ProvideMoshiFactory;
import com.smarthome.di.AppModule_ProvideNetworkErrorHandlerFactory;
import com.smarthome.di.AppModule_ProvidePreferencesManagerFactory;
import com.smarthome.di.AppModule_ProvideSharedPreferencesFactory;
import com.smarthome.di.AppModule_ProvideSharedToggleStateManagerFactory;
import com.smarthome.di.AppModule_ProvideUserRepositoryFactory;
import com.smarthome.di.NetworkModule_ProvideAiOperationsOkHttpClientFactory;
import com.smarthome.di.NetworkModule_ProvideSmartNetworkInterceptorFactory;
import com.smarthome.di.SavedStateHandleModule_ProvideDeviceIdFactory;
import com.smarthome.ui.theme.PreferencesManager;
import com.smarthome.ui.theme.ThemeEventBus;
import com.smarthome.ui.theme.ThemeViewModel;
import com.smarthome.ui.theme.ThemeViewModel_HiltModules;
import com.smarthome.viewmodel.AddDeviceViewModel;
import com.smarthome.viewmodel.AddDeviceViewModel_HiltModules;
import com.smarthome.viewmodel.AuthViewModel;
import com.smarthome.viewmodel.AuthViewModel_HiltModules;
import com.smarthome.viewmodel.DashboardViewModel;
import com.smarthome.viewmodel.DashboardViewModel_HiltModules;
import com.smarthome.viewmodel.DeviceControlViewModel;
import com.smarthome.viewmodel.DeviceControlViewModel_HiltModules;
import com.smarthome.viewmodel.DevicesViewModel;
import com.smarthome.viewmodel.DevicesViewModel_HiltModules;
import com.smarthome.viewmodel.ProfileViewModel;
import com.smarthome.viewmodel.ProfileViewModel_HiltModules;
import com.smarthome.viewmodel.SettingsViewModel;
import com.smarthome.viewmodel.SettingsViewModel_HiltModules;
import com.squareup.moshi.Moshi;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

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
public final class DaggerMyApplication_HiltComponents_SingletonC {
  private DaggerMyApplication_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public MyApplication_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements MyApplication_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements MyApplication_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements MyApplication_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements MyApplication_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements MyApplication_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements MyApplication_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements MyApplication_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public MyApplication_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends MyApplication_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends MyApplication_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends MyApplication_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends MyApplication_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
      injectMainActivity2(mainActivity);
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(8).put(LazyClassKeyProvider.com_smarthome_viewmodel_AddDeviceViewModel, AddDeviceViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_viewmodel_AuthViewModel, AuthViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_viewmodel_DashboardViewModel, DashboardViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_viewmodel_DeviceControlViewModel, DeviceControlViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_viewmodel_DevicesViewModel, DevicesViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_viewmodel_ProfileViewModel, ProfileViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_viewmodel_SettingsViewModel, SettingsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_smarthome_ui_theme_ThemeViewModel, ThemeViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @CanIgnoreReturnValue
    private MainActivity injectMainActivity2(MainActivity instance) {
      MainActivity_MembersInjector.injectDeviceStateManager(instance, singletonCImpl.provideDeviceStateManagerProvider.get());
      MainActivity_MembersInjector.injectSharedToggleStateManager(instance, singletonCImpl.provideSharedToggleStateManagerProvider.get());
      MainActivity_MembersInjector.injectDeviceStateRestoreManager(instance, singletonCImpl.provideDeviceStateRestoreManagerProvider.get());
      return instance;
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_smarthome_ui_theme_ThemeViewModel = "com.smarthome.ui.theme.ThemeViewModel";

      static String com_smarthome_viewmodel_DashboardViewModel = "com.smarthome.viewmodel.DashboardViewModel";

      static String com_smarthome_viewmodel_DeviceControlViewModel = "com.smarthome.viewmodel.DeviceControlViewModel";

      static String com_smarthome_viewmodel_AuthViewModel = "com.smarthome.viewmodel.AuthViewModel";

      static String com_smarthome_viewmodel_ProfileViewModel = "com.smarthome.viewmodel.ProfileViewModel";

      static String com_smarthome_viewmodel_AddDeviceViewModel = "com.smarthome.viewmodel.AddDeviceViewModel";

      static String com_smarthome_viewmodel_SettingsViewModel = "com.smarthome.viewmodel.SettingsViewModel";

      static String com_smarthome_viewmodel_DevicesViewModel = "com.smarthome.viewmodel.DevicesViewModel";

      @KeepFieldType
      ThemeViewModel com_smarthome_ui_theme_ThemeViewModel2;

      @KeepFieldType
      DashboardViewModel com_smarthome_viewmodel_DashboardViewModel2;

      @KeepFieldType
      DeviceControlViewModel com_smarthome_viewmodel_DeviceControlViewModel2;

      @KeepFieldType
      AuthViewModel com_smarthome_viewmodel_AuthViewModel2;

      @KeepFieldType
      ProfileViewModel com_smarthome_viewmodel_ProfileViewModel2;

      @KeepFieldType
      AddDeviceViewModel com_smarthome_viewmodel_AddDeviceViewModel2;

      @KeepFieldType
      SettingsViewModel com_smarthome_viewmodel_SettingsViewModel2;

      @KeepFieldType
      DevicesViewModel com_smarthome_viewmodel_DevicesViewModel2;
    }
  }

  private static final class ViewModelCImpl extends MyApplication_HiltComponents.ViewModelC {
    private final SavedStateHandle savedStateHandle;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AddDeviceViewModel> addDeviceViewModelProvider;

    private Provider<AuthViewModel> authViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<DeviceControlViewModel> deviceControlViewModelProvider;

    private Provider<DevicesViewModel> devicesViewModelProvider;

    private Provider<ProfileViewModel> profileViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private Provider<ThemeViewModel> themeViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.savedStateHandle = savedStateHandleParam;
      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private String string() {
      return SavedStateHandleModule_ProvideDeviceIdFactory.provideDeviceId(savedStateHandle);
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addDeviceViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.authViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.deviceControlViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.devicesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.profileViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.themeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(8).put(LazyClassKeyProvider.com_smarthome_viewmodel_AddDeviceViewModel, ((Provider) addDeviceViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_viewmodel_AuthViewModel, ((Provider) authViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_viewmodel_DashboardViewModel, ((Provider) dashboardViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_viewmodel_DeviceControlViewModel, ((Provider) deviceControlViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_viewmodel_DevicesViewModel, ((Provider) devicesViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_viewmodel_ProfileViewModel, ((Provider) profileViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_viewmodel_SettingsViewModel, ((Provider) settingsViewModelProvider)).put(LazyClassKeyProvider.com_smarthome_ui_theme_ThemeViewModel, ((Provider) themeViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_smarthome_viewmodel_AddDeviceViewModel = "com.smarthome.viewmodel.AddDeviceViewModel";

      static String com_smarthome_viewmodel_DashboardViewModel = "com.smarthome.viewmodel.DashboardViewModel";

      static String com_smarthome_viewmodel_ProfileViewModel = "com.smarthome.viewmodel.ProfileViewModel";

      static String com_smarthome_viewmodel_SettingsViewModel = "com.smarthome.viewmodel.SettingsViewModel";

      static String com_smarthome_viewmodel_AuthViewModel = "com.smarthome.viewmodel.AuthViewModel";

      static String com_smarthome_viewmodel_DevicesViewModel = "com.smarthome.viewmodel.DevicesViewModel";

      static String com_smarthome_viewmodel_DeviceControlViewModel = "com.smarthome.viewmodel.DeviceControlViewModel";

      static String com_smarthome_ui_theme_ThemeViewModel = "com.smarthome.ui.theme.ThemeViewModel";

      @KeepFieldType
      AddDeviceViewModel com_smarthome_viewmodel_AddDeviceViewModel2;

      @KeepFieldType
      DashboardViewModel com_smarthome_viewmodel_DashboardViewModel2;

      @KeepFieldType
      ProfileViewModel com_smarthome_viewmodel_ProfileViewModel2;

      @KeepFieldType
      SettingsViewModel com_smarthome_viewmodel_SettingsViewModel2;

      @KeepFieldType
      AuthViewModel com_smarthome_viewmodel_AuthViewModel2;

      @KeepFieldType
      DevicesViewModel com_smarthome_viewmodel_DevicesViewModel2;

      @KeepFieldType
      DeviceControlViewModel com_smarthome_viewmodel_DeviceControlViewModel2;

      @KeepFieldType
      ThemeViewModel com_smarthome_ui_theme_ThemeViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.smarthome.viewmodel.AddDeviceViewModel 
          return (T) new AddDeviceViewModel(singletonCImpl.provideDeviceRepositoryProvider.get());

          case 1: // com.smarthome.viewmodel.AuthViewModel 
          return (T) new AuthViewModel(singletonCImpl.provideUserRepositoryProvider.get());

          case 2: // com.smarthome.viewmodel.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.provideDeviceRepositoryProvider.get(), singletonCImpl.provideUserRepositoryProvider.get());

          case 3: // com.smarthome.viewmodel.DeviceControlViewModel 
          return (T) new DeviceControlViewModel(viewModelCImpl.string(), singletonCImpl.provideDeviceRepositoryProvider.get(), singletonCImpl.provideDeviceStateRestoreManagerProvider.get(), singletonCImpl.provideSharedToggleStateManagerProvider.get());

          case 4: // com.smarthome.viewmodel.DevicesViewModel 
          return (T) new DevicesViewModel(singletonCImpl.provideDeviceRepositoryProvider.get(), singletonCImpl.provideSharedToggleStateManagerProvider.get(), singletonCImpl.provideDeviceStateRestoreManagerProvider.get());

          case 5: // com.smarthome.viewmodel.ProfileViewModel 
          return (T) new ProfileViewModel(singletonCImpl.provideUserRepositoryProvider.get());

          case 6: // com.smarthome.viewmodel.SettingsViewModel 
          return (T) new SettingsViewModel(singletonCImpl.provideUserRepositoryProvider.get());

          case 7: // com.smarthome.ui.theme.ThemeViewModel 
          return (T) new ThemeViewModel(singletonCImpl.providePreferencesManagerProvider.get(), singletonCImpl.themeEventBusProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends MyApplication_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends MyApplication_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends MyApplication_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<DeviceStateManager> provideDeviceStateManagerProvider;

    private Provider<SharedToggleStateManager> provideSharedToggleStateManagerProvider;

    private Provider<DeviceStateRestoreManager> provideDeviceStateRestoreManagerProvider;

    private Provider<SmartNetworkInterceptor> provideSmartNetworkInterceptorProvider;

    private Provider<SharedPreferences> provideSharedPreferencesProvider;

    private Provider<Interceptor> provideAuthenticationInterceptorProvider;

    private Provider<OkHttpClient> provideAiOperationsOkHttpClientProvider;

    private Provider<Moshi> provideMoshiProvider;

    private Provider<ApiService> provideApiServiceProvider;

    private Provider<NetworkErrorHandler> provideNetworkErrorHandlerProvider;

    private Provider<DeviceRepository> provideDeviceRepositoryProvider;

    private Provider<UserRepository> provideUserRepositoryProvider;

    private Provider<PreferencesManager> providePreferencesManagerProvider;

    private Provider<ThemeEventBus> themeEventBusProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideDeviceStateManagerProvider = DoubleCheck.provider(new SwitchingProvider<DeviceStateManager>(singletonCImpl, 0));
      this.provideSharedToggleStateManagerProvider = DoubleCheck.provider(new SwitchingProvider<SharedToggleStateManager>(singletonCImpl, 1));
      this.provideDeviceStateRestoreManagerProvider = DoubleCheck.provider(new SwitchingProvider<DeviceStateRestoreManager>(singletonCImpl, 2));
      this.provideSmartNetworkInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<SmartNetworkInterceptor>(singletonCImpl, 6));
      this.provideSharedPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<SharedPreferences>(singletonCImpl, 8));
      this.provideAuthenticationInterceptorProvider = DoubleCheck.provider(new SwitchingProvider<Interceptor>(singletonCImpl, 7));
      this.provideAiOperationsOkHttpClientProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 5));
      this.provideMoshiProvider = DoubleCheck.provider(new SwitchingProvider<Moshi>(singletonCImpl, 9));
      this.provideApiServiceProvider = DoubleCheck.provider(new SwitchingProvider<ApiService>(singletonCImpl, 4));
      this.provideNetworkErrorHandlerProvider = DoubleCheck.provider(new SwitchingProvider<NetworkErrorHandler>(singletonCImpl, 10));
      this.provideDeviceRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<DeviceRepository>(singletonCImpl, 3));
      this.provideUserRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<UserRepository>(singletonCImpl, 11));
      this.providePreferencesManagerProvider = DoubleCheck.provider(new SwitchingProvider<PreferencesManager>(singletonCImpl, 12));
      this.themeEventBusProvider = DoubleCheck.provider(new SwitchingProvider<ThemeEventBus>(singletonCImpl, 13));
    }

    @Override
    public void injectMyApplication(MyApplication myApplication) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.smarthome.data.utils.DeviceStateManager 
          return (T) AppModule_ProvideDeviceStateManagerFactory.provideDeviceStateManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.smarthome.data.utils.SharedToggleStateManager 
          return (T) AppModule_ProvideSharedToggleStateManagerFactory.provideSharedToggleStateManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 2: // com.smarthome.data.utils.DeviceStateRestoreManager 
          return (T) AppModule_ProvideDeviceStateRestoreManagerFactory.provideDeviceStateRestoreManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.provideDeviceStateManagerProvider.get(), singletonCImpl.provideSharedToggleStateManagerProvider.get());

          case 3: // com.smarthome.data.repository.DeviceRepository 
          return (T) AppModule_ProvideDeviceRepositoryFactory.provideDeviceRepository(singletonCImpl.provideApiServiceProvider.get(), singletonCImpl.provideDeviceStateManagerProvider.get(), singletonCImpl.provideNetworkErrorHandlerProvider.get(), singletonCImpl.provideSharedToggleStateManagerProvider.get());

          case 4: // com.smarthome.data.api.ApiService 
          return (T) AppModule_ProvideApiServiceFactory.provideApiService(singletonCImpl.provideAiOperationsOkHttpClientProvider.get(), singletonCImpl.provideMoshiProvider.get());

          case 5: // @com.smarthome.di.AppModule.AiClient okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideAiOperationsOkHttpClientFactory.provideAiOperationsOkHttpClient(singletonCImpl.provideSmartNetworkInterceptorProvider.get(), singletonCImpl.provideAuthenticationInterceptorProvider.get());

          case 6: // com.smarthome.data.network.SmartNetworkInterceptor 
          return (T) NetworkModule_ProvideSmartNetworkInterceptorFactory.provideSmartNetworkInterceptor(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 7: // okhttp3.Interceptor 
          return (T) AppModule_ProvideAuthenticationInterceptorFactory.provideAuthenticationInterceptor(singletonCImpl.provideSharedPreferencesProvider.get());

          case 8: // android.content.SharedPreferences 
          return (T) AppModule_ProvideSharedPreferencesFactory.provideSharedPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 9: // com.squareup.moshi.Moshi 
          return (T) AppModule_ProvideMoshiFactory.provideMoshi();

          case 10: // com.smarthome.data.utils.NetworkErrorHandler 
          return (T) AppModule_ProvideNetworkErrorHandlerFactory.provideNetworkErrorHandler(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 11: // com.smarthome.data.repository.UserRepository 
          return (T) AppModule_ProvideUserRepositoryFactory.provideUserRepository(singletonCImpl.provideApiServiceProvider.get(), singletonCImpl.provideSharedPreferencesProvider.get());

          case 12: // com.smarthome.ui.theme.PreferencesManager 
          return (T) AppModule_ProvidePreferencesManagerFactory.providePreferencesManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 13: // com.smarthome.ui.theme.ThemeEventBus 
          return (T) new ThemeEventBus();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
