package com.example.basedemoes.feature


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.basedemoes.R
import com.example.basedemoes.adapter.HomeBannerAdapter
import com.example.basedemoes.adapter.HomeItemAdapter
import com.example.basedemoes.entity.BannerEntity
import com.example.basedemoes.entity.ItemEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private val mBannerList = mutableListOf<BannerEntity>()
    private val mItemList = mutableListOf<ItemEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //两种DataBinding初始化方法
//        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
//        binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(binding.root)
        setContentView(R.layout.activity_main)
        initData()
        //banner适配器

        var bannerAdapter = HomeBannerAdapter(mBannerList)
        home_banner?.let {
            it.addBannerLifecycleObserver(this)
            it.setIndicator(banner_indicator, false)
            it.adapter = bannerAdapter
        }

        rv_demo.adapter = homeItemAdapter

    }
    //recyclerView适配器
    private val homeItemAdapter by lazy{
        HomeItemAdapter(mItemList).apply {
            animationEnable = true
            //增加头部图像
//            val topBanner = layoutInflater.inflate(R.layout.banner, rv_demo, false)
//            addHeaderView(topBanner)
            setOnItemClickListener(this@MainActivity)
        }
    }

    fun initData(){
        initBannerData()
        initRecyclerData()
    }

    fun initBannerData(){
        mBannerList.add(BannerEntity(R.mipmap.yibo1,"yibo1", 1))
        mBannerList.add(BannerEntity(R.mipmap.yibo7,"yibo7", 1))
        mBannerList.add(BannerEntity(R.mipmap.yibo12,"yibo12", 2))
        mBannerList.add(BannerEntity(R.mipmap.yibo21,"yibo21", 2))
    }

    fun initRecyclerData(){
        mItemList.add(ItemEntity(R.string.chat_demo, R.drawable.ic_chat, ChatActivity::class))
        mItemList.add(ItemEntity(R.string.contact_demo, R.drawable.ic_contact, ContactsActivity::class))
        mItemList.add(ItemEntity(R.string.tab_fragment_demo,
            R.drawable.ic_table, TabFragmentActivity::class))
        mItemList.add(ItemEntity(R.string.tab_viewpager_demo,
            R.drawable.ic_fragment, TabViewPagerFragmentActivity::class))
        mItemList.add(ItemEntity(R.string.device, R.drawable.ic_device, MultiDeviceActivity::class))
        for (i in 1..10){
            mItemList.add(ItemEntity(R.string.demo_resource,
                R.drawable.ic_baseline_forum_24, ChatActivity::class))
        }
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val item = adapter.data[position] as ItemEntity
        startActivity(Intent(this@MainActivity, item.activity?.java))
    }
}