package com.qxj.conclusion.MVPDevelop.MVP

import android.os.Bundle
import com.qxj.conclusion.AppConclusionActivity
import com.qxj.conclusion.MVPDevelop.View.IView

abstract class BaseActivity : AppConclusionActivity(), IView {

    private val mAllPresenter = HashSet<IPresenter<*>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())

        addPresenters()

        getPresenters().forEach { it.onCreate(intent)}

    }


    private fun addPresenters() {
        getPresenters().forEach { mAllPresenter.add(it) }
    }

    open fun getPresenters(): MutableList<IPresenter<*>>{
        return mutableListOf(mPresenter)
    }

    override fun onStart() {
        super.onStart()
        mAllPresenter.forEach { it.onStart() }
    }

    override fun onResume() {
        super.onResume()
        mAllPresenter.forEach { it.onResume() }
    }

    override fun onPause() {
        super.onPause()
        mAllPresenter.forEach { it.onPause() }
    }

    override fun onStop() {
        super.onStop()
        mAllPresenter.forEach { it.onStop() }
    }

    override fun onDestroy() {
        super.onDestroy()
        mAllPresenter.forEach { it.onDestroy() }
    }

    abstract fun getLayoutId() : Int


    override fun showProgressDialog() {
        super.showProgressDialog()
    }

    override fun dismissProgressDialog() {
        super.dismissProgressDialog()
    }


}