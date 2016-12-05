package poltavets.ua.com.summary.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import poltavets.ua.com.summary.R
import poltavets.ua.com.summary.model.entities.Contact


class ContactsRecyclerView(val contactList: List<Contact>) : RecyclerView.Adapter<ContactsRecyclerView.ContactHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = ContactHolder(LayoutInflater.from(parent?.context).inflate(R.layout.item_contact, parent, false))

    override fun getItemCount() = contactList.size

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        holder.bindContact(contactList[position])
    }

    class ContactHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindContact(contact: Contact) {
            (itemView.findViewById(R.id.item_contact_text) as TextView).text = itemView.resources.getString(contact.textResource)
            (itemView.findViewById(R.id.item_contact_icon) as ImageView).setImageResource(contact.iconDrawable)
        }
    }
}