package com.imastudio.mvvmapp.view

import android.Manifest
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.imastudio.mvvmapp.R
import com.imastudio.mvvmapp.helper.DownloadFile
import com.imastudio.mvvmapp.helper.Helper
import com.imastudio.mvvmapp.helper.Helper.Companion.DATAWISATA
import com.imastudio.mvvmapp.model.modelwisata.DataItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail_wisata.*
import org.jetbrains.anko.act
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import pub.devrel.easypermissions.EasyPermissions

class DetailWisataActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    var data: DataItem? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_wisata)
        data = intent.getParcelableExtra<DataItem>(DATAWISATA)

        Picasso.get().load(data?.gambar)
            .placeholder(R.drawable.empty)
            .error(R.drawable.empty)
            .into(detailImg)
        detailJdl.text = data?.namaTempat
        detailDesk.text = data?.deskripsi
        btndownload.onClick {

            if (Helper.checkSdCard()) {
                if (EasyPermissions.hasPermissions(
                        this@DetailWisataActivity, Manifest.permission.WRITE_EXTERNAL_STORAGE
                    )
                ) {
//                            DownloadFile

                    var file = DownloadFile(this@DetailWisataActivity)
                    file.execute(data?.gambar)
                } else {
                    EasyPermissions.requestPermissions(
                        this@DetailWisataActivity, "aplikasi membutuhkan permission untk akses",
                        1,
                        Manifest.permission.READ_EXTERNAL_STORAGE
                    )
                }
            } else {
                toast("sd card tidak ditemukan")
            }
        }

    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(
            requestCode, permissions, grantResults,
            this
        )
    }


    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>?) {
        toast("permission tidak dizinkan")
    }

    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>?) {
        toast("permission dizinkan")
        var file = DownloadFile(this)
        file.execute(data?.gambar)
    }


}
