package com.lleans.statusbaropener

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Build
import android.os.Bundle
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sbservice: Any = this.getSystemService("statusbar")
        val statusbarManager = Class.forName("android.app.StatusBarManager")
        val showsb = if (Build.VERSION.SDK_INT >= 17) {
            statusbarManager.getMethod("expandNotificationsPanel")
        } else {
            statusbarManager.getMethod("expand")
        }
        showsb.invoke(sbservice)
        this.finish()
        exitProcess(0)
    }
}