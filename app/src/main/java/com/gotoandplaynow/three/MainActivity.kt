package com.gotoandplaynow.three

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotterknife.bindView

class MainActivity : AppCompatActivity() {

    // view bindings
    private val buttonOne:Button by bindView(R.id.btn_1)
    private val buttonTwo:Button by bindView(R.id.btn_2)
    private val buttonThree:Button by bindView(R.id.btn_3)

    // Common button click handler
    private val onButtonClick:View.OnClickListener = View.OnClickListener {
        // get detail label by button id
        var title: String = when (it.id) {
            R.id.btn_1 -> getString(R.string.btn_page_one_label)
            R.id.btn_2 -> getString(R.string.btn_page_two_label)
            R.id.btn_3 -> getString(R.string.btn_page_three_label)
            // default
            else -> getString(R.string.btn_page_one_label)
        }

        // create intent to launch detailactivity
        var intent = Intent(applicationContext, DetailActivity::class.java)
        // pass the detail label
        intent.putExtra(AppConstants.EXTRA_TITLE, title)
        // launch activity
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initComponents()
    }

    private fun initComponents () {
        // assign on click events to the three buttons
        buttonOne.setOnClickListener(onButtonClick)
        buttonTwo.setOnClickListener(onButtonClick)
        buttonThree.setOnClickListener(onButtonClick)
    }

}
