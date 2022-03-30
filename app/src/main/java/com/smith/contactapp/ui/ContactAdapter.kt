package com.smith.contactapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smith.contactapp.data.Contact
import com.smith.contactapp.databinding.RecyclerViewContactBinding

class ContactAdapter: RecyclerView.Adapter<ContactAdapter.ViewHolder>() {

    var contacts = mutableListOf<Contact>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactAdapter.ViewHolder {

      return ViewHolder(RecyclerViewContactBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ContactAdapter.ViewHolder, position: Int) {
        holder.binding.textViewName.text = contacts[position].fullName
        holder.binding.textViewContact.text = contacts[position].ContactNumber

    }

    override fun getItemCount(): Int {
       return contacts.size
    }
    fun addContact(contact: Contact){
        if(!contacts.contains(contact)){
            contacts.add(contact)
        }else{
            val index = contacts.indexOf(contact)
            if(contact.isDeleted){
                contacts.removeAt(index)
            }else {
                contacts[index] = contact
            }

        }
        notifyDataSetChanged()

    }

    inner class ViewHolder(val binding: RecyclerViewContactBinding):RecyclerView.ViewHolder(binding.root){

    }

}