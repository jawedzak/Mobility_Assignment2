package sheridan.jawedzak.assignment2.ui.roller

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import sheridan.jawedzak.assignment2.R
import sheridan.jawedzak.assignment2.database.GameScore
import sheridan.jawedzak.assignment2.databinding.FragmentRollerBinding
import kotlin.random.Random

class RollerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    private lateinit var binding: FragmentRollerBinding
    private lateinit var viewModel: RollerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRollerBinding.inflate(inflater, container, false)
        //return inflater.inflate(R.layout.fragment_roller, container, false)

    binding.rollButton.setOnClickListener { rollDice()}

        return binding.root
    }

    private fun rollDice(){
        //Toast.makeText(this, "", Toast.LENGTH_SHORT).show()

        val randomInt1 = Random.nextInt(6) + 1
        binding.num1.text = randomInt1.toString()

        val randomInt2 = Random.nextInt(6) + 1
        binding.num2.text = randomInt2.toString()

        val randomInt3 = Random.nextInt(6) + 1
        binding.num3.text = randomInt3.toString()

        //get the total
        val total = randomInt1 + randomInt2 + randomInt3
        binding.total.text = total.toString()

        viewModel.send(GameScore(0,randomInt1,randomInt2,randomInt3,total))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RollerViewModel::class.java)
        // TODO: Use the ViewModel
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_roller, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_history -> {
                findNavController().navigate(R.id.action_global_to_history)
                true
            }
            else -> super.onOptionsItemSelected(item)
    }
    }
}