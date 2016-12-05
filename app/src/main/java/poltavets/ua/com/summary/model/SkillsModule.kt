package poltavets.ua.com.summary.model

import io.realm.Realm
import kotlinx.android.synthetic.main.activity_skills.*
import poltavets.ua.com.summary.activities.SkillsActivity
import poltavets.ua.com.summary.adapters.SkillsAdapter
import poltavets.ua.com.summary.model.entities.Skill
import rx.android.schedulers.AndroidSchedulers

open class SkillsModule(val activity: SkillsActivity) {

    fun getSkills() {
        Realm.getDefaultInstance().where(Skill::class.java).findAllAsync().asObservable()
                .subscribeOn(AndroidSchedulers.mainThread())
                .map { skills -> skills.distinct() }
                .subscribe { result ->
                    activity.skills_recycler.adapter = SkillsAdapter(result)

                }
    }
}