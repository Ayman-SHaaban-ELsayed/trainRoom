package com.ayman.roomdatabasetraining.fragment.adduser

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ayman.roomdatabasetraining.R
import com.ayman.roomdatabasetraining.data.User
import com.ayman.roomdatabasetraining.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add_user.*
import kotlinx.android.synthetic.main.fragment_add_user.view.*

class AddUserFragment : Fragment() {
    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_add_user, container, false)
        view.add_btn.setOnClickListener {
            insertDataToDatbase()


        }

        return view
    }

    private fun insertDataToDatbase() {
        val firstName = add_first_name.text.toString()
        val SecondName = add_second_name.text.toString()
        val age = add_age_name.text
        if (inputCheck(firstName, SecondName, age)) {
            val user = User(0, firstName, SecondName, Integer.parseInt(age.toString()))
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_LONG).show()
            // Navigate Back
            findNavController().navigate(R.id.action_addUserFragment_to_listOfOfUsersFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, SecondName: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(SecondName) && age.isEmpty())
    }


}