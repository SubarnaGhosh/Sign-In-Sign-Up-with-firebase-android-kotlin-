package com.example.signup_signin_firebase

import android.view.ActionMode
import androidx.appcompat.app.AppCompatActivity

class Thirdact : AppCompatActivity(){
    override fun onActionModeFinished(mode: ActionMode?) {
        super.onActionModeFinished(mode)
        setContentView(R.layout.act_third)
    }
}