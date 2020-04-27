package com.taktelon.classspanish

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.taktelon.classspanish.ui.main.SectionsPagerAdapter
import kotlinx.android.synthetic.main.activity_verb_detail.*

class VerbDetailTabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verb_detail2)
        setSupportActionBar(detail_toolbar)

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "HOGE"

        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
            when (item.itemId) {
                android.R.id.home -> {
                    // This ID represents the Home or Up button. In the case of this
                    // activity, the Up button is shown. For
                    // more details, see the Navigation pattern on Android Design:
                    //
                    // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                    navigateUpTo(Intent(this, VerbListActivity::class.java))
                    true
                }
                else -> super.onOptionsItemSelected(item)
            }
}