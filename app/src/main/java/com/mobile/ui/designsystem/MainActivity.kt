package com.mobile.ui.designsystem

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.mobile.ui.sdk.views.AvatarView

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        //val avatarView = findViewById<AvatarView>(R.id.avatarViewSmallOnlyImage)
        //avatarView.uri = "https://via.placeholder.com/500"

    }
}