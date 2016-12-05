package poltavets.ua.com.summary.fragments

import kotlinx.android.synthetic.main.fragment_face.*
import poltavets.ua.com.summary.R


class FaceFragmentMain : AbstractMainPageFragment() {

    override fun getLayoutRes() = R.layout.fragment_face

    override fun getBackgroundImageView() = fragment_face_background!!

    override fun getRootView() = fragment_face_root!!

    override fun getBackgroundDrawable() = R.drawable.page_foreground

    override fun getMainImageView() = fragment_face_image

    override fun getMainDrawable() = R.drawable.photo_card

    override fun isIconColorFilterEnabled() = false
}