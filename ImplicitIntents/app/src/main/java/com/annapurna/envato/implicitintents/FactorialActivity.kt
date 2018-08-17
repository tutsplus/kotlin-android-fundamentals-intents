package com.annapurna.envato.implicitintents

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_factorial.*

class FactorialActivity : AppCompatActivity() {

    private var factorial: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_factorial)

        val intent = intent
        if (intent.hasExtra("factorial")) {
            val num = intent.getIntExtra("factorial", 0)
            factorial = calculate(num)
            tv_factorial.text = factorial.toString()
        }
    }

    private fun calculate(num: Int): Int {
        return if (num == 0)
            1
        else
            num * calculate(num - 1)
    }
}
