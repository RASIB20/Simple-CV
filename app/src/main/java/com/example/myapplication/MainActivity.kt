package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.CheckBox
import android.widget.SeekBar
import android.widget.Spinner
import com.google.android.material.textfield.TextInputEditText
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val checkedItems = mutableListOf<String>()
        val spinner: Spinner = findViewById(R.id.domainspinner)
        val name:TextInputEditText = findViewById(R.id.nameInputfield)
        val email:TextInputEditText = findViewById(R.id.emailinputfield)
        val phone:TextInputEditText = findViewById(R.id.numberinputfield)
        val submitt:Button=findViewById(R.id.submitbutton)
        val cs:CheckBox=findViewById(R.id.cscheckBox)
        val cys:CheckBox=findViewById(R.id.cyscheckBox2)
        val avm:CheckBox=findViewById(R.id.avmcheckBox3)
        val experienceseekbar:SeekBar = findViewById(R.id.experienceseekBar)
        var experience:String;

        ArrayAdapter.createFromResource(
            this,
            R.array.listItems,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        submitt.setOnClickListener {
            val exp = experienceseekbar.progress

            if (cs.isChecked) {
                checkedItems.add(cs.text.toString())
            }
            if (cys.isChecked) {
                checkedItems.add(cys.text.toString())
            }
            if (avm.isChecked) {
                checkedItems.add(avm.text.toString())
            }

            val checkedItemsText = checkedItems.joinToString(", ")

            val intent=Intent(this,Activity2::class.java)
            intent.putExtra("name",name.text.toString())
            intent.putExtra("email",email.text.toString())
            intent.putExtra("phone",phone.text.toString())
            intent.putExtra("experience",exp)
            intent.putExtra("finalDegree",checkedItemsText)
            intent.putExtra("domain",checkedItemsText)
            startActivity(intent)
        }
    }
}