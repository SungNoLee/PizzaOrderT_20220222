package com.neppplus.pizzaordert_20220222.fragments

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.neppplus.pizzaordert_20220222.R
import kotlinx.android.synthetic.main.fragment_my_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PizzaStoreListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyProfileFormat : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

    fun setupEvents() {

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQ_CODE_NICKNAME) {
            if (resultCode == Activity.RESULT_OK) {
                val nickname = data!!.getShortExtra("nick")
                txtNickname.text = nickname
            }
        }
    }
}