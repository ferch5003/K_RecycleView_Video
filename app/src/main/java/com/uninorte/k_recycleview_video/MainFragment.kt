package com.uninorte.k_recycleview_video


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
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
    lateinit var navController: NavController
    var count: Int = 0

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

        loadData()

        adapter = UserAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        return view
    }

    private fun loadData(){
        val queue = Volley.newRequestQueue(activity)
        val url = "https://randomuser.me/api/?results=20"

        // Request a string response from the provided URL.
        val stringRequest = StringRequest(
            Request.Method.GET, url,
            Response.Listener<String> { response ->
                var strResp = response.toString()
                val jsonObj = JSONObject(strResp)
                val jsonArray: JSONArray = jsonObj.getJSONArray("results")
                for (i in 0 until jsonArray.length()) {
                    var jsonInner: JSONObject = jsonArray.getJSONObject(i)
                    var name: JSONObject = jsonInner.get("name") as JSONObject
                    var picture: JSONObject = jsonInner.get("picture") as JSONObject

                    var user = User(
                        name.get("title") as String, name.get("first") as String, name.get("last") as String,
                        jsonInner.get("email") as String,
                        jsonInner.get("phone") as String,
                        picture.get("large") as String
                    )
                    users.add(user)
                }
                adapter!!.updateData()
            },
            Response.ErrorListener {
            })

        // Add the request to the RequestQueue.
        queue.add(stringRequest)
    }

    override fun onListItemInteraction(item: User?) {
    }

    override fun onListCardInteraction(item: User?) {
        val bundle = bundleOf("data" to item, "user" to item)
        navController.navigate(R.id.informationFragment,bundle)
    }


}
