package com.anncode.offersandcoupons.model

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CouponRepositoryInp() : CouponRepository {

    private var coupons: MutableLiveData<List<Coupon>> = MutableLiveData<List<Coupon>>()
    //Subject MutableLiveDAta
    //Observer List Coupon
    //Change list coupon -> MutableLiveData
    //observe.

    override fun getCoupons(): MutableLiveData<List<Coupon>> {
        return coupons
    }

    //Conection
    override fun callCouponsAPI() {
        //Controller
        var couponsList: ArrayList<Coupon>? = ArrayList<Coupon>()
        val apiAdapter = ApiAdapter()
        val apiService = apiAdapter.getClientService()
        val call = apiService.getCoupons()

        call.enqueue(object : Callback<JsonObject> {
            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
                Log.e("ERROR: ", t.message)
                t.stackTrace
            }

            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
                val offersJsonArray = response.body()?.getAsJsonArray("offers")
                offersJsonArray?.forEach { jsonElement: JsonElement ->
                    val jsonObject = jsonElement.asJsonObject
                    val coupon = Coupon(jsonObject)
                    couponsList?.add(coupon)
                }
                //View
                coupons.value = couponsList
            }
        })
        //Controller
    }


}