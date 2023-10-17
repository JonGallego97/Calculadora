package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private var currentInput = ""
    private var currentResult = 0.0
    private var operation = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState != null) {
            currentInput = savedInstanceState.getString("currentInput", "")
            currentResult = savedInstanceState.getDouble("currentResult", 0.0)
            operation = savedInstanceState.getString("operation", "")
            updateResult()
        }
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
        findViewById <Button> (R.id.buttonDelete).setOnClickListener { clear() }
        findViewById <Button> (R.id.buttonDiv).setOnClickListener { onOperationClick("/") }
        findViewById <Button> (R.id.buttonMinus).setOnClickListener { onOperationClick("-") }
        findViewById <Button> (R.id.buttonPlus).setOnClickListener { onOperationClick("+") }
        findViewById <Button> (R.id.buttonMulti).setOnClickListener { onOperationClick("x") }

        findViewById <Button> (R.id.buttonEqual).setOnClickListener { onEqualsClick() }

    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("currentInput", currentInput)
        outState.putDouble("currentResult", currentResult)
        outState.putString("operation", operation)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        currentInput = savedInstanceState.getString("currentInput", "")
        currentResult = savedInstanceState.getDouble("currentResult", 0.0)
        operation = savedInstanceState.getString("operation", "")
        updateResult()
    }

    private fun clear() {
        findViewById<TextView>(R.id.result).text = ""
        currentInput = ""
        currentResult = 0.0
        operation = ""

    }

    private fun onEqualsClick() {
        val result = calculateExpression(currentInput)
        currentInput = result.toString()
        updateResult()
    }

    private fun handleNumberClick(number: String) {
        currentInput += number
        updateResult()
    }
    private fun updateResult() {
        findViewById<TextView>(R.id.result).text = currentInput
    }
    private fun onOperationClick(selectedOperation: String) {
        operation = selectedOperation
        currentInput += operation
        updateResult()




    }
    private fun calculateExpression(expression: String): Double {
        val parts = expression.split(Regex("[+\\-x/]"))
        val operators = expression.filter { it in "+-x/" }
        var result = parts[0].toDouble()

        for (i in 1 until parts.size) {
            val number = parts[i].toDouble()
            val operator = operators[i - 1]

            when (operator) {
                '+' -> result += number
                '-' -> result -= number
                'x' -> result *= number
                '/' -> {
                    if (number != 0.0) {
                        result /= number
                    } else {
                        // Manejar división por cero
                        return Double.NaN
                    }
                }
            }
        }

        return result
    }


}

