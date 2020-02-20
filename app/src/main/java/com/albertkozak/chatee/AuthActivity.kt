package com.albertkozak.chatee

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_auth.*

class AuthActivity: AppCompatActivity() {
    private lateinit var authMode: MainActivity.AuthMode

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        authMode = intent?.extras?.getParcelable(AuthModeExtraName)!!

        when(authMode) {
            is MainActivity.AuthMode.Login -> { auth_button.text = getString(R.string.login)}
            is MainActivity.AuthMode.Register -> { auth_button.text = getString(R.string.register) }
        }
    }

    companion object {
        const val AuthModeExtraName = "AUTH_MODE"

        fun newIntent(authMode: MainActivity.AuthMode, context: Context): Intent {
            val intent = Intent(context, AuthActivity::class.java)
            intent.putExtra(AuthModeExtraName, authMode)
            return intent
        }
    }
}