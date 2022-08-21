package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon

interface CouponPresenter {
    //Presenter
    fun getCoupons()

    //View
    fun showCoupons(coupons: List<Coupon>?)
}