package com.catnip.animemunity.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
open class BaseBottomSheetFragment<B : ViewBinding>(
    val bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B
) : BottomSheetDialogFragment() {

    protected lateinit var binding: B

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = bindingFactory(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeData()
        initView()
    }

    open fun initView() {

    }

    open fun observeData() {

    }
}

abstract class BaseVMBottomSheetFragment<B : ViewBinding, VM : ViewModel>(bindingFactory: (LayoutInflater, ViewGroup?, Boolean) -> B) :
    BaseBottomSheetFragment<B>(bindingFactory) {

    abstract val viewModel: VM
}