package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SecondActivity : AppCompatActivity() {
    private var mReply: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        mReply = findViewById(R.id.editText_second)
        val intent = intent
        val message = intent.getStringExtra("HUI")
        val textView :TextView = findViewById(R.id.text_message)
        textView.setText(message)
    }

    fun returnReply(view: View) {
        val reply = mReply!!.text.toString()
        val replyIntent = Intent()
        replyIntent.putExtra("HUI2", reply)
        setResult(RESULT_OK,replyIntent)
        finish()
    }
}