package poltavets.ua.com.summary.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import poltavets.ua.com.summary.R
import poltavets.ua.com.summary.databinding.ItemSkillBinding
import poltavets.ua.com.summary.model.entities.Skill


class SkillsAdapter(val items: List<Skill>) : RecyclerView.Adapter<SkillsAdapter.SkillHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int) = SkillHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent?.context), R.layout.item_skill, parent, false))

    override fun onBindViewHolder(holder: SkillsAdapter.SkillHolder, position: Int) {
        holder.binding.skill = items[position]
    }

    override fun getItemCount() = items.size

    class SkillHolder(val binding: ItemSkillBinding) : RecyclerView.ViewHolder(binding.root)

}