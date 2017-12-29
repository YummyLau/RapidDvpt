package com.example.yummylau.rapiddvpt.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.yummylau.rapiddvpt.SplashViewModel;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;
import yummylau.componentlib.di.ViewModelKey;

/**
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/12/12.
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SplashViewModel.class)
    abstract ViewModel bindsSplashViewModel(SplashViewModel splashViewModel);
}
