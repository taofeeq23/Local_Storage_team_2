package com.coolbanter.local_storage_team_2

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.coolbanter.local_storage_team_2.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    lateinit var loginTest: EditText
    lateinit var password: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        retrievedata()

        binding = ActivityLoginBinding.inflate(layoutInflater)

        loginTest = binding.testFieldEditTest
        password = binding.passwordEdit

        binding.loginButton.setOnClickListener {
            savedata()
            val intent = Intent(this, LogutActivity::class.java)
            LogutActivity(intent)
        }
    }

    private fun savedata() {
        if (binding.testFieldEditTest.text!!.isEmpty()) {
            binding.testFieldEditTest.error = "Input your email address!!"
            return
        }

        if (binding.passwordEdit.text!!.isEmpty()) {
            binding.passwordEdit.error = "Password is empty!"
            return
        }

        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val editor = mypref.edit()

        editor.putString("name", binding.testFieldEditTest.text.toString())
        editor.putString("password", binding.passwordEdit.text.toString())

    }

    private fun retrievedata() {
        val mypref = getSharedPreferences("mypref", Context.MODE_PRIVATE)

        val name = mypref.getString("name", "")
        val password = mypref.getString("passord", "")

        binding.testFieldEditTest.setText(name)
        binding.passwordEdit.setText(password)
    }
}