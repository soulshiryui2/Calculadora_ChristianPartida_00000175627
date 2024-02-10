package mx.edu.potros.calculadoracomun


import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var numero1 = ""
    private var numero2 = ""
    private var simbolo = ""
    private var nuevaoperacion = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onDigitClick(view: View) {
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        if (nuevaoperacion) {
            textViewResult.text = ""
            nuevaoperacion = false
        }
        val digit = (view as TextView).text
        textViewResult.append(digit)
    }

    fun onOperatorClick(view: View) {
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val textViewOperation = findViewById<TextView>(R.id.textViewOperation)
        if (!nuevaoperacion) {
            numero1 = textViewResult.text.toString()
            textViewResult.text = "0"
            nuevaoperacion = true
        }
        simbolo = (view as TextView).text.toString()
        textViewOperation.text = "$numero1 $numero2"
    }

    fun onEqualClick(view: View) {
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val textViewOperation = findViewById<TextView>(R.id.textViewOperation)
        numero2 = textViewResult.text.toString()
        val result = when (simbolo) {
            "+" -> numero1.toInt() + numero2.toInt()
            "-" -> numero1.toInt() - numero2.toInt()
            "*" -> numero1.toInt() * numero2.toInt()
            "/" -> numero1.toInt() / numero2.toInt()
            else -> throw IllegalArgumentException("Invalid operator")
        }
        textViewResult.text = result.toString()
        textViewOperation.text = ""
        nuevaoperacion = true
    }

    fun onClearClick(view: View) {
        val textViewResult = findViewById<TextView>(R.id.textViewResult)
        val textViewOperation = findViewById<TextView>(R.id.textViewOperation)
        textViewResult.text = "0"
        textViewOperation.text = ""
        nuevaoperacion = true
    }



    private fun sumar(a: Int, b: Int): Int {
        return a + b
    }

    private fun Restar(a: Int, b: Int): Int {
        return a - b
    }

    private fun multiplicar(a: Int, b: Int): Int {
        return a * b
    }

    private fun dividir(a: Int, b: Int): Int {
        if (b == 0) {
            throw ArithmeticException("Cannot divide by zero")
        }
        return a / b
    }

}
