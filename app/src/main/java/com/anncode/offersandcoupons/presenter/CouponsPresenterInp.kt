package com.anncode.offersandcoupons.presenter

import com.anncode.offersandcoupons.model.Coupon
import com.anncode.offersandcoupons.model.CouponInteractor
import com.anncode.offersandcoupons.model.CouponInteractorInp
import com.anncode.offersandcoupons.view.CouponView


class CouponsPresenterInp(var couponView: CouponView): CouponPresenter {

    private var couponInteractor: CouponInteractor = CouponInteractorInp(this)

    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }

    override fun showCoupons(coupons: List<Coupon>?) {
        couponView.showCoupons(coupons)
    }

}