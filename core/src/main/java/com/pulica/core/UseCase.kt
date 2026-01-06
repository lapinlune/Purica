package com.pulica.core

import kotlinx.coroutines.flow.Flow

// Removed 'out' keyword from ReturnType to resolve variance issue
abstract class UseCase<ReturnType, in Params> where ReturnType : Any {

    protected abstract fun run(params: Params): Flow<Resource<ReturnType>>

    operator fun invoke(params: Params): Flow<Resource<ReturnType>> = run(params)
}
