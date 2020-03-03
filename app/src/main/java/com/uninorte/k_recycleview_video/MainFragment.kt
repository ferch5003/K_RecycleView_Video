package com.uninorte.k_recycleview_video


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.uninorte.k_recycleview_video.data.RandomUser
import com.uninorte.k_recycleview_video.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*
import org.json.JSONArray
import org.json.JSONObject

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), UserAdapter.onListInteraction {

    val users = mutableListOf<User>()
    private var adapter: UserAdapter? = null
    private lateinit var viewModel: RandomUserViewModel
    private var userList = mutableListOf<RandomUser>()
    lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        viewModel = ViewModelProvider(this).get(RandomUserViewModel::class.java)

        viewModel.addUsers()

        adapter = UserAdapter(users, this)

        loadData()

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        return view
    }

    private fun loadData(){
        viewModel.getUsers().observe(viewLifecycleOwner, Observer { obsUsers ->
            run {
                userList = obsUsers as MutableList<RandomUser>

                for (randUser in userList) {

                    var user = User(
                        randUser.name.title, randUser.name.first, randUser.name.last,
                        randUser.email,
                        randUser.phone,
                        randUser.picture.large
                    )
                    users.add(user)
                }
                adapter!!.updateData()
            }
        })
    }

    override fun onListItemInteraction(item: User?) {
    }

    override fun onListCardInteraction(item: User?) {
        val bundle = bundleOf("data" to item, "user" to item)
        navController.navigate(R.id.informationFragment,bundle)
    }


}
