package com.hubtwork.clean_android.presentation.ui.util

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import java.util.concurrent.atomic.AtomicBoolean

/**
 * @author hubtwork (alenheo)
 * @contacts hubtwork@gmail.com
 */
/**
 * references by PRND Company's eventFlow
 * (https://github.com/PRNDcompany/MvvmEventSample/blob/main/app/src/main/java/kr/co/prnd/mvvmeventsample/step6/EventFlow.kt)
 */
// EventFlow
interface EventFlow<out T>: Flow<T> {
    companion object {
        const val DEFAULT_REPLAY: Int = 3
    }
}
interface MutableEventFlow<T>: EventFlow<T>, FlowCollector<T>

internal class EventFlowSlot<T>(val event: T) {
    private val isConsumed: AtomicBoolean = AtomicBoolean(false)
    fun consume(): Boolean = isConsumed.getAndSet(true)
}
// EventFlow Wrapper
internal class EventFlowImpl<T>(
    replay: Int
): MutableEventFlow<T> {
    // Internal Shared flow for sustain unconsumed event
    private val flow: MutableSharedFlow<EventFlowSlot<T>> = MutableSharedFlow(replay = replay)

    override suspend fun collect(collector: FlowCollector<T>) = flow
        .collect { slot ->
            if (!slot.consume()) collector.emit(slot.event)
        }

    override suspend fun emit(value: T) {
        // pass slot to internal flow
        flow.emit(EventFlowSlot(value))
    }
}

private class ReadOnlyEventFlow<T>(flow: EventFlow<T>): EventFlow<T> by flow

@Suppress("FunctionName")
fun <T> MutableEventFlow(
    replay: Int = EventFlow.DEFAULT_REPLAY
): MutableEventFlow<T> = EventFlowImpl(replay)
fun <T> MutableEventFlow<T>.asEventFlow(): EventFlow<T> = ReadOnlyEventFlow(this)


