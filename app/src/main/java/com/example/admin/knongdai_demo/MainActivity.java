package com.example.admin.knongdai_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.admin.knongdai_demo.data.ServiceGenerator;
import com.example.admin.knongdai_demo.data.remote.CategoryService;
import com.example.admin.knongdai_demo.entity.CategoryResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    CategoryService service;
    private CompositeDisposable disposable = new CompositeDisposable();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        service=ServiceGenerator.createService(CategoryService.class);

        //getAllCategories();
        getAllCategoriesRx();
    }

    private void getAllCategories() {

        service.getCategories().enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                Log.e("data",response.body().getData().toString());

            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {

            }
        });
    }

    private void getAllCategoriesRx() {
       disposable.add(
        service.getCategoriesRx()
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribeWith(new DisposableObserver<CategoryResponse>() {
                   @Override
                   public void onNext(CategoryResponse categoryResponse) {

                        Log.e("Data",categoryResponse.getData().toString());

                   }

                   @Override
                   public void onComplete() {

                   }

                   @Override
                   public void onError(Throwable e) {

                   }
               }));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        disposable.clear();
    }
}
