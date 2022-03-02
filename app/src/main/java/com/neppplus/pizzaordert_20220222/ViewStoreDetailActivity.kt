package com.neppplus.pizzaordert_20220222

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermissionActivity
import com.gun0912.tedpermission.normal.TedPermission
import com.neppplus.pizzaordert_20220222.datas.StoreData
import kotlinx.android.synthetic.main.activity_view_store_detail.*

class ViewStoreDetailActivity : AppCompatActivity() {

    lateinit var mStoreData : StoreData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_store_detail)
        mStoreData = intent.getSerializableExtra("store") as StoreData
        setupEvents()
        setValues()
    }

    fun setupEvents() {

        val pl = object : PermissionListener {
            override fun onPermissionGranted() {
                val myUri = Uri.parse("tel:${mStoreData.phoneNum}")
                val myIntent = Intent(Intent.ACTION_CALL, myUri)
                startActivity(myIntent)
            }
            override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {
                Toast.makeText(this@ViewStoreDetailActivity, "통화권한이 없습니다.", Toast.LENGTH_SHORT).show()
            }
        }

//        권한 관련 변수를, 화면이 만들어질때 한번만 세팅.
        btnCall.setOnClickListener {
            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }
    }

    fun setValues() {
        Glide.with(this).load(mStoreData.logoImageURL).into(imgLogo)

        txtStoreName.text = mStoreData.name

        txtPhoneNumber.text = mStoreData.phoneNum

        ratingBar.rating = mStoreData.rating.toFloat()

        txtRating.text = "(${mStoreData.rating})"

    }
}