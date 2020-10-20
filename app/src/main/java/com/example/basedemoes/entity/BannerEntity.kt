package com.example.basedemoes.entity

data class BannerEntity (
    val imgRes: Int = 0,
    val imgUrl: String = "",
    val title: String = "",
    val viewType: Int = 0
){
    //加载本地数据
    constructor(imgRes: Int, title: String, viewType: Int): this(imgRes,"", title, viewType)
    //加载网络数据
    constructor(imgUrl: String, title: String, viewType: Int): this(0, imgUrl, title, viewType)

}
