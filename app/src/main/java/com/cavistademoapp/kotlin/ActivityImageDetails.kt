package com.cavistademoapp.kotlin

import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.cavistademoapp.ActivityLandingPage.*
import com.cavistademoapp.BaseActivity
import com.cavistademoapp.R
import com.cavistademoapp.databinding.ActivityImageDetailsBinding
import com.facebook.drawee.backends.pipeline.Fresco

class ActivityImageDetails : BaseActivity(), View.OnClickListener {
    private lateinit var binding: ActivityImageDetailsBinding
    private var mId: String? = null
    private val STR_NULL = "null"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image_details)

        Fresco.initialize(this)

        //data binding object
        val mBinding : ActivityImageDetailsBinding = DataBindingUtil.setContentView(this, R.layout.activity_image_details)
        binding = mBinding
        //take necessary data
        var mBundle = intent.getBundleExtra(KEY_BUNDLE)
        var mImageLink = mBundle.getString(KEY_LINK)
        mId = mBundle.getString(KEY_ID)

        //to enable back button functionality
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        //set image to image view
        val uri = Uri.parse(mImageLink)
        mBinding.imageViewDetail.setImageURI(uri)

        //initialize button action to save comment in for future use
        mBinding.buttonSubmit.setOnClickListener(this)

        //set comment to edit text
        setTextIfExist()
    }

    private fun setTextIfExist() {
        var mComment : String = getValue(mId,this).toString()
        if (!TextUtils.equals(mComment,STR_NULL))
            binding.editTextComment.text = Editable.Factory.getInstance().newEditable(mComment)
    }

    /**
     *
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    override fun onClick(view: View?) {
        when(view!!.id) {
            R.id.button_submit -> saveComment()
        }
    }

    /**
     * save comment by the help of unique id ( mID )
     */
    private fun saveComment() {
        showMessage(this,getString(R.string.str_success))
        setValue(mId,binding.editTextComment.text.toString(),this)
        finish()
    }
}