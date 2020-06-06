package com.ritwik.hackerrank.questions

import android.app.Application
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.ritwik.hackerrank.databinding.FragmentQuestionsBinding

class QuestionsFragment : Fragment() {

    private lateinit var binding: FragmentQuestionsBinding
    private lateinit var viewModel: QuestionsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val args = QuestionsFragmentArgs.fromBundle(requireArguments())
        binding = FragmentQuestionsBinding.inflate(inflater)

        viewModel =
            ViewModelProvider(this, QuestionsViewModelFactory(args.category, Application())).get(
                QuestionsViewModel::class.java
            )
        binding.viewModel = viewModel

        binding.questionList.adapter = viewModel.adapter
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.questionLink.observe(viewLifecycleOwner, Observer {
            it?.let {
                var url: String = it
                if (!url.contains("http://") || !url.contains("https://")) url = "http://$url"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
                viewModel.onDoneLink()
            }
        })

        return binding.root
    }

}