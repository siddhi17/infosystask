package com.example.learn.base

import android.app.Application
import android.os.StrictMode
import com.example.learn.helper.InternetUtil


class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        InternetUtil.init(this)
        val builder = StrictMode.VmPolicy.Builder()
        StrictMode.setVmPolicy(builder.build())
        instance = this
    }

    companion object {
        lateinit var instance: MyApplication
            private set
    }
}