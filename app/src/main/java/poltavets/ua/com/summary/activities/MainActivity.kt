package poltavets.ua.com.summary.activities

import android.support.v4.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*
import poltavets.ua.com.summary.R
import poltavets.ua.com.summary.adapters.FragmentViewPagerAdapter
import poltavets.ua.com.summary.fragments.ExperienceFragmentMain
import poltavets.ua.com.summary.fragments.FaceFragmentMain
import poltavets.ua.com.summary.fragments.ContactMeFragmentMain
import java.util.*


class MainActivity : AbstractDrawerActivity() {

    private val adapter: FragmentViewPagerAdapter by lazy { FragmentViewPagerAdapter(supportFragmentManager, initPages()) }

    override fun getActivityTitle() = R.string.title_main

    override fun getContentLayout() = R.layout.activity_main

    override fun getCurrentActivity() = NavigationItem.MAIN

    override fun initViews() {
        main_viewpager.adapter = adapter
        main_indicator.setViewPager(main_viewpager)
    }

    private fun initPages(): List<Fragment> {
        val pages = ArrayList<Fragment>()
        pages.add(FaceFragmentMain())
        pages.add(ExperienceFragmentMain())
        pages.add(ContactMeFragmentMain())
        return pages
    }
}