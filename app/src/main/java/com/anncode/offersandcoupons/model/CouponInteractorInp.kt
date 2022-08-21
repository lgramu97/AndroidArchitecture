package com.anncode.offersandcoupons.model

import com.anncode.offersandcoupons.presenter.CouponPresenter

class CouponInteractorInp(var couponPresenter: CouponPresenter): CouponInteractor {

    private var couponRepository : CouponRepository = CouponRepositoryInp(couponPresenter)

    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}