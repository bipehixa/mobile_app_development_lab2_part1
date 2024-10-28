package com.example.lab2_1

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.lab2_1.databinding.ActivityMainBinding
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.execute.setOnClickListener {
            val toast = Toast.makeText(this, execute(), Toast.LENGTH_LONG)
            toast.show()
        }
    }

    private fun execute(): String {


        if (binding.a.text.toString() == "a" || binding.b.text.toString() == "b" || binding.c.text.toString() == "c") {
            return "Нет решения"
        }

        val a = if (binding.a.text.toString().isEmpty())  1.0 else binding.a.text.toString().toDouble()
        val b = if (binding.b.text.toString().isEmpty())  1.0 else binding.b.text.toString().toDouble()
        val c = if (binding.c.text.toString().isEmpty())  1.0 else binding.c.text.toString().toDouble()

        val d = b * b - 4 * a * c

        Log.d("D", d.toString())

        return when {
            d < 0 -> "Нет решения"
            d == 0.0 -> "X = ${-b / a / 2.0}"
            else -> "X1 = ${(-b + sqrt(d)) / a / 2.0} X2 = ${(-b - sqrt(d)) / a / 2.0}"
        }

    }

}