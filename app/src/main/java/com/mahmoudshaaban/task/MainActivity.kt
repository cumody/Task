package com.mahmoudshaaban.task

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    val data = "Task"
    var saved = false
    val USERNAME_KEY = "Username"
    val AGE_KEY = "Age"
    val JOBTITLE_KEY = "Jobtitle"
    val GENDER_KEY = "Gender"
    val SAVE_INFORMATION_KEY = "SAVE"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = getSharedPreferences(data, Context.MODE_PRIVATE)
        saved = sharedPreferences.getBoolean(SAVE_INFORMATION_KEY, false)

        if (saved) {
            goToDetailsActivity()
        } else {

            save_button.setOnClickListener {

                val _name = username.text.toString()
                val _age = age.text.toString()
                val _jobTitle = job_title.text.toString()
                val _gender = gender.text.toString()
                val radiso: Boolean = radio.isChecked

                val editor: SharedPreferences.Editor = sharedPreferences.edit()
                editor.putString(USERNAME_KEY, _name)
                editor.putString(AGE_KEY, _age)
                editor.putString(JOBTITLE_KEY, _jobTitle)
                editor.putString(GENDER_KEY, _gender)
                editor.putBoolean(SAVE_INFORMATION_KEY, radiso)
                editor.apply()

                showToast("Information Saved Successfully")
                goToDetailsActivity()


            }


        }


    }

    fun goToDetailsActivity() {
        val intent = Intent(this@MainActivity, DetailsActivity::class.java)
        startActivity(intent)
        finish()
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}