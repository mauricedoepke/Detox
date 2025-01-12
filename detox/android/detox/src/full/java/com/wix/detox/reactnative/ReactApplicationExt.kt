package com.wix.detox.reactnative

import android.annotation.SuppressLint
import com.facebook.react.ReactApplication
import com.facebook.react.ReactInstanceManager
import com.facebook.react.bridge.ReactContext
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint


fun ReactApplication.getInstanceManagerSafe(): ReactInstanceManager {
    return reactNativeHost.reactInstanceManager
        ?: throw RuntimeException("ReactInstanceManager is null!")
}

@SuppressLint("VisibleForTests")
fun ReactApplication.getCurrentReactContextSafe(): ReactContext? {
    return if (isFabricEnabled()) {
        reactHost?.currentReactContext
    } else {
        getInstanceManagerSafe().currentReactContext
    }
}

/**
 * A method to check if Fabric is enabled in the React Native application.
 */
fun isFabricEnabled(): Boolean {
    return DefaultNewArchitectureEntryPoint.fabricEnabled
}
