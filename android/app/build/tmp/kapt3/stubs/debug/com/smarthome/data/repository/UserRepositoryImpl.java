package com.smarthome.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0001*B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\u000e\u0010\u000f\u001a\u00020\u0010H\u0096@\u00a2\u0006\u0002\u0010\u0011J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\nH\u0016J\b\u0010\u0013\u001a\u00020\fH\u0016J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0096@\u00a2\u0006\u0002\u0010\u0018J\u000e\u0010\u0019\u001a\u00020\u001aH\u0096@\u00a2\u0006\u0002\u0010\u0011J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0096@\u00a2\u0006\u0002\u0010\u001eJ\u001e\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010 \u001a\u00020\fH\u0096@\u00a2\u0006\u0002\u0010!J\u0016\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020$H\u0096@\u00a2\u0006\u0002\u0010%J\u0016\u0010&\u001a\u00020\u00102\u0006\u0010\'\u001a\u00020(H\u0096@\u00a2\u0006\u0002\u0010)R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006+"}, d2 = {"Lcom/smarthome/data/repository/UserRepositoryImpl;", "Lcom/smarthome/data/repository/UserRepository;", "apiService", "Lcom/smarthome/data/api/ApiService;", "sharedPreferences", "Landroid/content/SharedPreferences;", "(Lcom/smarthome/data/api/ApiService;Landroid/content/SharedPreferences;)V", "getAuthToken", "", "getEmail", "Lkotlinx/coroutines/flow/Flow;", "getUserPreference", "", "key", "defaultValue", "getUserProfile", "Lcom/smarthome/data/model/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUsername", "isUserLoggedIn", "login", "Lcom/smarthome/data/model/AuthResponse;", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "register", "registerRequest", "Lcom/smarthome/data/model/RegisterRequest;", "(Lcom/smarthome/data/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUserPreference", "value", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserPreferences", "preferences", "Lcom/smarthome/data/model/UserPreferences;", "(Lcom/smarthome/data/model/UserPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "updateRequest", "Lcom/smarthome/data/model/UpdateUserRequest;", "(Lcom/smarthome/data/model/UpdateUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class UserRepositoryImpl implements com.smarthome.data.repository.UserRepository {
    @org.jetbrains.annotations.NotNull
    private final com.smarthome.data.api.ApiService apiService = null;
    @org.jetbrains.annotations.NotNull
    private final android.content.SharedPreferences sharedPreferences = null;
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_AUTH_TOKEN = "auth_token";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_USER_EMAIL = "user_email";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_DARK_MODE = "dark_mode";
    @org.jetbrains.annotations.NotNull
    private static final java.lang.String KEY_NOTIFICATIONS_ENABLED = "notifications_enabled";
    @org.jetbrains.annotations.NotNull
    public static final com.smarthome.data.repository.UserRepositoryImpl.Companion Companion = null;
    
    @javax.inject.Inject
    public UserRepositoryImpl(@org.jetbrains.annotations.NotNull
    com.smarthome.data.api.ApiService apiService, @org.jetbrains.annotations.NotNull
    android.content.SharedPreferences sharedPreferences) {
        super();
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object login(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.AuthResponse> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object register(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.RegisterRequest registerRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.AuthResponse> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object getUserProfile(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateUserProfile(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.UpdateUserRequest updateRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object updateUserPreferences(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.UserPreferences preferences, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.Boolean> getUserPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean defaultValue) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.Object setUserPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean value, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.String> getUsername() {
        return null;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.NotNull
    public kotlinx.coroutines.flow.Flow<java.lang.String> getEmail() {
        return null;
    }
    
    @java.lang.Override
    public boolean isUserLoggedIn() {
        return false;
    }
    
    @java.lang.Override
    @org.jetbrains.annotations.Nullable
    public java.lang.String getAuthToken() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/smarthome/data/repository/UserRepositoryImpl$Companion;", "", "()V", "KEY_AUTH_TOKEN", "", "KEY_DARK_MODE", "KEY_NOTIFICATIONS_ENABLED", "KEY_USER_EMAIL", "KEY_USER_NAME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}