package jp.gree.techcon.common.usecase

import jp.gree.techcon.common.CommonModule
import jp.gree.techcon.common.repository.LoungeRepository
import jp.gree.techcon.common.util.wrap
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.erased.instance

class LoungeService: KodeinAware {
    override val kodein: Kodein by lazy { CommonModule.kodein }
    private val repository: LoungeRepository by kodein.instance()
    fun get() = repository.getBooths().wrap()
}
