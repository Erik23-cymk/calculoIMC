package com.example.calculoimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun calculate() {

        val weight = editWeight.text.toString().toFloat()
        val height = editHeight.text.toString().toFloat()

        val totalvalue = weight.toDouble() / (height.toDouble() * height.toDouble())
        textTotalValue.text = " ${"%.2f".format(totalvalue)}"

        seuImc.text = when (totalvalue) {
            in 0..17 -> "Muito abaixo do peso."
            in 17.1..18.49 -> "Abaixo do peso."
            in 18.5..24.99 -> "Peso normal."
            in 25.0..29.99 -> "Acima do peso."
            in 30.0..34.99 -> "Obesidade I."
            in 35.0..39.99 -> "Obesidade II(severa)."
            else -> "Obesidade III(mórbida)."

        }


    }
}