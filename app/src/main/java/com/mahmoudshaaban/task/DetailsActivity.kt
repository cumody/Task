package com.mahmoudshaaban.task

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*

class DetailsActivity : AppCompatActivity() {

    lateinit var preferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    val data = "Task"
    var saved = false

    val USERNAME_KEY = "Username"
    val AGE_KEY = "Age"
    val JOBTITLE_KEY = "Jobtitle"
    val GENDER_KEY = "Gender"
    val SAVE_INFORMATION_KEY = "SAVE"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)


        preferences = getSharedPreferences(data, Context.MODE_PRIVATE)

        val name = preferences.getString(USERNAME_KEY, "")
        val age = preferences.getString(AGE_KEY, "")
        val jobTitle = preferences.getString(JOBTITLE_KEY, "")
        val gender = preferences.getString(GENDER_KEY, "")
        val save = preferences.getBoolean(SAVE_INFORMATION_KEY, true)


        get_username.text = name
        get_age.text = age
        get_jobtitle.text = jobTitle
        get_gender.text = gender


        clear.setOnClickListener {

            editor = preferences.edit()
            editor.clear()
            editor.apply()

            goToMainActivity()
            showToast("Data cleared Successfully")

        }


    }

    fun goToMainActivity() {
        val intent = Intent(this@DetailsActivity, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}