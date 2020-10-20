package com.example.basedemoes


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.example.basedemoes.adapter.HomeBannerAdapter
import com.example.basedemoes.adapter.HomeItemAdapter
import com.example.basedemoes.databinding.ActivityMainBinding
import com.example.basedemoes.entity.BannerEntity
import com.example.basedemoes.entity.ItemEntity
import com.example.basedemoes.feature.ChatActivity
import com.example.basedemoes.feature.ContactsActivity
import com.example.basedemoes.feature.FragmentActivity
import com.example.basedemoes.feature.TabActivity
import com.youth.banner.indicator.RoundLinesIndicator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.banner.*

class MainActivity : AppCompatActivity(), OnItemClickListener {
    private lateinit var binding : ActivityMainBinding
    private val mBannerList = mutableListOf<BannerEntity>()
    private val mItemList = mutableListOf<ItemEntity>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //两种初始化方法
//        mBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initData()
        //banner适配器
        var roundLinesIndicator:RoundLinesIndicator = banner_indicator
        var bannerAdapter = HomeBannerAdapter(mBannerList)
        home_banner?.let {
            it.addBannerLifecycleObserver(this)
            it.setIndicator(roundLinesIndicator, false)
            it.setBannerRound(20f)
            it.adapter = bannerAdapter
        }

        binding.rvDemo.adapter = homeItemAdapter

    }
    //recyclerView适配器
    private val homeItemAdapter by lazy{
        HomeItemAdapter(mItemList).apply {
            animationEnable = true
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
        mItemList.add(ItemEntity(R.string.chat_demo,  R.drawable.ic_chat, ChatActivity::class))
        mItemList.add(ItemEntity(R.string.contact_demo, R.drawable.ic_contact, ContactsActivity::class))
        mItemList.add(ItemEntity(R.string.tab_demo, R.drawable.ic_table, TabActivity::class))
        mItemList.add(ItemEntity(R.string.fragment_demo, R.drawable.ic_fragment, FragmentActivity::class))
        for (i in 1..10){
            mItemList.add(ItemEntity(R.string.demo_resource, R.drawable.ic_baseline_forum_24, ChatActivity::class))
        }
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {
        val item = adapter.data[position] as ItemEntity
        startActivity(Intent(this@MainActivity, item.activity?.java))
    }
}