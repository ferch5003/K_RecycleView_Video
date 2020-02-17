package com.uninorte.k_recycleview_video


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.uninorte.k_recycleview_video.data.User
import kotlinx.android.synthetic.main.fragment_main.view.*

/**
 * A simple [Fragment] subclass.
 */
class MainFragment : Fragment(), MyUserRecyclerViewAdapter.onListInteraction {

    val users = mutableListOf<User>()
    private var adapter: MyUserRecyclerViewAdapter? ? = null
    var count: Int = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main, container, false)

        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Jackie","Brown","jackie.brown@example.com","(306)-986-6207"))
        users.add(User("Mr","Andrew","Banks","andrew.banks@example.com","(413)-841-9132"))
        users.add(User("Miss","Maxine","Davis","maxine.davis@example.com","(688)-210-1102"))
        users.add(User("Mr","Andy","James","andy.james@example.com","(975)-949-2306"))
        users.add(User("Miss","Joan","Neal","joan.neal@example.com","(687)-164-3498"))
        users.add(User("Mr","Tony","Castro","tony.castro@example.com","(910)-821-7461"))
        users.add(User("Miss","Ella","Kelly","ella.kelly@example.com","(480)-375-6719"))
        users.add(User("Miss","Maureen","Graves","maureen.graves@example.com","(416)-008-3131"))
        users.add(User("Mr","Johnni","Edwards","johnni.edwards@example.com","(609)-729-5743"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))
        users.add(User("Miss","Shelly","Ferguson","shelly.ferguson@example.com","(908)-530-2357"))


        adapter = MyUserRecyclerViewAdapter(users, this)

        view.list.layoutManager = LinearLayoutManager(context)
        view.list.adapter = adapter

        return view
    }

    override fun onListItemInteraction(item: User?) {
    }

    override fun onListButtonInteraction(item: User?) {
        users.remove(item)
        adapter!!.updateData()
    }


}
