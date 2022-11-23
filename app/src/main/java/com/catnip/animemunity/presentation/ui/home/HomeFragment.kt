package com.catnip.animemunity.presentation.ui.home

import androidx.core.view.isVisible
import com.catnip.animemunity.R
import com.catnip.animemunity.base.BaseViewModelFragment
import com.catnip.animemunity.base.wrapper.Resource
import com.catnip.animemunity.databinding.FragmentHomeBinding
import com.catnip.animemunity.presentation.adapter.HomeAdapter
import com.catnip.animemunity.presentation.ui.webdetail.uimodel.HomeItem
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment :
    BaseViewModelFragment<FragmentHomeBinding, HomeViewModel>(FragmentHomeBinding::inflate) {

    override val viewModel: HomeViewModel by viewModel()

    private val adapter: HomeAdapter by lazy {
        HomeAdapter()
    }

    override fun initView() {
        super.initView()
        activity?.title = getString(R.string.title_anime_list)
        binding.rvHome.adapter = adapter
        viewModel.getHomeData()
    }

    override fun observeData() {
        super.observeData()
        viewModel.homeDataResult.observe(this) {
            when (it) {
                is Resource.Empty -> showEmptyData()
                is Resource.Error -> {
                    showError()
                    setErrorMessage(it.exception?.message.orEmpty())
                }
                is Resource.Loading -> showLoading()
                is Resource.Success -> showData(it.payload)
            }
        }
    }

    private fun showLoading() {
        binding.rvHome.isVisible = false
        binding.tvErrorHome.isVisible = false
        binding.pbHome.isVisible = true
    }

    private fun showError() {
        binding.rvHome.isVisible = false
        binding.pbHome.isVisible = false
        binding.tvErrorHome.isVisible = true
    }

    private fun showData(data: List<HomeItem>?) {
        binding.rvHome.isVisible = true
        binding.pbHome.isVisible = false
        binding.tvErrorHome.isVisible = false
        data?.let { adapter.setItems(it) }
    }

    private fun showEmptyData() {
        showError()
        setErrorMessage(getText(R.string.text_empty_data).toString())
    }

    private fun setErrorMessage(msg: String) {
        binding.tvErrorHome.text = msg
    }
}