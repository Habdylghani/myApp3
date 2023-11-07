package com.example.myapp3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var etVersion: EditText
    private lateinit var etCodeName: EditText
    private lateinit var btnAdd: Button
    private lateinit var tableLayout: TableLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etVersion = findViewById(R.id.etVersion)
        etCodeName = findViewById(R.id.etCodeName)
        btnAdd = findViewById(R.id.btnAdd)
        tableLayout = findViewById(R.id.tableLayout)

        addRow("Android 12", "Snow Cone")
        addRow("Android 11", "Red Velvet")

        btnAdd.setOnClickListener {
            val version = etVersion.text.toString()
            val codeName = etCodeName.text.toString()

            if (version.isNotEmpty() && codeName.isNotEmpty()) {
                addRow(version, codeName)

                etVersion.text.clear()
                etCodeName.text.clear()
            }
        }
    }

    private fun addRow(version: String, codeName: String) {
        val newRow = TableRow(this)

        val versionLabel = TextView(this)
        versionLabel.text = "Android Version:"
        val codeNameLabel = TextView(this)
        codeNameLabel.text = "Code Name:"

        val versionTextView = EditText(this)
        versionTextView.setText(version)
        val codeNameTextView = EditText(this)
        codeNameTextView.setText(codeName)

        newRow.addView(versionLabel)
        newRow.addView(versionTextView)
        newRow.addView(codeNameLabel)
        newRow.addView(codeNameTextView)

        tableLayout.addView(newRow)
    }

}
