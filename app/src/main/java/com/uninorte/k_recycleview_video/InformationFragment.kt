package com.uninorte.k_recycleview_video


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.uninorte.k_recycleview_video.data.User
import com.uninorte.k_recycleview_video.databinding.FragmentInformationBinding

/**
 * A simple [Fragment] subclass.
 */
class InformationFragment : Fragment() {

    lateinit var user: User
    lateinit var mBinding: FragmentInformationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_information, container, false)
        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        user = arguments!!.getParcelable("user")!!
        mBinding.user = user
    }

}
