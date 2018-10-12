package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.base

open class BasePresenter<V : BaseView> : Presenter<V> {

	private var v : V? = null

	override fun attachView(view: V) {
		v = view
	}

	override fun detachView() {
		v = null
	}

	override fun getView(): V? {
		return this.v
	}





}