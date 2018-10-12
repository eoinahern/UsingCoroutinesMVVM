package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.funda

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.R
import imageviewer.eoinahern.ie.couroutines_stuff_lovely.model.Property
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.single_person_layout.*


class PropertyAdapter : RecyclerView.Adapter<PropertyAdapter.PropertyViewHolder>() {

	private var propertyList: MutableList<Property> = mutableListOf()

	override fun onCreateViewHolder(vg: ViewGroup, index: Int): PropertyViewHolder {
		val inflater = LayoutInflater.from(vg.context)
		val view = inflater.inflate(R.layout.single_person_layout, vg, false)
		return PropertyViewHolder(view)
	}

	override fun getItemCount(): Int = propertyList.size

	override fun onBindViewHolder(viewHolder: PropertyViewHolder, index: Int) {
		val property = propertyList[index]
		viewHolder.nameTxt.text = property.AangebodenSindsTekst
		viewHolder.countryTxt.text = property.BronCode
	}

	fun updateList(propertyListIn: List<Property>) {

		if (!this.propertyList.isEmpty())
			this.propertyList.clear()

		propertyList.addAll(propertyListIn)
		notifyItemRangeInserted(0, propertyListIn.size)
	}


	inner class PropertyViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer
}