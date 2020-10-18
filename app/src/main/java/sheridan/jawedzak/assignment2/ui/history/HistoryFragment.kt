package sheridan.jawedzak.assignment2.ui.history

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import sheridan.jawedzak.assignment2.R
import androidx.fragment.app.viewModels

/**
 * A fragment representing a list of Items.
 */
class HistoryFragment : Fragment() {

    private lateinit var adapter: HistoryRecyclerViewAdapter

    private val viewModel: HistoryViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_history, container, false)

        // Set the adapter
        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        adapter = HistoryRecyclerViewAdapter(view.context)
        recyclerView.adapter = adapter

        viewModel.history.observe(viewLifecycleOwner){ adapter.history = it}

//        val total: TextView = view.findViewById(R.id.totalScore)
//        total.text = viewModel.total().toString()

        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_history, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_clear -> {
                viewModel.clear()
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}