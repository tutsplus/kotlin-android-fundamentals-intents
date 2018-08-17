package com.annapurna.envato.factorialrequest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun getFactorial(view: View) {
        val intent = Intent("com.annapurna.envato.implicitintents.FACTORIAL")
        val num = Integer.parseInt(et_number.text.toString())
        intent.putExtra("factorial", num)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No Apps Found to handle the request", Toast.LENGTH_LONG).show()
        }
    }
}
