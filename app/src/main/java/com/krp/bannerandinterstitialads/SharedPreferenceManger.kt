package com.krp.bannerandinterstitialads

import android.content.Context
import androidx.appcompat.app.AppCompatActivity

class SharedPreferenceManger(context: Context) {
    private val preference = context.getSharedPreferences(
        context.packageName,
        AppCompatActivity.MODE_PRIVATE
    )
    private val editor = preference.edit()

    private val ketTotalRewardedAmount = "totalRewardedAmount"



    var totalRewardedAmount
        get() = preference.getInt(ketTotalRewardedAmount, 0)
        set(value) {
            editor.putInt(ketTotalRewardedAmount, value)
            editor.commit()
        }

}