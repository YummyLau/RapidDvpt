package yummylau.feature;

import android.arch.core.executor.testing.InstantTaskExecutorRule;
import android.arch.persistence.room.Room;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.List;

import io.reactivex.functions.Consumer;
import io.reactivex.functions.Predicate;
import yummylau.feature.data.local.db.AppDataBase;
import yummylau.feature.data.local.db.entity.UserEntity;

/**
 * 测试数据库
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/11/15.
 */


@RunWith(AndroidJUnit4.class)
public class UserDaoTest {

    @Rule
    public InstantTaskExecutorRule instantTaskExecutorRule =
            new InstantTaskExecutorRule();

    private AppDataBase mAppDataBase;

    private static UserEntity USER;

    @Before
    public void initDB() throws Exception {
        mAppDataBase = Room.inMemoryDatabaseBuilder(InstrumentationRegistry.getContext(), AppDataBase.class)
                .allowMainThreadQueries()
                .build();
        USER = new UserEntity();
        USER.name = "test_name";
        USER.id = 1;
    }

    @After
    public void closeDb() throws Exception {
        mAppDataBase.close();
    }

    @Test
    public void insertAndGetUserById() {

        // Given that we have a user in the data source
        UserEntity userEntity = new UserEntity();
        userEntity.id = 1;
        userEntity.name = "test_name";
        mAppDataBase.userDao().insertUser(userEntity);
        // When subscribing to the emissions of user


//        mAppDataBase.userDao().getUsers()
//                .subscribe(new Subscriber<List<UserEntity>>() {
//                    @Override
//                    public void onSubscribe(Subscription s) {
//                        s.request(2);
//                    }
//
//                    @Override
//                    public void onNext(List<UserEntity> userEntities) {
//                        Assert.assertEquals(true, !userEntities.isEmpty());
//                    }
//
//                    @Override
//                    public void onError(Throwable t) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        System.currentTimeMillis();
//                    }
//                });

        mAppDataBase.userDao().getUsers()
                .subscribe(new Consumer<List<UserEntity>>() {
                    @Override
                    public void accept(List<UserEntity> userEntities) throws Exception {
                        Assert.assertEquals(true, !userEntities.isEmpty());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
//                .assertValue(new Predicate<UserEntity>() {
//                    @Override
//                    public boolean test(UserEntity userEntity) throws Exception {
//                        return userEntity != null && userEntity.id == USER.id;
//                    }
//                });

        // When subscribing to the emissions of the user
        UserEntity userEntity2 = new UserEntity();
        userEntity2.id = 2;
        userEntity2.name = "new name";
        mAppDataBase.userDao().insertUser(userEntity2);


        UserEntity userEntity3 = new UserEntity();
        userEntity3.id = 3;
        userEntity3.name = "new userEntity3";
        mAppDataBase.userDao().insertUser(userEntity3);

        UserEntity userEntity4 = new UserEntity();
        userEntity4.id = 4;
        userEntity4.name = "userEntity4 name";
        mAppDataBase.userDao().insertUser(userEntity4);
    }
//
//    @Test
//    public void updateAndGetUser() {
//        // Given that we have a user in the data source
//        mAppDataBase.userDao().insertUser(USER);
//
//        // When we are updating the name of the user
//        UserEntity updatedUser = new UserEntity();
//        updatedUser.id = 1;
//        updatedUser.name = "new username";
//        mAppDataBase.userDao().insertUser(updatedUser);
//
//        // When subscribing to the emissions of the user
//        mAppDataBase.userDao().getUser()
//                .test()
//                // assertValue asserts that there was only one emission of the user
//                .assertValue(new Predicate<UserEntity>() {
//                    @Override
//                    public boolean test(UserEntity userEntity) throws Exception {
//                        return userEntity != null && userEntity.id == USER.id && userEntity.name.equals(USER.name);
//                    }
//                });
//    }
//
//    @Test
//    public void deleteAndGetUser() {
//        // Given that we have a user in the data source
//        mAppDataBase.userDao().insertUser(USER);
//
//        //When we are deleting all users
//        mAppDataBase.userDao().deleteAllUsers();
//        // When subscribing to the emissions of the user
//        mAppDataBase.userDao().getUser()
//                .test()
//                // check that there's no user emitted
//                .assertNoValues();
//    }
}
