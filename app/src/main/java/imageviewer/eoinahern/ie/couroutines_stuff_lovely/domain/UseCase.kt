package imageviewer.eoinahern.ie.couroutines_stuff_lovely.domain

import android.util.Log
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.ioDispatcher
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.uiDispatcher
import kotlinx.coroutines.experimental.*
import kotlin.coroutines.experimental.CoroutineContext


abstract class UseCase<T> {

	private var job = Job()

	protected abstract suspend fun executeonBackground(): T

	fun execute(onComplete: (T) -> Unit, onError: (Throwable) -> Unit) {

		job.cancel()
		job = Job()

		GlobalScope.launch(uiDispatcher + job) {

			try {

				val result = withContext(ioDispatcher) {
					executeonBackground()
				}

				onComplete.invoke(result)

			} catch (e: CancellationException) {
				Log.d("UseCase", "canceled by user")
			} catch (e: Exception) {
				onError.invoke(e)
			}
		}
	}

	protected suspend fun <k> background(context: CoroutineContext = uiDispatcher, block: () -> k): Deferred<k> {
		return GlobalScope.async(context + job) {
			block.invoke()
		}
	}

	fun unsubscribe() {
		job.cancel()
	}


}