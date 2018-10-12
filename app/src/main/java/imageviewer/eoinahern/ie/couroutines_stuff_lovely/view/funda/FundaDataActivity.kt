package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.R
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.api.ApiHelper
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.domain.getproperties.GetPropertiesUseCase
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.ioDispatcher
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.model.Property
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.uiDispatcher
import kotlinx.android.synthetic.main.activity_funda_data.*
import kotlinx.coroutines.experimental.*

class FundaDataActivity : AppCompatActivity(), FundaView {

	lateinit var adapter: PropertyAdapter
	lateinit var presenter: FundaPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_funda_data)
		setUpRecycler()
		presenter = FundaPresenter(GetPropertiesUseCase(ApiHelper.getInstance()))
		presenter.attachView(this)

		loadData()
	}

	private fun loadData() {
		showLoading()
		presenter.getDataFromApi()
	}

	private fun setUpRecycler() {
		recycler.layoutManager = LinearLayoutManager(this)
		adapter = PropertyAdapter()
		recycler.adapter = adapter
	}

	override fun updateRecycler(propertyList: List<Property>) {
		adapter.updateList(propertyList)
	}

	override fun showError() {
		hideLoading()
		errorTxt.visibility = View.VISIBLE
	}

	override fun showLoading() {
		progressbar.visibility = View.VISIBLE
	}

	override fun hideLoading() {
		progressbar.visibility = View.GONE
	}

	override fun onDestroy() {
		super.onDestroy()
		presenter.detachView()
	}
}
