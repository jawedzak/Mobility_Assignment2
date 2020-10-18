package sheridan.jawedzak.assignment2.ui.history

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import sheridan.jawedzak.assignment2.R
import sheridan.jawedzak.assignment2.database.GameScore
import sheridan.jawedzak.assignment2.ui.roller.RollerViewModel

/**
 * [RecyclerView.Adapter] that can display a [DummyItem].
 * TODO: Replace the implementation with code for your data type.
 */
class HistoryRecyclerViewAdapter(private val context: Context) : RecyclerView.Adapter<HistoryRecyclerViewAdapter.ViewHolder>() {

    var history: List<GameScore>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }

    var total: List<GameScore>? = null
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_history_item, parent, false)
        return ViewHolder(view)
//
//        val idView: TextView = view.findViewById(R.id.totalScore)
//        idView.text = total.toString()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gameScore = history!![position]
        holder.idView.text = "${position + 1}."
        holder.contentView.text =  "${gameScore.dice1}"  + " + " + "${gameScore.dice2}" + " + " + "${gameScore.dice3}" + " = " + "${gameScore.total}"
    }

    override fun getItemCount(): Int = history?.size ?: 0

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val idView: TextView = view.findViewById(R.id.item_number)
        val contentView: TextView = view.findViewById(R.id.content)

        override fun toString(): String {
            return super.toString() + " '" + contentView.text + "'"
        }
    }
}