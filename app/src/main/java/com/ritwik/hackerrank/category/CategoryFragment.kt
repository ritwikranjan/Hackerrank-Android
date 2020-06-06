package com.ritwik.hackerrank.category

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment.findNavController
import com.ritwik.hackerrank.databinding.FragmentCategoryBinding

class CategoryFragment : Fragment() {

    private lateinit var binding: FragmentCategoryBinding
    private lateinit var viewModel: CategoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCategoryBinding.inflate(inflater)

        binding.lifecycleOwner = viewLifecycleOwner

        viewModel = ViewModelProvider(this).get(CategoryViewModel::class.java)

        binding.viewModel = viewModel

        binding.categoryList.adapter = viewModel.adapter

        viewModel.navigateToQuestions.observe(viewLifecycleOwner, Observer {
            it?.let {
                findNavController(this).navigate(CategoryFragmentDirections.actionCategoryFragmentToQuestionsFragment(it))
                viewModel.onDoneNavigation()
            }
        })

        return binding.root
    }

}