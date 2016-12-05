package poltavets.ua.com.summary.util

import android.content.res.Resources
import android.support.annotation.ColorRes
import poltavets.ua.com.summary.R
import java.util.*


class RandomColor private constructor(res: Resources){

    val colorList: IntArray by lazy { res.getIntArray(R.array.light_colors_array) }
    val random: Random = Random()

    private object INSTANCE{
        var instance: RandomColor? = null
    }

    companion object{
        fun getInstance(res: Resources): RandomColor {
            if (INSTANCE.instance == null) INSTANCE.instance = RandomColor(res)
            return INSTANCE.instance!!
        }
    }

    @ColorRes fun getRandomColor() = colorList[random.nextInt(colorList.size)]
}