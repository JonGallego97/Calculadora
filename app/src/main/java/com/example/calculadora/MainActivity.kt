package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentInput = ""
    private var currentResult = 0.0
    private lateinit var resultTextView: TextView
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById <Button> (R.id.button0).setOnClickListener { handleNumberClick("0") }
        findViewById <Button> (R.id.button1).setOnClickListener { handleNumberClick("1") }
        findViewById <Button> (R.id.button2).setOnClickListener { handleNumberClick("2") }
        findViewById <Button> (R.id.button3).setOnClickListener { handleNumberClick("3") }
        findViewById <Button> (R.id.button4).setOnClickListener { handleNumberClick("4") }
        findViewById <Button> (R.id.button5).setOnClickListener { handleNumberClick("5") }
        findViewById <Button> (R.id.button6).setOnClickListener { handleNumberClick("6") }
        findViewById <Button> (R.id.button7).setOnClickListener { handleNumberClick("7") }
        findViewById <Button> (R.id.button8).setOnClickListener { handleNumberClick("8") }
        findViewById <Button> (R.id.button9).setOnClickListener { handleNumberClick("9") }
        findViewById <Button> (R.id.buttonComa).setOnClickListener { handleNumberClick(".") }
        findViewById <Button> (R.id.buttonDelete).setOnClickListener { handleNumberClick("1") }
        findViewById <Button> (R.id.buttonDiv).setOnClickListener { onOperationClick("/") }
        findViewById <Button> (R.id.buttonMinus).setOnClickListener { onOperationClick("-") }
        findViewById <Button> (R.id.buttonPlus).setOnClickListener { onOperationClick("+") }
        findViewById <Button> (R.id.buttonEqual).setOnClickListener { onEqualsClick() }

    }

    private fun onEqualsClick() {
        if (operation.isEmpty()) {
            resultTextView.text = currentInput
        } else {
            when(operation){
                "+" -> currentResult += currentInput.toDouble()
                "-" -> currentResult -= currentInput.toDouble()
                "*" -> currentResult *= currentInput.toDouble()
                "/" -> currentResult /= currentInput.toDouble()
            }
        }
    }

    private fun handleNumberClick(number: String) {
        currentInput += number
        updateResult()
    }

    private fun updateResult() {
        resultTextView.text = currentInput
    }
    private fun onOperationClick(selectedOperation: String) {
        operation = selectedOperation
        currentResult = currentInput.toDouble()
        currentInput = ""
        updateResult()

    }

}