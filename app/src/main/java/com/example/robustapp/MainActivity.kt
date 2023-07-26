package com.example.robustapp
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val DELAYTIME = 2000L // Delay time in milliseconds (2 seconds)

    private fun isValidCredentials(username: String, password: String): Boolean {
        // Perform your login validation logic here
        // You can check against a local database, call an API, or use any other authentication method
        // Return true if the credentials are valid, false otherwise
        return username == "Raj@infomerica123" && password == "123456"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val editTextUsername = findViewById<EditText>(R.id.editTextUsername)
        val editTextPassword = findViewById<EditText>(R.id.editTextPassword)
        val buttonLogin = findViewById<Button>(R.id.buttonLogin)
        val forgotTextView = findViewById<TextView>(R.id.forgotTextView)

        buttonLogin.setOnClickListener {
            val username = editTextUsername.text.toString()
            val password = editTextPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please enter username and password", Toast.LENGTH_SHORT)
                    .show()
            } else {
                // Perform login authentication here
                if (isValidCredentials(username, password)) {
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()

                    // Add a delay using a Handler
                    Handler().postDelayed({
                        // Navigate to the next activity using an Intent
                        // Create an Intent to navigate to another activity
                        val intent = Intent(this, SecondActivity::class.java)
                        // Start the activity
                        startActivity(intent)
                    }, DELAYTIME)
                } else {
                    Toast.makeText(this, "Invalid username or password", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
