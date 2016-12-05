package poltavets.ua.com.summary.model.entities

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey
import io.realm.annotations.RealmClass

@RealmClass
open class Skill(@PrimaryKey var id: Long=0, var title: String="", var subtitle: String="", var rating: Int=0) : RealmObject(){}