package com.smarthome.data.repository;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H&J\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\u001e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u00052\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H&J\u000e\u0010\n\u001a\u00020\u000bH\u00a6@\u00a2\u0006\u0002\u0010\fJ\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H&J\b\u0010\u000e\u001a\u00020\u0007H&J\u001e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003H\u00a6@\u00a2\u0006\u0002\u0010\u0013J\u000e\u0010\u0014\u001a\u00020\u0015H\u00a6@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0018H\u00a6@\u00a2\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u0007H\u00a6@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001fH\u00a6@\u00a2\u0006\u0002\u0010 J\u0016\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020#H\u00a6@\u00a2\u0006\u0002\u0010$\u00a8\u0006%"}, d2 = {"Lcom/smarthome/data/repository/UserRepository;", "", "getAuthToken", "", "getEmail", "Lkotlinx/coroutines/flow/Flow;", "getUserPreference", "", "key", "defaultValue", "getUserProfile", "Lcom/smarthome/data/model/User;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUsername", "isUserLoggedIn", "login", "Lcom/smarthome/data/model/AuthResponse;", "email", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "", "register", "registerRequest", "Lcom/smarthome/data/model/RegisterRequest;", "(Lcom/smarthome/data/model/RegisterRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setUserPreference", "value", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserPreferences", "preferences", "Lcom/smarthome/data/model/UserPreferences;", "(Lcom/smarthome/data/model/UserPreferences;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateUserProfile", "updateRequest", "Lcom/smarthome/data/model/UpdateUserRequest;", "(Lcom/smarthome/data/model/UpdateUserRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface UserRepository {
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull
    java.lang.String email, @org.jetbrains.annotations.NotNull
    java.lang.String password, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.AuthResponse> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object register(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.RegisterRequest registerRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.AuthResponse> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object getUserProfile(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUserProfile(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.UpdateUserRequest updateRequest, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object updateUserPreferences(@org.jetbrains.annotations.NotNull
    com.smarthome.data.model.UserPreferences preferences, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super com.smarthome.data.model.User> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Boolean> getUserPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean defaultValue);
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.Object setUserPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean value, @org.jetbrains.annotations.NotNull
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getUsername();
    
    @org.jetbrains.annotations.NotNull
    public abstract kotlinx.coroutines.flow.Flow<java.lang.String> getEmail();
    
    public abstract boolean isUserLoggedIn();
    
    @org.jetbrains.annotations.Nullable
    public abstract java.lang.String getAuthToken();
}