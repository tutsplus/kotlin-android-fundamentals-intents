package com.annapurna.envato.implicitintents

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun webLink(view: View) {
        val link = Uri.parse("https://tutsplus.com")
        val intent = Intent(Intent.ACTION_VIEW, link)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun showMap(view: View) {
        val link = Uri.parse("geo:27.1748,78.04155")
        val intent = Intent(Intent.ACTION_VIEW, link)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun dialNumber(view: View) {
        val link = Uri.parse("tel:27174878041")
        val intent = Intent(Intent.ACTION_DIAL, link)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun getPhoto(view: View) {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"

        if (intent.resolveActivity(packageManager) != null) {
            startActivityForResult(intent, REQUEST_GET_PHOTO)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == REQUEST_GET_PHOTO && resultCode == Activity.RESULT_OK) {
            photoUri = data?.data
            val fetchedPhoto = MediaStore.Images.Media.getBitmap(this.contentResolver, photoUri)
            image_view.setImageBitmap(fetchedPhoto)
            image_view.visibility = View.VISIBLE
            return
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    fun sentText(view: View) {
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_TEXT, "Welcome to Intent Course at Envato")
        intent.type = "text/*"

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    fun sendPhoto(view: View) {
        if (null == photoUri)
            return
        val intent = Intent(Intent.ACTION_SEND)
        intent.putExtra(Intent.EXTRA_STREAM, photoUri)
        intent.type = contentResolver.getType(photoUri)
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    companion object {
        val REQUEST_GET_PHOTO = 99
        var photoUri: Uri? = null
    }
}
