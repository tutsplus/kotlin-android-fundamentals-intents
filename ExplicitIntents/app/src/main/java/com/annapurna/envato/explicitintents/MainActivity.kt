package com.annapurna.envato.explicitintents

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun sendData(view: View) {
        var current = Integer.parseInt(et_current_year.text.toString())
        var birth = Integer.parseInt(et_birth_year.text.toString())

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra(CURRENT_YEAR, current)
        intent.putExtra(BIRTH_YEAR, birth)
        startActivityForResult(intent, REQUEST_CODE_AGE)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_CODE_AGE && resultCode == Activity.RESULT_OK) {
            val age = data?.getIntExtra(SecondActivity.CALCULATED_AGE, 0)
            tv_result_age.text = age.toString()
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    companion object {
        val CURRENT_YEAR = "current_year"
        val BIRTH_YEAR = "birth_year"
        val REQUEST_CODE_AGE = 99
    }
}
