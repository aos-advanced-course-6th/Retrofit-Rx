package com.example.admin.knongdai_demo.data.remote;

import com.example.admin.knongdai_demo.entity.CategoryResponse;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {

    @GET("api/v1/categories")
    Call<CategoryResponse> getCategories();

    @GET("api/v1/categories")
    Observable<CategoryResponse> getCategoriesRx();

}
