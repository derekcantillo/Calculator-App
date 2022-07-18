package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var num1 : Double = 0.0
    private var num2 : Double = 0.0
    private var operation : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        resultsText.text = "0"

        oneButton.setOnClickListener { (numberPress("1")) }
        twoButton.setOnClickListener { (numberPress("2")) }
        threeButton.setOnClickListener { (numberPress("3")) }
        fourButton.setOnClickListener { (numberPress("4")) }
        fiveButton.setOnClickListener { (numberPress("5")) }
        sixButton.setOnClickListener { (numberPress("6")) }
        sevenButton.setOnClickListener { (numberPress("7")) }
        eightButton.setOnClickListener { (numberPress("8")) }
        nineButton.setOnClickListener { (numberPress("9")) }
        zeroButton.setOnClickListener { (numberPress("0")) }
        delButton.setOnClickListener { (deleteResults()) }
        pointButton.setOnClickListener{(numberPress("."))}
        addButton.setOnClickListener{(operationPress(SUM))}
        subsButton.setOnClickListener{(operationPress(SUBS))}
        multiplyButton.setOnClickListener{(operationPress(MULTI))}
        slashButton.setOnClickListener{(operationPress(DIV))}
        porcentButton.setOnClickListener{(operationPress(PORCENT))}

        equalButton.setOnClickListener{
            var result = when(operation){
                SUM -> num1 + num2
                SUBS -> num1 - num2
                MULTI -> num1 * num2
                DIV -> num1 / num2
                else -> 0
            }
            resultsText.text = result.toString()
        }

    }
    private fun numberPress(selected : String){
        resultsText.text = "${resultsText.text}$selected"
        if (operation == NO_OP){

            num1 = resultsText.text.toString().toDouble()
        }else{
            num2 = resultsText.text.toString().toDouble()
        }



    }
    private fun operationPress(selected: Int){
        operation = selected
        num1 = resultsText.text.toString().toDouble()
        resultsText.text="0"
    }
    private fun deleteResults(){
        num1 = 0.0
        num2 = 0.0
        operation = NO_OP
        resultsText.text = "0"
    }

    companion object{
        const val SUM = 1
        const val SUBS = 2
        const val MULTI = 3
        const val DIV = 4
        const val PORCENT = 5
        const val NO_OP = 0
    }
}