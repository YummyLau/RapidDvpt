package yummylau.feature.di.module;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import yummylau.common.activity.BaseFragment;
import yummylau.feature.view.FollowedFragment;

/**
 * fragment依赖管理
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/12/11.
 */
@Module
public abstract class FragmentBuildersModule {


    @ContributesAndroidInjector
    abstract FollowedFragment contributeFollowedFragment();
}
