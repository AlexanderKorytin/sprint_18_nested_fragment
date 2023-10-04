package com.example.sprint_18_nested_fragment

import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.sprint_18_nested_fragment.databinding.NestedFragmentBBinding

class NestedFragmentB : BindingFragment<NestedFragmentBBinding>() {

    override fun createBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): NestedFragmentBBinding {
        return NestedFragmentBBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Установка названия песни и передача данных Activity
        binding.songText.text = (requireActivity() as SongNameProvider).getSongName()
            .plus(other = " | B")

        /**
         * Тут так же при нажатии на кнопку заменяем фрагмент из "fragment_child_container" на
         * другой
         */
        binding.button.setOnClickListener {
            parentFragmentManager.commit {
                replace(R.id.fragment_child_container, NestedFragmentA())
            }
        }
    }
}