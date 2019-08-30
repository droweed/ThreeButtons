package com.gotoandplaynow.three

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotterknife.bindView

class DetailActivity : AppCompatActivity() {

    // view bindings
    private val tvLabel: TextView by bindView(R.id.tv_label)
    // label value
    private var title:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        handleIntent()
        initComponents()
    }

    private fun handleIntent () {
        // get the passed intent
        title = intent.extras?.getString(AppConstants.EXTRA_TITLE)
    }

    private fun initComponents () {
        // assign title value to TextView
        tvLabel.text = title
    }

}
