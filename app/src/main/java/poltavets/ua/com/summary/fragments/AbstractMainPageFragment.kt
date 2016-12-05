package poltavets.ua.com.summary.fragments

import android.os.Bundle
import android.support.annotation.DrawableRes
import android.support.annotation.LayoutRes
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.squareup.picasso.Picasso
import poltavets.ua.com.summary.util.RandomColor


abstract class AbstractMainPageFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            = inflater.inflate(getLayoutRes(), container, false)!!

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setRandomBackgroundColor()
        getBackgroundImageView().setOnClickListener {
            setRandomBackgroundColor()
        }
        if (isIconColorFilterEnabled()) setMainImageColorFilter()
        initViews()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        Picasso.with(context).load(getBackgroundDrawable()).fit().centerCrop().into(getBackgroundImageView())
        Picasso.with(context).load(getMainDrawable()).fit().centerCrop().into(getMainImageView())
    }

    private fun setRandomBackgroundColor() {
        getRootView().setBackgroundColor(RandomColor.getInstance(resources).getRandomColor())
    }

    private fun setMainImageColorFilter() {
        getMainImageView().setColorFilter(RandomColor.getInstance(resources).getRandomColor())
        getMainImageView().setOnClickListener {
            getMainImageView().setColorFilter(RandomColor.getInstance(resources).getRandomColor())
        }
    }

    open protected fun initViews() {
    }

    @LayoutRes abstract protected fun getLayoutRes(): Int

    abstract protected fun getBackgroundImageView(): ImageView

    abstract protected fun getMainImageView(): ImageView

    abstract protected fun getRootView(): View

    @DrawableRes abstract protected fun getBackgroundDrawable(): Int

    @DrawableRes abstract protected fun getMainDrawable(): Int

    abstract protected fun isIconColorFilterEnabled(): Boolean

}