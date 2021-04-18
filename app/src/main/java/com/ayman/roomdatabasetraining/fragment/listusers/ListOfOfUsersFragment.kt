package com.ayman.roomdatabasetraining.fragment.listusers

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.ayman.roomdatabasetraining.R
import com.ayman.roomdatabasetraining.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_list_of_of_users.view.*


class ListOfOfUsersFragment : Fragment() {
    /** AYMAN
    How created nave:
    from Resources manager panel Choosed from above Navigation then pressed + button
    then pressed Navigation resource file then name it
    when navigation.xml opened press + button and create new destination "fragment"
    then connect them to each others
    go to  activity_main.xml and add nav host fragment to the constraint
     */

    private lateinit var mUserViewModel: UserViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_list_of_of_users, container, false)
        val adapter= ListUsersAdapter()

        //RecyclerViw
        val recyclerView = view.recycle_view_list
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        //UserViewModel
        mUserViewModel=ViewModelProvider(this).get(UserViewModel::class.java)
        mUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { user ->
            adapter.setData(user)

        })

        view.floatingActionButton1.setOnClickListener {
            findNavController().navigate(R.id.action_listOfOfUsersFragment_to_addUserFragment)
        }

        return view
    }


}