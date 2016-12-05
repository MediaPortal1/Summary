package poltavets.ua.com.summary.fragments

import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.SimpleAdapter
import kotlinx.android.synthetic.main.fragment_contacts.*
import poltavets.ua.com.summary.R
import poltavets.ua.com.summary.adapters.ContactsRecyclerView
import poltavets.ua.com.summary.model.entities.Contact
import java.util.*


class ContactsDialogFragment : DialogFragment() {

    companion object {
        val CONTACT_FRAGMENT_TAG = "contacts_dialog"
    }

    val contacts: List<Contact> by lazy { initContactsList() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.DarkDialog)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater?.inflate(R.layout.fragment_contacts, container, false)

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        contacts_recycler.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        contacts_recycler.adapter = ContactsRecyclerView(contacts)
        dialog.setTitle(R.string.contacts_contact_me)
    }

    private fun initContactsList(): List<Contact> {
        val contactList = ArrayList<Contact>()
        contactList.add(Contact(R.string.contact_email, R.mipmap.ic_email))
        contactList.add(Contact(R.string.contact_phone, R.mipmap.ic_cellphone_android))
        contactList.add(Contact(R.string.contact_skype, R.mipmap.ic_skype))
        contactList.add(Contact(R.string.contact_play, R.mipmap.ic_google_play))
        contactList.add(Contact(R.string.contact_github, R.mipmap.ic_github_circle))
        contactList.add(Contact(R.string.contact_linkedin, R.mipmap.ic_linkedin_box))
        return contactList
    }

    fun showContacts(fm: FragmentManager) {
        val dialog = ContactsDialogFragment()
        dialog.show(fm, CONTACT_FRAGMENT_TAG)
    }

}
