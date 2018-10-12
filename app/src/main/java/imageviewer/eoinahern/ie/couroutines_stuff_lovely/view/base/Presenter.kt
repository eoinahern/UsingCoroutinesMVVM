package imageviewer.eoinahern.ie.couroutines_stuff_lovely.view.base


interface Presenter<V : BaseView> {

	fun attachView(view: V)

	fun detachView()

	fun getView(): V?
}