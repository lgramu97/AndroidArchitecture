package com.anncode.offersandcoupons.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.anncode.offersandcoupons.R
import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.presenter.CouponPresenter
import com.anncode.offersandcoupons.presenter.CouponsPresenterInp
import java.lang.Exception

class MainActivity : AppCompatActivity(), CouponView {

    private var couponPresenter : CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        couponPresenter = CouponsPresenterInp(this)

        //View
        rvCoupons = findViewById(R.id.rvCoupons)
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
        //View



    }

    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }

    override fun showCoupons(coupons: List<Coupon>?) {
        try {
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon )
        }catch (e: Exception){
            e.printStackTrace()
        }

    }
}
