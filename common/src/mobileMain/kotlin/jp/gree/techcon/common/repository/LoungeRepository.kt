package jp.gree.techcon.common.repository

import jp.gree.techcon.common.datasource.network.Api
import jp.gree.techcon.common.model.Booth
import jp.gree.techcon.common.model.Track
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class LoungeRepository(private val api: Api) {
    fun getBooths(): Flow<List<Booth>> = flow {
        val booths = api.getBooths()
        emit(booths)
    }
}
