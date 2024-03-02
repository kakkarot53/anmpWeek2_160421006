package com.ubaya.anmpweek2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.navigation.Navigation
import com.ubaya.anmpweek2.databinding.FragmentMainBinding
import kotlin.random.Random

class MainFragment : Fragment() {
    private lateinit var binding: FragmentMainBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(
            inflater,
            container, false
        )
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var ans = NewQuestion()
        var score = 0
        binding.btnSubmit.setOnClickListener {
            val input = binding.txtAnswer.editText?.text.toString()

            if(input==ans.toString()){
                score++
                ans = NewQuestion()
                binding.txtAnswer.editText?.setText("")
            }
            else{
                val action = MainFragmentDirections.actionGameFragment(score)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    fun NewQuestion(): Int {
        val num1 = Random.nextInt(1, 101)
        val num2 =  Random.nextInt(1, 101)

        binding.txtQuestion.text = num1.toString() +" + "+num2.toString()

        return (num1+num2)
    }
}