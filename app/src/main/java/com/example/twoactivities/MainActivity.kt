package com.example.twoactivities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val TEXT_REQUEST = 1
class MainActivity : AppCompatActivity() {
    private var mMessageEditText: EditText? = null
    private var mReplyHeadTextView: TextView? = null
    private var mReplyTextView: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        mMessageEditText = findViewById(R.id.editText_main)
        mReplyHeadTextView = findViewById(R.id.text_header_reply)
        mReplyTextView = findViewById(R.id.text_message_reply)
    }

    fun launchSecondActivity(view: View) {
        val intent = Intent(this, SecondActivity::class.java)
        val message = mMessageEditText!!.text.toString()
        intent.putExtra("HUI", message);
        startActivityForResult(intent, TEXT_REQUEST);
    }

    override fun onActivityResult(requestCode: Int,resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                val reply: String? = data?.getStringExtra("HUI2")
                mReplyHeadTextView?.setVisibility(View.VISIBLE)
                mReplyTextView?.setText(reply)
                mReplyTextView?.setVisibility(View.VISIBLE)
            }
        }
    }
}