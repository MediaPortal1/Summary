package poltavets.ua.com.summary.fragments

import kotlinx.android.synthetic.main.fragment_experience.*
import poltavets.ua.com.summary.R


class ExperienceFragmentMain : AbstractMainPageFragment() {

    override fun getLayoutRes() = R.layout.fragment_experience

    override fun getBackgroundImageView() = fragment_experience_background!!

    override fun getRootView() = fragment_experience_root!!

    override fun getBackgroundDrawable() = R.drawable.page_foreground3

    override fun getMainImageView() = fragment_experience_image!!

    override fun getMainDrawable() = R.drawable.android

    override fun isIconColorFilterEnabled() = true
}