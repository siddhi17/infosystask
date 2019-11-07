package com.example.learn.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.learn.adapter.ClickableRow
import com.example.learn.adapter.HomeAdapter
import com.example.learn.helper.InternetUtil
import com.example.learn.helper.applyVerticalWithDividerLinearLayoutManager
import com.example.learn.model.ApiResponse
import com.example.learn.model.FactResponse
import com.example.learn.model.Row
import com.example.learn.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.activity_home.*
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.R



class HomeActivity : AppCompatActivity(), ClickableRow {


    lateinit var homeAdapter: HomeAdapter

    lateinit var homeViewModel: HomeViewModel

    lateinit var observer: Observer<ApiResponse<FactResponse, String>>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.learn.R.layout.activity_home)

        setUpView()

        swipeRefresh.setOnRefreshListener {
            callApi()                 // refresh your list contents somehow
            swipeRefresh.isRefreshing = false   // reset the SwipeRefreshLayout (stop the loading spinner)
        }

    }

    fun setUpView() {


        //init class
        homeViewModel = HomeViewModel()

        //init observer
        initObserver()

        //init rv
        rvHome.applyVerticalWithDividerLinearLayoutManager()

        callApi()

    }

    fun callApi(){

        initObserver()

        if (InternetUtil.isInternetOn()) {
            homeViewModel.getfactsData().observe(this, observer)

        } else {
            waitForInternet()
        }
    }

    fun initObserver() {

        observer = Observer { t ->

            if (t?.response != null) {

                var factResponse = t.response

                if (factResponse?.title != null) {
                    factResponse.rows?.let { displayData(it) }
                } else {
                    rvHome.visibility = View.GONE
                    layNoInternet.visibility = View.GONE
                    proNearBy.visibility= View.GONE
                    layNoData.visibility = View.VISIBLE
                }

            } else {
                Log.e("warning", t?.error!!)
            }
        }
    }


    fun displayData(response: List<Row>) {

        //init adapter
        homeAdapter = HomeAdapter(response, this)
        //set data
        rvHome.adapter = homeAdapter

        rvHome.visibility = View.VISIBLE
        layNoInternet.visibility = View.GONE
        layNoData.visibility = View.GONE
        proNearBy.visibility=View.GONE

    }

    override fun onClickRow(item: Row) {

    }

    private fun waitForInternet() {

        InternetUtil.observe(this, Observer { status ->
            if (status!!) {
                rvHome.visibility = View.VISIBLE
                layNoInternet.visibility = View.GONE
                layNoData.visibility = View.GONE

            } else {
                layNoInternet.visibility = View.VISIBLE
                rvHome.visibility = View.GONE
                layNoData.visibility = View.GONE
                proNearBy.visibility=View.GONE

            }
        })
    }
}
