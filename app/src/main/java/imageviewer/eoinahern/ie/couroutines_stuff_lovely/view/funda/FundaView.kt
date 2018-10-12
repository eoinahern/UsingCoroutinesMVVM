package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda

import imageviewer.eoinahern.ie.couroutines_stuff_lovely.model.Property
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.base.BaseView


interface FundaView : BaseView {

	fun showLoading()

	fun hideLoading()

	fun updateRecycler(propertyList: List<Property>)

	fun showError()
}