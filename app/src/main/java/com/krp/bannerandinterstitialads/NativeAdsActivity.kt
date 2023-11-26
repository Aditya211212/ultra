package com.krp.bannerandinterstitialads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.krp.bannerandinterstitialads.mynative.TemplateView

class NativeAdsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_native_ads2)

        val templateView = findViewById<TemplateView>(R.id.templateView)
        loadSmallMediumSizeNativeAds(this,R.string.small_medium_native_ads,templateView)
    }
}