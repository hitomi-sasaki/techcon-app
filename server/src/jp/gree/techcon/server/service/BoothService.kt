package jp.gree.techcon.server.service

import jp.gree.techcon.common.model.Booth as BoothModel
import jp.gree.techcon.server.entity.Booth

class BoothService {
    suspend fun getAll(): List<BoothModel> {
        // get data from database
        return DatabaseFactory.dbQuery {
            // format data
            return@dbQuery Booth.all().toList().map { booth ->
                BoothModel(
                    booth.id.value.toLong(),
                    booth.title,
                    booth.description
                )
            }
        }
    }
}