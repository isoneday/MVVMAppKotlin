package com.imastudio.mvvmapp.view


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

import com.imastudio.mvvmapp.R
import com.imastudio.mvvmapp.adapter.AdapterWisata
import com.imastudio.mvvmapp.model.modelwisata.DataItem
import com.imastudio.mvvmapp.viewmodel.WisataViewModel
import kotlinx.android.synthetic.main.fragment_wisata.*

/**
 * A simple [Fragment] subclass.
 */
class WisataFragment : Fragment() {

    private lateinit var viewModel:WisataViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wisata, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(WisataViewModel::class.java)
        progressbar.visibility= View.VISIBLE
        viewModel.setStatus().observe(this, Observer {
            it-> if (it==false){
            listWisata.visibility = View.VISIBLE
            textStatus.visibility =View.GONE

        }else{
            listWisata.visibility = View.GONE
            textStatus.visibility =View.VISIBLE
        }
        })

        viewModel.setDataToView().observe(this, Observer {
            it-> it.let { showData(it) }
        })

        viewModel.setProgress().observe(this, Observer {
            it->if (it==0){
            progressbar.visibility=View.VISIBLE
        }else{
            progressbar.visibility=View.GONE

        }
        })
    }

    private fun showData(it: List<DataItem?>?) {
        listWisata.adapter =AdapterWisata(activity,it)
    }


}
