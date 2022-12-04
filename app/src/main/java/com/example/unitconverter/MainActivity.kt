package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.unitconverter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnConvert.setOnClickListener { converting() }
    }

    private fun converting() {
        val stringInput = binding.edInput.text.toString()
        val convert = stringInput.toDouble()
        val convertList = binding.rgConvert.checkedRadioButtonId

        var convertingUnit = when(convertList){
            binding.rbMilliliter.id -> {convert/240
            }
            else -> {convert * 240
            }
        }
       if(binding.rbMilliliter.isChecked){
            binding.txtResult.text = getString(R.string.result,convertingUnit)
        }else{
            binding.txtResult.text = getString(R.string.result_t,convertingUnit)
        }

    }
}