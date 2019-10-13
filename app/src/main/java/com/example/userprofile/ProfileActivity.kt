package com.example.userprofile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_profile.*

const val PROFILE_EXTRA = "PROFILE_EXTRA"

class ProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        InitViews()
    }

    private  fun InitViews() {
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title = "This is your profile!"


        val profile = intent.getParcelableExtra<Profile>(PROFILE_EXTRA)

        if (profile != null){
            profileName.text = getString(R.string.name, profile.firstName, profile.lastName)
            profileDiscription.text = profile.discription
            if (profile.Uri != null) {
                myImage.setImageURI(profile.Uri)
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            android.R.id.home -> {
                finish()
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
