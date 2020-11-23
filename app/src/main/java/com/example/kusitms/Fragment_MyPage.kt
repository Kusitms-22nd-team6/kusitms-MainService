package com.example.kusitms

import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_mypage.*
import com.example.kusitms.LoginActivity
import com.google.firebase.database.*

/**
 * A simple [Fragment] subclass.
 */



class Fragment_MyPage : Fragment() {

    private var root: View? = null

    val user = Firebase.auth.currentUser
    val uid = user?.uid

    val database : FirebaseDatabase = FirebaseDatabase.getInstance()
    val myPage : DatabaseReference = database.getReference("my_page")
    val myUser : DatabaseReference = myPage.child(uid.toString())
    val myName : DatabaseReference = myUser.child("name")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_mypage, container, false)
        return root
    }

    override fun onResume() {
        super.onResume()
        init()

        //ui적으로 수정된 것을 나타낼 방법 필요
        nameedit.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                myPage.child(uid.toString()).child("privacy").child("name").setValue(name.getText().toString())


            }
        })
    }

    fun init() {
        Glide.with(this).load(R.drawable.membershipicon1).circleCrop().into(membershipIcon);
        Glide.with(this).load(R.drawable.user).circleCrop().into(mypage_personalimg);
//        var rDatabase = database.getReference("Activity").child()
    }


}
