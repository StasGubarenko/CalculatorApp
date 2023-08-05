package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.example.calculatorapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    var result: Double = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        binding.buttonPlus.setOnClickListener {
            
            val inputA = binding.inputA.text.toString()
            val inputB = binding.inputB.text.toString()
            
            if (!isEmptyField(inputA, inputB)) {
                
                result = inputA.toDouble() + inputB.toDouble()

                inputResult()
            }
        }

        binding.buttonMinus.setOnClickListener {

            val inputA = binding.inputA.text.toString()
            val inputB = binding.inputB.text.toString()

            if (!isEmptyField(inputA, inputB)) {

                result = inputA.toDouble() - inputB.toDouble()

                inputResult()
            }
        }

        binding.buttonDivision.setOnClickListener {

            val inputA = binding.inputA.text.toString()
            val inputB = binding.inputB.text.toString()

            if (!isDividedZero(inputB)) {
                if (!isEmptyField(inputA, inputB)) {
                    result = inputA.toDouble() / inputB.toDouble()
                    inputResult()
                }
            }
        }

        binding.buttonMultiplication.setOnClickListener {

            val inputA = binding.inputA.text.toString()
            val inputB = binding.inputB.text.toString()

            if (!isEmptyField(inputA, inputB)) {

                result = inputA.toDouble() * inputB.toDouble()

                inputResult()
            }
        }


    }

   private  fun isDividedZero(inputB : String) : Boolean{
        if(inputB == "0"){
            binding.apply {
                result.visibility = View.VISIBLE
                result.text = getString(R.string.error)
            }

            return true
        }
       return false
    }

    private fun inputResult() {
        binding.result.visibility = View.VISIBLE

        val a = R.string.result

        val totalString = getString(R.string.result) + result

        binding.result.text = totalString
    }

    private fun isEmptyField(inputA: String, inputB: String): Boolean {
        if (inputA.isEmpty() || inputB.isEmpty()) {
            binding.result.visibility = View.VISIBLE

                binding.result.text = getString(R.string.warning)

            return true
        }
        return false
    }

}