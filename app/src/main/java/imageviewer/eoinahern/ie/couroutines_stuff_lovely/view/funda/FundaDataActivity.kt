package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import dagger.android.AndroidInjection
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.R
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.data.model.Property
import kotlinx.android.synthetic.main.activity_funda_data.*


import javax.inject.Inject

class FundaDataActivity : AppCompatActivity() {

	@Inject
	lateinit var adapter: PropertyAdapter

	@Inject
	lateinit var viewModelFactory: FundaViewModelFactory

	lateinit var viewModel: FundaViewModel

	override fun onCreate(savedInstanceState: Bundle?) {
		AndroidInjection.inject(this)
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_funda_data)
		setUpRecycler()
		initViewModel()
		loadData()
	}

	private fun initViewModel() {

		viewModel = ViewModelProviders.of(this, viewModelFactory).get(FundaViewModel::class.java)


		viewModel.propertiesList().observe(this,
				Observer<List<Property>> {
					hideLoading()
					updateRecycler(it)
				})

		viewModel.propertyError().observe(this,
				Observer<String>{
					if(!it.isNullOrEmpty()) {
						hideLoading()
						showError()
					}
				})
	}

	private fun loadData() {
		showLoading()
		viewModel.loadPropertyData()
	}

	private fun setUpRecycler() {
		recycler.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
		recycler.adapter = adapter
	}

	private fun updateRecycler(propertyList: List<Property>) {
		adapter.updateList(propertyList)
	}

	private fun showError() {
		errorTxt.visibility = View.VISIBLE
	}

	private fun showLoading() {
		progressbar.visibility = View.VISIBLE
	}

	private fun hideLoading() {
		progressbar.visibility = View.GONE
	}

	override fun onDestroy() {
		super.onDestroy()
		viewModel.unsubscribe()
	}
}
