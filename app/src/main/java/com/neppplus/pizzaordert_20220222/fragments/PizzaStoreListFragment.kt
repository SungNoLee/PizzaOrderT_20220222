package com.neppplus.pizzaordert_20220222.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import com.neppplus.pizzaordert_20220222.R
import com.neppplus.pizzaordert_20220222.ViewStoreDetailActivity
import com.neppplus.pizzaordert_20220222.adapters.StoreAdapter
import com.neppplus.pizzaordert_20220222.datas.StoreData
import kotlinx.android.synthetic.main.fragment_pizza_store_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PizzaStoreListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PizzaStoreListFragment : Fragment() {

    val mPizzaStoreList = ArrayList<StoreData>()
    lateinit var mPizzaStoreAdapter : StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pizza_store_list, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    fun setupEvents() {
        pizzaStoreListView.setOnItemClickListener { adapterView, view, position, l ->
            val myIntent = Intent(requireContext(), ViewStoreDetailActivity::class.java)
            // myIntent.putExtra("store", clickedStore)
            startActivity(myIntent)
        }

    }

    fun setValues() {
        mPizzaStoreList.add(StoreData("피자헛", 4.5, "1588-5588", "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"))
        mPizzaStoreList.add(StoreData("파파존스", 3.5, "1577-8080", "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"))
        mPizzaStoreList.add(StoreData("도미노피자", 5.0, "1577-3082", "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"))
        mPizzaStoreList.add(StoreData("피자헛", 4.0, "1577-0077", "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"))

        mPizzaStoreAdapter = StoreAdapter(requireContext(), R.layout.store_list_item, mPizzaStoreList)

        pizzaStoreListView.adapter = mPizzaStoreAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PizzaStoreListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PizzaStoreListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}