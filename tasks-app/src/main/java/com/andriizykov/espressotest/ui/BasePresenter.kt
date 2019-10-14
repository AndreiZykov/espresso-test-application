package com.andriizykov.espressotest.ui

interface BasePresenter <View : BaseView> {
    fun subscribe(view: View)
    fun unsubscribe()
}