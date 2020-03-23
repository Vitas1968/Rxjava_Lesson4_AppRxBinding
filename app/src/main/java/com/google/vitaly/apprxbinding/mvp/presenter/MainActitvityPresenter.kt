package com.google.vitaly.apprxbinding.mvp.presenter

import com.google.vitaly.apprxbinding.mvp.view.IMainActitityView
import io.reactivex.Observable
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MainActitvityPresenter(val view:IMainActitityView?) {

    fun etCangetext(string: String?){
       string?.let { view?.updateTextView(it) }

    }
}