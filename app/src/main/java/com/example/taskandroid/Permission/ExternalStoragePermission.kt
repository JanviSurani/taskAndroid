package com.example.taskandroid.Permission

import android.content.Intent
import android.content.pm.PackageManager
import android.Manifest
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.core.content.ContextCompat
import com.example.taskandroid.R
import com.example.taskandroid.databinding.ActivityContactPermissionBinding

class ExternalStoragePermission : AppCompatActivity(), View.OnClickListener {

    companion object {
        const val REQUEST_WRITE_PERMISSION = 100
    }
    private lateinit var binding: ActivityContactPermissionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityContactPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
    }
    private fun getData() {
        binding.requestbtn.setOnClickListener(this)
        binding.yes.setOnClickListener(this)
    }

    override fun onResume() {
        super.onResume()
        if (checkPermissionForReadExtertalStorage()) {
            binding.txtfirst.setText(R.string.permission_granted)
            binding.yes.visibility=View.GONE
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.requestbtn -> if (checkPermissionForReadExtertalStorage()) {

                binding.txtfirst.setText(R.string.permission_granted)
            } else {
                //Make Request
                requestPermission()
            }
            R.id.yes -> {
                val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                val uri = Uri.fromParts("package", packageName, null)
                intent.data = uri
                startActivity(intent)
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {

        if (grantResults.size > 0) {
            if (requestCode == REQUEST_WRITE_PERMISSION) {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // permission granted
                    binding. txtfirst.setText(R.string.permission_granted)
                 binding.yes.visibility = View.GONE
                } else {
                    // permission denied
                    binding.txtfirst!!.setText(R.string.permission_denied)
                    // Check wheather checked dont ask again
                    checkUserRequestedDontAskAgain()
                }
            }
        }
    }

    fun checkPermissionForReadExtertalStorage(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            (ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
                    || ContextCompat.checkSelfPermission(
                this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED)
        } else false
    }

    private fun requestPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                REQUEST_WRITE_PERMISSION
            )
        }
    }

    private fun checkUserRequestedDontAskAgain() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val rationalFalgREAD =
                shouldShowRequestPermissionRationale(Manifest.permission.WRITE_EXTERNAL_STORAGE)
            val rationalFalgWRITE =
                shouldShowRequestPermissionRationale(Manifest.permission.READ_EXTERNAL_STORAGE)
            if (!rationalFalgREAD && !rationalFalgWRITE) {

                binding.txtfirst.setText(R.string.permission_denied_forcefully)
               binding.yes.visibility = View.VISIBLE
            }
        }
    }

}