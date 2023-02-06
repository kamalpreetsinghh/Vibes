package com.cleverlycode.vibes

import android.annotation.SuppressLint
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import com.cleverlycode.vibes.data.service.impl.AccountServiceImpl
import com.cleverlycode.vibes.nav_graphs.Graph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VibesActivity : ComponentActivity() {
    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        if (resources.getBoolean(R.bool.portrait_only)) {   //In phones only portrait mode
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        }
        installSplashScreen()
        setContent {
            VibesApp()
        }
    }
}