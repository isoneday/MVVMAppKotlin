package com.imastudio.mvvmapp.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.imastudio.mvvmapp.model.modelwisata.DataItem
import com.imastudio.mvvmapp.model.modelwisata.ResponseWisata
import com.imastudio.mvvmapp.network.InitRetrofit
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WisataViewModel : ViewModel() {
    private val data = MutableLiveData<List<DataItem?>?>()
    var status = MutableLiveData<Boolean>()
    var progress = MutableLiveData<Int>()
    var showMsg = MutableLiveData<String>()

    init {
        getDataWisata()
    }

    private fun getDataWisata() {
        status.value = true
        progress.value = 0
        InitRetrofit.getInstanceWisata().getWisata().enqueue(
            object : Callback<ResponseWisata> {
                override fun onFailure(call: Call<ResponseWisata>, t: Throwable) {
                    status.value = false
                    progress.value = 1
                    showMsg.value = t.localizedMessage
                }

                override fun onResponse(
                    call: Call<ResponseWisata>,
                    response: Response<ResponseWisata>
                ) {
                    progress.value = 1
                    if (response.isSuccessful) {
                        status.value = false
                        var statuscode = response.body()?.statusCode
                        var msg = response.body()?.message
                        if (statuscode == 200) {
                            data.value = response.body()?.data
                            showMsg.value = msg

                        } else {
                            status.value = true
                            showMsg.value = msg

                        }
                    }

                }

            }
        )
    }

    fun setMsg(): MutableLiveData<String> {
        return showMsg
    }

    fun setDataToView(): MutableLiveData<List<DataItem?>?> {
        return data
    }

    fun setStatus(): MutableLiveData<Boolean> {
        return status
    }

    fun setProgress(): MutableLiveData<Int> {
        return progress
    }
}