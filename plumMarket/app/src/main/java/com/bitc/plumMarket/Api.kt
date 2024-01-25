package com.bitc.plumMarket

import com.bitc.plumMarket.Data.ChatList
import com.bitc.plumMarket.Data.GansimData
import com.bitc.plumMarket.Data.ListData
import com.bitc.plumMarket.Data.ListImageDTO
import com.bitc.plumMarket.Data.LoginData
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface Api {
    @FormUrlEncoded
    @POST("/LoginChk")
    fun getPostList(
        @Field("id")id:String, @Field("pw")pw: String): Call<LoginData>

    @FormUrlEncoded
    @POST("/Join")
    fun setJoin(
        @Field("id")id:String,
        @Field("pw")pw: String,
        @Field("pw2")pw2: String,
        @Field("nickname")nickname: String,
        @Field("email")email: String,): Call<Void>

    @FormUrlEncoded
    @POST("/chatList")
    fun getChatList(
        @Field("user_idx") idx: String
    ): Call<List<ChatList>>

    @FormUrlEncoded
    @POST("/insertList")
    fun insertListData(
        @Field("title") title: String,
        @Field("money") money: String,
        @Field("content") content: String,
        @Field("loc") loc: String,
        @Field("nick")nick:String
    ): Call<Int>

    @POST("/insertImage")
    fun insertImage(@Body imageList: MutableList<ListImageDTO>): Call<Void>


    @GET("/selectList")
    fun getListData(): Call<List<ListData>>

    @FormUrlEncoded
    @POST("/deleteList")
    fun DeleteChatList(@Field("idx")idx: String, @Field("reIdx")reidx: String): Call<Void>



    @FormUrlEncoded
    @POST("/profileUpload")
    fun UploadProfile(@Field("profileName")profileName : String, @Field("uid")uid:String) : Call<Void>


    @FormUrlEncoded
    @POST("/selectFavList")
    fun selectFavList(
        @Field("id")id:String):Call<List<ListData>>

    @FormUrlEncoded
    @POST("/selectPanmaeList")
    fun selectPanmaeList(
        @Field("nick")nick:String):Call<List<ListData>>

    @FormUrlEncoded
    @POST("/selectPanmaeCompleteList")
    fun selectPanmaeCompleteList(
        @Field("nick")nick:String):Call<List<ListData>>

    @FormUrlEncoded
    @POST("/selectPanmaeHideList")
    fun selectPanmaeHideList(
        @Field("nick")nick:String):Call<List<ListData>>



    @FormUrlEncoded
    @POST("/updateSellReservation")
    fun updateSellReservation(
        @Field("idx")idx:String): Call<Void>

    @FormUrlEncoded
    @POST("/updateSellComplete")
    fun updateSellComplete(
        @Field("idx")idx:String): Call<Void>

    @FormUrlEncoded
    @POST("/updateSellDelete")
    fun updateSellDelete(
        @Field("idx")idx:String): Call<Void>

    @FormUrlEncoded
    @POST("/updateSellHide")
    fun updateSellHide(
        @Field("idx")idx:String): Call<Void>

    @FormUrlEncoded
    @POST("/writeList")
    fun writeListData(
        @Field("title") title: String,
        @Field("money") money: String,
        @Field("money") idx: String,
        @Field("content") content: String,

        ): Call<Void>


    @FormUrlEncoded
    @POST("/updateList")
    fun UpdateList(
        @Field("title") title: String,
        @Field("money") money: String,
        @Field("content") content: String,
        @Field("idx") idx: String,
        @Field("loc") loc: String
    ): Call<Void>

    @FormUrlEncoded
    @POST("/SangesList")
    fun getListData(
        @Field("idx") idx: String,
    ): Call<ListData>


    @GET("/gansim")
    fun GansimList(@Query("userId") userId:String): Call<List<GansimData>>
}



object RetrofitBuilder {
    var api: Api = Retrofit.Builder()
        .baseUrl("http://10.0.2.2:8080")
        .addConverterFactory(GsonConverterFactory.create(Gson()))
        .build()
        .create(Api::class.java)
}