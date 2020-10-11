package com.example.retailgully_packagingapp.ui.account

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.artdeza.app.helper.EasyPrefrences
import com.example.retailgully_packagingapp.R
import com.example.retailgully_packagingapp.ui.auth.LoginActivity
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.mcsandroid.myapplication.helper.PreferenceManager
import kotlinx.android.synthetic.main.bottom_sheet_logout.view.*
import kotlinx.android.synthetic.main.fragment_account.view.*
import kotlinx.android.synthetic.main.fragment_account.view.btn_logout
import kotlinx.android.synthetic.main.home_action_bar.view.*
import kotlinx.android.synthetic.main.home_action_bar.view.header

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AccountFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AccountFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

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
        var v = inflater.inflate(R.layout.fragment_account, container, false)
        v.ac_user_name.text=EasyPrefrences(requireContext()).getString("name")
        v.ac_user_detail.text=EasyPrefrences(requireContext()).getString("email")
        v.header.text = "Account"
        v.btn_logout.setOnClickListener {
            logout(v.context)
        }
        return v
    }

    fun logout(context: Context) {


        val mBottomSheetDialog = BottomSheetDialog(context)
        val sheetView = layoutInflater.inflate(R.layout.bottom_sheet_logout, null)
        mBottomSheetDialog.setContentView(sheetView)
        mBottomSheetDialog.show()
        val btn_logout = sheetView.btn_logout
        val tv_cancel = sheetView.tv_cancel

        btn_logout.setOnClickListener {

            val intent1 = Intent(context, LoginActivity::class.java)
            val pManager = PreferenceManager(context)
            pManager.setFirstTimeLaunch(true)
            val pref = EasyPrefrences(context)
            pref.clear()
            startActivity(intent1)
            val pref2: SharedPreferences =
                context.getSharedPreferences("readymealz", 0) // 0 - for private mode
            val editor = pref2.edit()
            editor.remove("userData")
            editor.remove("defaultAddress")
            editor.remove("cart")
            editor.apply()
            mBottomSheetDialog.dismiss()
            activity?.finish()

        }


        tv_cancel.setOnClickListener {
            mBottomSheetDialog.dismiss()
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AccountFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AccountFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}