package com.app.clearscore.core

interface IView<S : IState> {
    fun render(state: S)
}