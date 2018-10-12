package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda

import imageviewer.eoinahern.ie.couroutines_stuff_lovely.domain.getproperties.GetPropertiesUseCase
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.base.BasePresenter


class FundaPresenter constructor(private val getPropertiesUseCase: GetPropertiesUseCase) : BasePresenter<FundaView>() {

	fun getDataFromApi() {

		getPropertiesUseCase.execute(
				onComplete = { propertyList ->
					getView()?.hideLoading()
					getView()?.updateRecycler(propertyList)

				},
				onError = {
					getView()?.hideLoading()
					getView()?.showError()
				})
	}


	override fun detachView() {
		super.detachView()
		getPropertiesUseCase.unsubscribe()
	}
}