package com.google.vitaly.apprxbinding.ui

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.vitaly.apprxbinding.R
import com.google.vitaly.apprxbinding.mvp.presenter.MainActitvityPresenter
import com.google.vitaly.apprxbinding.mvp.view.IMainActitityView
import com.jakewharton.rxbinding3.InitialValueObservable
import com.jakewharton.rxbinding3.widget.textChanges
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_main.*
import timber.log.Timber


class MainActivity : AppCompatActivity(), IMainActitityView {

  //  val preseter=MainActitvityPresenter(this)
    //val changeText: Observable<CharSequence>?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       val preseter=MainActitvityPresenter(this)
        getTextFromEt(preseter)
    }

    private fun getTextFromEt(preseter: MainActitvityPresenter) {
        et_enterText
            .textChanges()
            .map {
                it.toString()
            }
            .distinctUntilChanged()
            .subscribe({
                preseter.etCangetext(it)
            }, {
                preseter.etCangetext("Error")
            })
    }

    override fun updateTextView(string: String?) {
        string?.let {
            if(!it.equals("Error")){
            tv_outText.text=it}
            else {
                tv_outText.setTextColor(Color.RED)
            tv_outText.text=it}
            }
    }
}
