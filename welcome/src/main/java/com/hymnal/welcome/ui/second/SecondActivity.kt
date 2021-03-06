package com.hymnal.welcome.ui.second

import com.alibaba.android.arouter.facade.annotation.Route
import com.alibaba.android.arouter.facade.service.SerializationService
import com.alibaba.android.arouter.launcher.ARouter
import com.hymnal.welcome.R
import com.hymnal.welcome.base.BaseActivity
import com.hymnal.welcome.dsl.OnClickListenerBuilder
import com.hymnal.welcome.dsl.setOnDataClickListener
import kotlinx.android.synthetic.main.activity_second.*

@Route(path = "/home/activity/SecondActivity")
class SecondActivity : BaseActivity() {

    override fun getLayoutId(): Int = R.layout.activity_second

    override fun subscribeUi() {
        //获取自定义参数
        val service: SerializationService =
            ARouter.getInstance().navigation(SerializationService::class.java)
        val a = service.json2Object(intent.getStringExtra("author"), Author::class.java)



        btn.setOnDataClickListener {
            onClick {

            }
        }

        btn.setOnClickListener {
            val builder = OnClickListenerBuilder()
            builder.onClick {

            }
            builder.onClickAction?.invoke(it)
        }
    }
}
