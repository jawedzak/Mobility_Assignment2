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

    var randomInt1 = 0
    var randomInt2 = 0
    var randomInt3 = 0
    var sum = 0

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

        randomInt1 = Random.nextInt(6) + 1
        binding.num1.text = randomInt1.toString()

        randomInt2 = Random.nextInt(6) + 1
        binding.num2.text = randomInt2.toString()

        randomInt3 = Random.nextInt(6) + 1
        binding.num3.text = randomInt3.toString()

        //get the total
        sum = randomInt1 + randomInt2 + randomInt3
        binding.total.text = sum.toString()

        viewModel.send(GameScore(0,randomInt1,randomInt2,randomInt3,sum))
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        if (savedInstanceState != null){
            randomInt1 = savedInstanceState.getInt("savedInt1", 0)
            binding.num1.text = randomInt1.toString()

            randomInt2 = savedInstanceState.getInt("savedInt2", 0)
            binding.num2.text = randomInt2.toString()

            randomInt3 = savedInstanceState.getInt("savedInt3", 0)
            binding.num3.text = randomInt3.toString()

            sum = savedInstanceState.getInt("savedInt4", 0)
            binding.total.text = sum.toString()

        }


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

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt("savedInt1", randomInt1)
        outState.putInt("savedInt2", randomInt2)
        outState.putInt("savedInt3", randomInt3)
        outState.putInt("savedInt4", sum)
    }

}