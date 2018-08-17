package com.annapurna.envato.explicitintents

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        calculateAge()

        b_finish.setOnClickListener {
            val data = Intent()
            data.putExtra(CALCULATED_AGE, currentYear - birthYear)
            setResult(Activity.RESULT_OK, data)
            finish()
        }
    }

    private fun calculateAge() {
        val extras = intent.extras
        currentYear = extras.getInt(MainActivity.CURRENT_YEAR, 0)
        birthYear = extras.getInt(MainActivity.BIRTH_YEAR, 0)

        tv_age.text = "Your age: ${currentYear - birthYear}"
    }

    companion object {
        private var currentYear = 0
        private var birthYear = 0
        val CALCULATED_AGE = "calculated_age"
    }
}
