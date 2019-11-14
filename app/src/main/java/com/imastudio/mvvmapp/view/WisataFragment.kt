package com.imastudio.mvvmapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.imastudio.mvvmapp.R
import com.imastudio.mvvmapp.adapter.AdapterWisata
import com.imastudio.mvvmapp.databinding.FragmentWisataBinding
import com.imastudio.mvvmapp.model.modelwisata.DataItem
import com.imastudio.mvvmapp.viewmodel.WisataViewModel
import kotlinx.android.synthetic.main.fragment_wisata.*
import org.jetbrains.anko.support.v4.toast

/**
 * A simple [Fragment] subclass.
 */
class WisataFragment : Fragment() {

    private lateinit var viewModel: WisataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val dataBinding = DataBindingUtil.inflate<FragmentWisataBinding>(
            inflater,R.layout.fragment_wisata, container, false)
        // Inflate the layout for this fragment
        val v = dataBinding.root
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WisataViewModel::class.java)

        progressbar.visibility = View.VISIBLE
        viewModel.setStatus().observe(this, Observer { it ->
            if (it == false) {
                listWisata.visibility = View.VISIBLE
                textStatus.visibility = View.GONE

            } else {
                listWisata.visibility = View.GONE
                textStatus.visibility = View.VISIBLE
            }
        })

        viewModel.setDataToView().observe(this, Observer { it ->
            it.let { showData(it) }
        })

        viewModel.setProgress().observe(this, Observer {
            if (it == 0) {
                progressbar.visibility = View.VISIBLE
            } else {
                progressbar.visibility = View.GONE

            }
        })
        viewModel.setMsg().observe(this, Observer {
            toast(it)
        })
    }

    private fun showData(it: List<DataItem?>?) {
        listWisata.adapter = AdapterWisata(activity, it)
    }


}
