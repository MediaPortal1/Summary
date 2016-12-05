package poltavets.ua.com.summary.model.entities

import android.support.annotation.DrawableRes
import android.support.annotation.StringRes


data class Contact(@StringRes val textResource: Int, @DrawableRes val iconDrawable: Int)