package com.mobile.ui.sdk.utils

import android.annotation.SuppressLint
import android.content.res.Resources
import com.mobile.ui.sdk.R

@SuppressLint("NewApi")
class Fonts(resources: Resources) {
    val roboto_medium  = resources.getFont(R.font.roboto_medium)
    val roboto_regular = resources.getFont(R.font.roboto_regular)
    val roboto_bold    = resources.getFont(R.font.roboto_bold)
}