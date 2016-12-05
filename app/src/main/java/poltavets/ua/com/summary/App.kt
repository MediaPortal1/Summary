package poltavets.ua.com.summary

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.facebook.stetho.Stetho
import com.uphyca.stetho_realm.RealmInspectorModulesProvider
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.rx.RealmObservableFactory
import org.json.JSONObject
import poltavets.ua.com.summary.model.entities.Skill
import java.util.*


class App : Application() {

    private val DEFAULT_PREFERENCES = "default_preferences"
    private val IS_SKILLS_INIT = "is_skills_init"

    val preferences: SharedPreferences by lazy { getSharedPreferences(DEFAULT_PREFERENCES, Context.MODE_PRIVATE) }

    override fun onCreate() {
        super.onCreate()
        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .enableWebKitInspector(RealmInspectorModulesProvider.builder(this).build())
                .build())
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .rxFactory(RealmObservableFactory())
                .build()
        Realm.setDefaultConfiguration(config)
        initSkillsData()
    }

    private fun initSkillsData() {
        val isInit = preferences.getBoolean(IS_SKILLS_INIT, false)
        if (!isInit) readSkillsFromJSON()
    }

    private fun readSkillsFromJSON() {
        Thread({
            Realm.getDefaultInstance().use {
                    val skillsList = ArrayList<Skill>()
                    val inputSkills = assets.open("skills.json")
                    val size = inputSkills.available()
                    val buffer = ByteArray(size)
                    inputSkills.read(buffer)
                    inputSkills.close()
                    val json: JSONObject = JSONObject(String(buffer))
                    val skillsArray = json.getJSONArray("skills")
                    (0..skillsArray.length() - 1)
                            .map { skillsArray.getJSONObject(it) }
                            .forEach { skillsList.add(Skill(skillsList.size.toLong(), it.getString("title"), it.getString("subtitle"), it.getInt("rating"))) }
                    it.beginTransaction()
                    it.copyToRealm(skillsList)
                    it.commitTransaction()
            }
        }).start()

        val editor = preferences.edit()
        editor.putBoolean(IS_SKILLS_INIT, true)
        editor.apply()
    }
}