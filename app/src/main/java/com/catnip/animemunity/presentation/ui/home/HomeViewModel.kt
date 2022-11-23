package com.catnip.animemunity.presentation.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.catnip.animemunity.R
import com.catnip.animemunity.base.wrapper.Resource
import com.catnip.animemunity.data.repository.AnimeRepository
import com.catnip.animemunity.presentation.ui.webdetail.uimodel.HomeItem
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
Written with love by Muhammad Hermas Yuda Pamungkas
Github : https://github.com/hermasyp
 **/
class HomeViewModel(private val animeRepository: AnimeRepository) : ViewModel() {

    val homeDataResult = MutableLiveData<Resource<List<HomeItem>>>()

    fun getHomeData() {
        viewModelScope.launch(Dispatchers.IO) {
            homeDataResult.postValue(Resource.Loading())
            val recentReleaseData = animeRepository.getRecentReleaseAnimeList()
            val sectionTopAiringAnimeList = animeRepository.getTopAiringList()
            val sectionAnimeList = animeRepository.getAnimeList()

            val homeItems = mutableListOf<HomeItem>()
            homeItems.apply {
                recentReleaseData.payload?.let {
                    add(HomeItem.HomeHeaderItem(it.random()))
                }
                sectionTopAiringAnimeList.payload?.let {
                    add(HomeItem.HomeSectionItem(R.string.top_airing_section, it))
                }
                recentReleaseData.payload?.let {
                    add(HomeItem.HomeSectionItem(R.string.recent_release_section, it))
                }
                sectionAnimeList.payload?.let {
                    add(HomeItem.HomeSectionItem(R.string.anime_list_section, it))
                }
            }
            if (homeItems.isNotEmpty()) {
                homeDataResult.postValue(Resource.Success(homeItems))
            } else {
                homeDataResult.postValue(Resource.Empty())
            }
        }
    }
}