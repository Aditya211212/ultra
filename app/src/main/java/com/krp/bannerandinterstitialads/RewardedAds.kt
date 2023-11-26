package com.krp.bannerandinterstitialads

import android.app.Activity
import android.widget.Toast
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.rewarded.RewardItem
import com.google.android.gms.ads.rewarded.RewardedAd
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback

class RewardedAds(private val activity: Activity) {

    private var rewardedAd : RewardedAd? = null

    fun loadRewardedAds(adUnitIdL: Int) {
        val adRequest = AdRequest.Builder().build()

        RewardedAd.load(
            activity,
            activity.
            getString(adUnitIdL),
            adRequest,object : RewardedAdLoadCallback(){
                override fun onAdLoaded(mRewardedAd: RewardedAd) {
                  rewardedAd = mRewardedAd
                }

                override fun onAdFailedToLoad(p0: LoadAdError) {
                    rewardedAd = null
                }
            }
        )
    }

    fun showRewardedAds(adUnitdL : Int, aftercodeRewardcoin : (RewardItem) -> Unit){
        if(rewardedAd != null){
            rewardedAd!!.fullScreenContentCallback = object : FullScreenContentCallback(){
                override fun onAdDismissedFullScreenContent() {
                    rewardedAd = null
                    loadRewardedAds(adUnitdL)
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    rewardedAd = null
                }
            }
            rewardedAd!!.show(activity){
                aftercodeRewardcoin(it)
            }
        }else{
            Toast.makeText(activity,"Ads is Loaded!",Toast.LENGTH_LONG).show()
        }
    }
}