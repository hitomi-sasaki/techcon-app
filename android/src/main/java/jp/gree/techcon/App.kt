package jp.gree.techcon

import android.app.Application
import android.os.Build
import androidx.appcompat.app.AppCompatDelegate
import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.context

@Suppress("unused")
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // TODO: Use DI
        context = applicationContext

        val nightMode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
        } else {
            AppCompatDelegate.MODE_NIGHT_AUTO_BATTERY
        }
        AppCompatDelegate.setDefaultNightMode(nightMode)
    }
}
