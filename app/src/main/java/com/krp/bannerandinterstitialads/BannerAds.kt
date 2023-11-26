package com.krp.bannerandinterstitialads

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.initialization.InitializationStatus
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener
import com.krp.bannerandinterstitialads.databinding.ActivityBannerAdsBinding
import com.krp.bannerandinterstitialads.databinding.ActivityMainBinding

private lateinit var binding: ActivityBannerAdsBinding
class BannerAds : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner_ads)
        binding = ActivityBannerAdsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //banner ad initialize
        MobileAds.initialize(this
        ) { Log.d("Mobile Ads Initialization", "completed") }

        //ad request
        val adRequest = AdRequest.Builder().build()
        binding.bannerAd.loadAd(adRequest)

        binding.bannerAd.adListener = object : AdListener(){
            override fun onAdLoaded() {
                super.onAdLoaded()
                    Log.d("ADInfo","Ad Loaded!")
            }

            override fun onAdOpened() {
                super.onAdOpened()
                    Log.d("ADInfo","Ad Opened!")
            }

            override fun onAdClicked() {
                super.onAdClicked()
                Log.d("ADInfo","Ad Clicked!")
            }

            override fun onAdClosed() {
                super.onAdClosed()
                Log.d("ADInfo","Ad Closed!")
            }

            override fun onAdFailedToLoad(p0: LoadAdError) {
                super.onAdFailedToLoad(p0)
                Log.d("ADInfo","Ad Failed to load..$p0")
            }

            override fun onAdImpression() {
                super.onAdImpression()
                Log.d("ADInfo","Ad Impression Added!")
            }
        }
    }
}