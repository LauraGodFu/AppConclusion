package com.qxj.welcome.activity

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.alibaba.android.arouter.launcher.ARouter
import com.qxj.welcome.R
import com.qxj.welcome.base.BaseActivity
import com.qxj.welcome.data.Author

@Route(path = "/home/activity/SecondActivity")
class SecondActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_second

    override fun initView() {
        //获取自定义参数
        val service: SerializationService =
                ARouter.getInstance().navigation(SerializationService::class.java)
        val a = service.json2Object(intent.getStringExtra("author"), Author::class.java)
    }

    override fun subscribeUi() {

    }
}