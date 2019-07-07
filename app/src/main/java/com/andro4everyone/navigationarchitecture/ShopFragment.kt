package com.andro4everyone.navigationarchitecture

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavDirections
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_shop.*
import kotlin.random.Random

private val NavDirections.setProductCount: Unit
    get() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

class ShopFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_shop, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btnAboutId.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.aboutDestinationId)
        }
    }
}
