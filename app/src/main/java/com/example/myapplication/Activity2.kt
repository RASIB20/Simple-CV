package com.example.myapplication
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.SeekBar
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class Activity2: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity2)

        val name:EditText = findViewById(R.id.nametextfield)
        val email:EditText = findViewById(R.id.emailtextfield)
        val domain:EditText = findViewById(R.id.domaintextfield)
        val phone:EditText = findViewById(R.id.numbertextfield)
        val experience:EditText = findViewById(R.id.experiencetextfield)
        val finalDegree:EditText = findViewById(R.id.finaldegreetextfield)

        val intent = intent
        val nameText = intent.getStringExtra("name")
        val emailText = intent.getStringExtra("email")
        val phoneText = intent.getStringExtra("phone")
        val domainText = intent.getStringExtra("domain")
        val experienceText = intent.getIntExtra("experience", 0).toString()
        val finalDegreeText = intent.getStringExtra("finalDegree")

        val okButton: Button = findViewById(R.id.button)
        okButton.setOnClickListener {
            // Finish the current activity to go back to the previous one
            val resultIntent = Intent().apply {
                putExtra("ClearFields",true)
            }
            setResult(RESULT_OK,resultIntent)
            finish()
        }

        name.setText(nameText)
        email.setText(emailText)
        phone.setText(phoneText)
        experience.setText(experienceText)
        domain.setText(domainText)
        finalDegree.setText(finalDegreeText)

    }
}