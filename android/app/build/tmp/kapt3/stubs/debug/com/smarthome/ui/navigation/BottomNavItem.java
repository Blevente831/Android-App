package com.smarthome.ui.navigation;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\r\u000e\u000f\u0010B\u001f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u0082\u0001\u0004\u0011\u0012\u0013\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/smarthome/ui/navigation/BottomNavItem;", "", "route", "", "iconId", "", "title", "(Ljava/lang/String;ILjava/lang/String;)V", "getIconId", "()I", "getRoute", "()Ljava/lang/String;", "getTitle", "Dashboard", "Devices", "Profile", "Settings", "Lcom/smarthome/ui/navigation/BottomNavItem$Dashboard;", "Lcom/smarthome/ui/navigation/BottomNavItem$Devices;", "Lcom/smarthome/ui/navigation/BottomNavItem$Profile;", "Lcom/smarthome/ui/navigation/BottomNavItem$Settings;", "app_debug"})
public abstract class BottomNavItem {
    @org.jetbrains.annotations.NotNull
    private final java.lang.String route = null;
    private final int iconId = 0;
    @org.jetbrains.annotations.NotNull
    private final java.lang.String title = null;
    
    private BottomNavItem(java.lang.String route, int iconId, java.lang.String title) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getRoute() {
        return null;
    }
    
    public final int getIconId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getTitle() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/smarthome/ui/navigation/BottomNavItem$Dashboard;", "Lcom/smarthome/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Dashboard extends com.smarthome.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.smarthome.ui.navigation.BottomNavItem.Dashboard INSTANCE = null;
        
        private Dashboard() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/smarthome/ui/navigation/BottomNavItem$Devices;", "Lcom/smarthome/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Devices extends com.smarthome.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.smarthome.ui.navigation.BottomNavItem.Devices INSTANCE = null;
        
        private Devices() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/smarthome/ui/navigation/BottomNavItem$Profile;", "Lcom/smarthome/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Profile extends com.smarthome.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.smarthome.ui.navigation.BottomNavItem.Profile INSTANCE = null;
        
        private Profile() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/smarthome/ui/navigation/BottomNavItem$Settings;", "Lcom/smarthome/ui/navigation/BottomNavItem;", "()V", "app_debug"})
    public static final class Settings extends com.smarthome.ui.navigation.BottomNavItem {
        @org.jetbrains.annotations.NotNull
        public static final com.smarthome.ui.navigation.BottomNavItem.Settings INSTANCE = null;
        
        private Settings() {
        }
    }
}