package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.model.Property
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.di.PerScreen
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.domain.getproperties.GetPropertiesUseCase
import javax.inject.Inject


@PerScreen
class FundaViewModel @Inject constructor(private val getPropertiesUseCase: GetPropertiesUseCase) : ViewModel() {

	var propertyList: MutableLiveData<List<Property>> = MutableLiveData()
	var propertyError: MutableLiveData<String> = MutableLiveData()

	fun loadPropertyData() {

		getPropertiesUseCase.execute(
				onComplete = { propList ->
					propertyList.postValue(propList)
				},
				onError = {
					propertyError.postValue(it.message)
				}
		)
	}

	fun propertiesList(): LiveData<List<Property>> {
		return propertyList
	}

	fun propertyError() : LiveData<String> =  propertyError


	fun unsubscribe() {
		getPropertiesUseCase.unsubscribe()
	}
}