package com.junemon.daggerinyourface.core.data.datasource.remote

import com.junemon.daggerinyourface.core.data.datasource.remote.helper.BaseResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.GamesDetailResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.GamesResponse
import com.junemon.daggerinyourface.core.data.datasource.remote.model.RemoteServiceResult
import com.junemon.daggerinyourface.core.data.datasource.remote.retrofit.ApiInterface
import com.junemon.daggerinyourface.core.domain.model.DataHelper
import com.junemon.daggerinyourface.core.domain.model.GamesDetailData
import com.junemon.daggerinyourface.core.util.dto.game.mapToDomain
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject


/**
 * Created by Ian Damping on 17,February,2021
 * Github https://github.com/iandamping
 * Indonesia.
 */
class GameRemoteDataSourceImpl @Inject constructor(
    private val api: ApiInterface,
    private val defaultDispatcher: CoroutineDispatcher
) : BaseResponse(), GameRemoteDataSource {


    override suspend fun getGame(): DataHelper<List<GamesResponse>> {
        return withContext(defaultDispatcher) {
            when (val response = doOneShots { api.getGames() }) {
                is RemoteServiceResult.Error -> {
                    DataHelper.RemoteSourceError(Exception(response.exception))
                }
                is RemoteServiceResult.Success -> {
                    val dataArray = response.data.data
                    when {
                        dataArray.isNullOrEmpty() -> {
                            DataHelper.RemoteSourceEmpty
                        }
                        else -> DataHelper.RemoteSourceValue(dataArray)
                    }
                }
            }
        }
    }

    override suspend fun getDetailGame(gameID: Int): DataHelper<GamesDetailData> {
        return withContext(defaultDispatcher) {
            when (val response = doOneShots { api.getDetailGames(gameID) }) {
                is RemoteServiceResult.Error -> {
                    DataHelper.RemoteSourceError(Exception(response.exception))
                }
                is RemoteServiceResult.Success -> {
                    val data = response.data
                    DataHelper.RemoteSourceValue(data.mapToDomain())
                }
            }
        }
    }


}