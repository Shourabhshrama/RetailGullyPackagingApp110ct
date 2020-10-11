package com.example.retailgully_packagingapp.ui.home

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.MeasureSpec
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.retailgully_packagingapp.R
import com.mazenrashed.printooth.Printooth
import com.mazenrashed.printooth.data.PrintingImagesHelper
import com.mazenrashed.printooth.data.converter.Converter
import com.mazenrashed.printooth.data.printable.ImagePrintable
import com.mazenrashed.printooth.data.printable.Printable
import com.mazenrashed.printooth.data.printable.TextPrintable
import com.mazenrashed.printooth.data.printer.Printer
import com.mazenrashed.printooth.ui.ScanningActivity
import kotlinx.android.synthetic.main.fragment_print.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.*
import java.io.ByteArrayOutputStream


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [PrintFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class PrintFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var root = inflater.inflate(R.layout.fragment_print, container, false)
        root.header.text = "Invoice"
        root.webView.getSettings().setJavaScriptEnabled(true);
        webView = root.webView
        root.webView.getSettings().setDomStorageEnabled(true); // Try
        root.webView.getSettings().setSupportZoom(false);
        root.webView.getSettings().setAllowFileAccess(true);
        root.webView.getSettings().setAllowContentAccess(true);
        root.webView.webViewClient = WebViewClient()
        root.webView.webChromeClient = WebChromeClient()
        param1?.let { root.webView.loadUrl(it) };

        root.fab_print.setOnClickListener {

//            val printManager =
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//                    activity?.getSystemService(Context.PRINT_SERVICE) as PrintManager
//                } else {
//                    TODO("VERSION.SDK_INT < KITKAT")
//                }
//
//            //create object of print adapter
//
//            //create object of print adapter
//            val printAdapter: PrintDocumentAdapter = root.webView.createPrintDocumentAdapter()
//
//            //provide name to your newly generated pdf file
//
//            //provide name to your newly generated pdf file
//            val jobName = getString(R.string.app_name) + " Print Test"
//
//            //open print dialog
//
//            //open print dialog
//            printManager.print(jobName, printAdapter, PrintAttributes.Builder().build())
//
            context?.let { it1 -> Printooth.init(it1) };
            startActivityForResult(
                Intent(context, ScanningActivity::class.java),
                ScanningActivity.SCANNING_FOR_PRINTER
            )
        }
        root.iv_back_store.setOnClickListener {
            fragmentManager?.popBackStack()
        }
        return root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ScanningActivity.SCANNING_FOR_PRINTER && resultCode == Activity.RESULT_OK) {


            val printables = ArrayList<Printable>().apply {


                add(ImagePrintable.Builder(screenshot2(webView)).build())
            }

            Printooth.printer().print(printables)
        }


        //Printer is ready now
    }

    fun screenshot2(webView: WebView): Bitmap {
        webView.measure(
            MeasureSpec.makeMeasureSpec(
                MeasureSpec.UNSPECIFIED, MeasureSpec.UNSPECIFIED
            ),
            MeasureSpec.makeMeasureSpec(0, MeasureSpec.UNSPECIFIED)
        )
        webView.layout(0, 0, webView.measuredWidth, webView.measuredHeight)
        webView.isDrawingCacheEnabled = true
        webView.buildDrawingCache()
        val bitmap = Bitmap.createBitmap(
            webView.measuredWidth,
            webView.measuredHeight, Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        val paint = Paint()
        val iHeight = bitmap.height.toFloat()
        val iWidth = bitmap.height.toFloat()
        canvas.drawBitmap(bitmap, iWidth, iHeight, paint)
        webView.draw(canvas)
        return bitmap
    }

    class MyPrintingImagesHelper : PrintingImagesHelper {
        override fun getBitmapAsByteArray(bitmap: Bitmap): ByteArray {
            return convertBitmapToByteArray(bitmap)
        }

        private fun convertBitmapToByteArray(bitmap: Bitmap): ByteArray {
            val stream = ByteArrayOutputStream()
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
            return stream.toByteArray()
        }
    }

    //in your printer class


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment PrintFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            PrintFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}