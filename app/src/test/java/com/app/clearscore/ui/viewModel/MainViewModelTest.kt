package com.app.clearscore.ui.viewModel

import androidx.test.ext.junit.runners.AndroidJUnit4
import com.app.bbcapp.network.ApiInterface
import org.junit.Before
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class) class MainViewModelTest {

    lateinit var mainViewModel: MainViewModel

    lateinit var apiInterface: ApiInterface

    @Before
    fun setup() {
        mainViewModel = MainViewModel(apiInterface)
    }

}