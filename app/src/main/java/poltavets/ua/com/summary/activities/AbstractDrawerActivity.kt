package poltavets.ua.com.summary.activities

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.support.annotation.IdRes
import android.support.annotation.LayoutRes
import android.support.design.widget.NavigationView
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_drawer.*
import kotlinx.android.synthetic.main.layout_navigation_view.*
import kotlinx.android.synthetic.main.layout_toolbar.*
import kotlinx.android.synthetic.main.layout_viewstub.*
import poltavets.ua.com.summary.R
import java.util.*


abstract class AbstractDrawerActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toggle: ActionBarDrawerToggle

    protected enum class NavigationItem(val id: Int, val classType: Class<*>) {
        MAIN(R.id.menu_main, MainActivity::class.java),
        SKILLS(R.id.menu_skills, SkillsActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_drawer)
        initToolbar()
        initDrawer()
        initContent()
        initViews()
    }

    @IdRes abstract protected fun getActivityTitle(): Int

    @LayoutRes abstract protected fun getContentLayout(): Int

    abstract protected fun getCurrentActivity(): NavigationItem

    abstract protected fun initViews()


    private fun initToolbar() {
        toggle = ActionBarDrawerToggle(this, drawer_view, toolbar_view, R.string.drawer_open, R.string.drawer_close)
        drawer_view.addDrawerListener(toggle)
        setSupportActionBar(toolbar_view)
        setTitle(getActivityTitle())
        supportActionBar?.setHomeButtonEnabled(true)
        toggle.syncState()
    }

    private fun initDrawer() {
        navigation_view.setNavigationItemSelectedListener(this)
        navigation_view.menu.getItem(getCurrentActivity().ordinal).isChecked = true
    }

    private fun initContent() {
        viewstub_view.layoutResource = getContentLayout()
        viewstub_view.inflate()
    }

    override fun onNavigationItemSelected(item: MenuItem) = when (item.itemId) {
        getCurrentActivity().id -> closeDrawer()
        R.id.menu_main -> startNavActivity(NavigationItem.MAIN)
        R.id.menu_skills -> startNavActivity(NavigationItem.SKILLS)
        else -> false
    }

    private fun closeDrawer(): Boolean {
        drawer_view.closeDrawers()
        return true
    }

    private fun startNavActivity(activity: NavigationItem): Boolean {
        closeDrawer()
        startActivity(Intent(this, activity.classType).setFlags(
                Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP))
        return true
    }

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (toggle.onOptionsItemSelected(item)) return true
        return super.onOptionsItemSelected(item)
    }

}