package com.example.sprint_18_nested_fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.example.sprint_18_nested_fragment.databinding.FramentABinding

class FragmentA: Fragment() {
    private var _binding:FramentABinding? = null
    private val binding get() = _binding!!

    companion object{
        const val KEY_SONG = "Key_Song"
        fun newInstance(song: String) = FragmentA().apply { arguments  = bundleOf(KEY_SONG to song) }
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FramentABinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val song = requireArguments().getString(KEY_SONG)
        binding.songName.text = song
        childFragmentManager.commit {
            add<NestedFragmentA>(R.id.fragment_child_container)
        }
    }
}