package poltavets.ua.com.summary.fragments

import kotlinx.android.synthetic.main.fragment_contact_me.*
import poltavets.ua.com.summary.R
import poltavets.ua.com.summary.util.RandomColor


class ContactMeFragmentMain : AbstractMainPageFragment() {


    override fun getLayoutRes() = R.layout.fragment_contact_me

    override fun getBackgroundImageView() = fragment_contact_me_background!!

    override fun getRootView() = fragment_contact_me_root!!

    override fun getBackgroundDrawable() = R.drawable.page_foreground2

    override fun getMainImageView() = fragment_contact_me_image!!

    override fun getMainDrawable() = R.drawable.email

    override fun isIconColorFilterEnabled() = true

    override fun initViews() {
        super.initViews()
        fragment_contact_me_button.setOnClickListener {
            ContactsDialogFragment().showContacts(fragmentManager)
        }
    }
}