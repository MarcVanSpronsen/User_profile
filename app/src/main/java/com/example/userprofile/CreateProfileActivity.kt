package com.example.userprofile

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_create_profile.*

const val GALLERY_REQUEST_CODE = 100

class CreateProfileActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_profile)
        InitViews()
    }

    private fun InitViews(){
        btnGallery.setOnClickListener { onGalleryClick() }
        btnComfirm.setOnClickListener { onClickconfirm() }
    }

    private fun onClickconfirm() {
        val profile = Profile(
            firstNameInput.text.toString(),
            lastNameInput.text.toString(),
            discriptionInput.text.toString(),
            profileImageUri
        )

        val profileActivityIntent = Intent(this, ProfileActivity::class.java)
        profileActivityIntent.putExtra("PROFILE_EXTRA", profile)
        startActivity(profileActivityIntent)
    }



    private fun onGalleryClick() {
        val galleryIntent = Intent(Intent.ACTION_PICK)

        galleryIntent.type = "image/*"
        startActivityForResult(galleryIntent, GALLERY_REQUEST_CODE)
    }

    private var profileImageUri: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            when (resultCode) {
                GALLERY_REQUEST_CODE -> {
                    profileImageUri = data?.data
                    myImage.setImageURI(profileImageUri)
                }
            }
        }
    }
}