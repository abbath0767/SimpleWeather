package com.luxary_team.simpleweather.controller.network_threads;

import android.util.Log;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

import static com.luxary_team.simpleweather.App.DEBUG_TAG;

public class NetworkRequest {

    private static Action1<Throwable> mOnError = new Action1<Throwable>() {
        @Override
        public void call(Throwable throwable) {
            Log.d(DEBUG_TAG, "Error. " + throwable.getMessage());
            throwable.printStackTrace();
        }
    };

    public static <T> Subscription asyncRequest(Observable<T> observable, Action1<? super T> action) {
        return asyncRequest(observable, action, mOnError);
    }

    public static <T> Subscription asyncRequest(Observable<T> observable, Action1<? super T> action, Action1<Throwable> mOnError) {
        return observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(action, mOnError);
    }
}
