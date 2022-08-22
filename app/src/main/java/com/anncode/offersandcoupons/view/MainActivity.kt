package com.anncode.offersandcoupons.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.databinding.ActivityMainBinding
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.viewModel.CouponViewModel

class MainActivity : AppCompatActivity() {

    private var couponsViewModel: CouponViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        //View
        setupBindings(savedInstanceState)


    }

    fun setupBindings(savedInstanceState: Bundle?) {
        var activityMainBinding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)
        couponsViewModel = ViewModelProviders.of(this).get(CouponViewModel::class.java)
        activityMainBinding.model = couponsViewModel
    }

    fun setupListUpdate() {
        // Call coupons
        couponsViewModel?.callCoupons()
        // Get coupons -> list<Coupon>
        couponsViewModel?.getCoupons()?.observe(this, Observer { coupons: List<Coupon> ->
            Log.w(
                "COUPON",
                coupons[0].title
            )
            couponsViewModel?.setCouponsInRecycleyAdapter(coupons)
        })
    }

}

