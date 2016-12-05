package poltavets.ua.com.summary.activities

import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_skills.*
import poltavets.ua.com.summary.R
import poltavets.ua.com.summary.adapters.SkillsAdapter
import poltavets.ua.com.summary.model.SkillsModule


class SkillsActivity : AbstractDrawerActivity() {

    override fun getActivityTitle() = R.string.title_skills

    override fun getContentLayout() = R.layout.activity_skills

    override fun getCurrentActivity() = NavigationItem.SKILLS

    override fun initViews() {
        skills_recycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        SkillsModule(this).getSkills()
    }

}