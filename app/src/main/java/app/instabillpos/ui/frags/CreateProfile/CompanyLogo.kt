package app.instabillpos.ui.frags.CreateProfile

import android.Manifest
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import app.instabillpos.R
import app.instabillpos.databinding.CompanyLogoBinding
import app.instabillpos.utils.Helper
import app.instabillpos.utils.PermissionUtil
import app.instabillpos.utils.mUtil.mToast
import app.instabillpos.utils.mUtil.saveBitMap
import com.bumptech.glide.Glide
import com.theartofdev.edmodo.cropper.CropImage
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.InputStream


class CompanyLogo : Fragment(), View.OnClickListener {
    private var _binding: CompanyLogoBinding? = null
    private val bind get() = _binding!!
    val args: CompanyLogoArgs by navArgs()

    private var resultUri: Uri? = null
    private var finalUri: Uri? = null
    private var iSize: Long = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = CompanyLogoBinding.inflate(inflater, container, false)
        return bind.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAllComponents()
    }

    private fun initAllComponents() {
        bind.next.setOnClickListener(this)
        bind.image.setOnClickListener(this)
        bind.previous.setOnClickListener(this)
        bind.statusImage.setOnClickListener(this)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.next -> {
                if (iSize < 301) {
                    val action = CompanyLogoDirections.companyLogoToCompanyProfile(
                        args.bussinessType,
                        resultUri.toString()
                    )
                    v.findNavController().navigate(action)
                } else {
                    mToast(requireContext(), "Images should be less than 300 kb")
                }
            }
            R.id.previous -> {
                v.findNavController().navigateUp()
            }
            R.id.image -> {
                openGallery()

            }
            R.id.statusImage -> {
                openGallery()
            }
        }
    }

    private fun openGallery() {
        if (PermissionUtil.verifyPermissions(
                requireContext(),
                PermissionUtil.getGalleryPermissions()
            )
        ) {
            if (resultUri != null) {
                Glide.with(this).load(R.drawable.ic_mperson).into(bind.image)
                Glide.with(this).load(android.R.drawable.ic_menu_camera).into(bind.statusImage)
                resultUri = null
            } else {
                val galleryIntent =
                    Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(galleryIntent, 100)
            }
        } else {
            requestPermissions(
                arrayOf(
                    Manifest.permission.READ_EXTERNAL_STORAGE,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                ),
                100
            )

        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 100) {
            for (i in permissions.indices) {
                val permission = permissions[i]
                val grantResult = grantResults[i]
                if (permission == Manifest.permission.READ_EXTERNAL_STORAGE) {
                    if (grantResult == PackageManager.PERMISSION_GRANTED) {
                        openGallery()
                    }
                }
            }
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 100) {
                CropImage.activity(data!!.data)
                    .start(requireContext(), this);
            }
        }

        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            val result = CropImage.getActivityResult(data)
            if (resultCode == Activity.RESULT_OK) {
                resultUri = result.uri
                iSize = Helper.imageSize(requireContext(), resultUri)
                Glide.with(this).load(resultUri).into(bind.image)
                Glide.with(this).load(R.drawable.ic_close).into(bind.statusImage)

                if (iSize <= 300) {
                    bind.image.borderColor = resources.getColor(R.color.green)
                    saveMyBiMap(result.uri)
                } else {
                    bind.image.borderColor = resources.getColor(R.color.red)
                    mToast(requireContext(), "image size is $iSize kb")
                }

            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                val error = result.error
                mToast(requireContext(), error.toString())
            }
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    private fun saveMyBiMap(resulttUri: Uri) {
        try {
            val inputStream: InputStream =
                requireContext().contentResolver.openInputStream(resulttUri)!!
            val bm = BitmapFactory.decodeStream(inputStream)
            val stream = ByteArrayOutputStream()
            val byteArray: ByteArray = stream.toByteArray()

            //Log.i(“SANJAY “, “onActivityResult: “ + saveBitMap(this, bm));
            resultUri = Uri.fromFile(saveBitMap(requireContext(), bm))
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
    }


}