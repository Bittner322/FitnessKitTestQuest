package com.example.fitnesskittestquest.presentation.main_activity

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.fitnesskittestquest.databinding.ActivityMainBinding
import com.example.fitnesskittestquest.di.ComponentStorage
import com.example.fitnesskittestquest.di.components.DaggerMainActivityComponent
import com.example.fitnesskittestquest.di.provideRootComponent
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: MainActivityViewModelFactory

    private val viewModel: MainActivityViewModel by viewModels { viewModelFactory }

    private val daggerComponentKey = "MainActivity"

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding
        get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ComponentStorage.provideComponent(daggerComponentKey) {
            DaggerMainActivityComponent.factory().create(
                appComponent = ComponentStorage.provideRootComponent()
            )
        }.inject(this)

        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val adapter = MainActivityRecyclerAdapter()

        binding.recyclerView.adapter = adapter

        lifecycleScope.launchWhenStarted {

            viewModel.adapterList
                .onEach {
                    adapter.setData(it)
                }
                .launchIn(this)

        }
    }

    override fun onDestroy() {
        if (!isChangingConfigurations) {
            ComponentStorage.clearComponent(daggerComponentKey)
        }
        super.onDestroy()
    }
}