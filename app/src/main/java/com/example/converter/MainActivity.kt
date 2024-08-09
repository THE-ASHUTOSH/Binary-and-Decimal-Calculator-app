package com.example.converter

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    var decNumber: Int = 0
    var binaryNumber: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var numberInputPlace = findViewById<EditText>(R.id.editTextNumber)
        var binaryBtn = findViewById<Button>(R.id.binaryBtn)
        var decimalBtn = findViewById<Button>(R.id.decimalBtn)
        var answerView = findViewById<TextView>(R.id.Ans)



        binaryBtn.setOnClickListener {
            decNumber = 0
            binaryNumber = 0
            decNumber = numberInputPlace.text.toString().toInt()
            var i: Int = 1
            while (decNumber > 0) {
                binaryNumber += (decNumber % 2) * i
                decNumber /= 2
                i *= 10
            }
            answerView.text = "Number = " + binaryNumber
        }

        decimalBtn.setOnClickListener {
            decNumber = 0
            binaryNumber = 0
            binaryNumber = numberInputPlace.text.toString().toInt()
            var i: Int = 1
            while (binaryNumber > 0) {
                if (binaryNumber % 10 == 1 || binaryNumber % 10 == 0) {
                    decNumber += (binaryNumber % 10) * i
                    binaryNumber /= 10
                    i *= 2
                } else {
                    Toast.makeText(
                        applicationContext, "Please Enter Binary Numbar", Toast
                            .LENGTH_SHORT
                    )
                        .show()
                    break;
                }
                answerView.text = "Number = " + decNumber
            }


        }
    }

}
