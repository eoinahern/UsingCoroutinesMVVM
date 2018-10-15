package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import dagger.android.AndroidInjection
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.R
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.model.Property

import kotlinx.android.synthetic.main.activity_funda_data.*
import javax.inject.Inject

class FundaDataActivity : AppCompatActivity(), FundaView {


	@Inject
	lateinit var adapter: PropertyAdapter

	@Inject
	lateinit var presenter: FundaPresenter

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_funda_data)
		setUpRecycler()
		presenter.attachView(this)

		loadData()
	}

	private fun loadData() {
		showLoading()
		presenter.getDataFromApi()
	}

	private fun setUpRecycler() {
		recycler.layoutManager = LinearLayoutManager(this)
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
