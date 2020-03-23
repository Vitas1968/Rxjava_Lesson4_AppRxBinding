package com.google.vitaly.apprxbinding.mvp.presenter

import com.google.vitaly.apprxbinding.mvp.view.IMainActitityView


class MainActitvityPresenter(val view:IMainActitityView?) {

    fun etCangetext(string: String?){
       string?.let { view?.updateTextView(it) }
    }

    fun dispose(){
        view?.let { it.dispose() }

    }
}