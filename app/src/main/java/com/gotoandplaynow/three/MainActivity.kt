package com.gotoandplaynow.three

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.gotoandplaynow.three.model.MainModel
import com.gotoandplaynow.three.viewmodel.MainActivityViewModel
import kotterknife.bindView

class MainActivity : AppCompatActivity() {

    private var mainActivityViewModel: MainActivityViewModel? = null

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

        // create intent to launch detailActivity
        var intent = Intent(applicationContext, DetailActivity::class.java)
        // pass the detail label
        intent.putExtra(AppConstants.EXTRA_TITLE, title)
        // launch activity
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindViewToViewModel()
        initComponents()
    }

    /**
     * this is only to simulate View, ViewModel pattern
     * VIEW
     *  - the ativity is the view and should only deal with the UI
     *  - it should know nothing of the data layer, just display
     *  - it will observe only data changes on the ViewModel
     *
     *  VIEWMODEL
     *  - the ViewModel (MainActivityViewModel) will only deal with the data, fetch update etc.
     *  - since the view is observing data changes from it, it doesn't have to manually notify the View that
     *  something has change for it to update the UI.
     *  - this makes the methods easily testable with mock data.
     */
    private fun bindViewToViewModel () {
        // initialize ViewModel for main activity
        mainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
        // populate dummy data, simulate as if fetched from the web
        mainActivityViewModel?.populateMockData()

        // bind view to the viewmodel for data changes
        mainActivityViewModel?.getMainModel()?.observe(this, Observer {
            // update the UI
            updateUI(it)
        })

        // simulated data change event
        mainActivityViewModel?.updateViewTitle(getString(R.string.btn_page_one_label))
    }

    // this will update the ui depending on data changes
    private fun updateUI (data: MainModel) {
        // simulated view update on data change
        buttonOne.text = data.getViewTitle()
        // output to log to verify event called
        Log.w("onDataChange", "data change event triggered.")
    }

    private fun initComponents () {
        // assign on click events to the three buttons
        buttonOne.setOnClickListener(onButtonClick)
        buttonTwo.setOnClickListener(onButtonClick)
        buttonThree.setOnClickListener(onButtonClick)
    }

}
