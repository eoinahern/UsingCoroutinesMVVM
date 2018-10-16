package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda


import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.PerScreen
import javax.inject.Inject

@PerScreen
class FundaViewModelFactory @Inject constructor(private val fundaViewModel: FundaViewModel) : ViewModelProvider.Factory {

	override fun <T : ViewModel?> create(modelClass: Class<T>): T {

		if (modelClass.isAssignableFrom(FundaViewModel::class.java)) {
			return fundaViewModel as T
		}

		throw IllegalAccessException("unknown viewmodel class")
	}
}