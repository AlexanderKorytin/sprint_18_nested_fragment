package com.example.sprint_18_nested_fragment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

// Главное активити, к которому будут привязаны наши фрагменты.
class MainActivity : AppCompatActivity(),
    SongNameProvider {

    override fun getSongName(): String = "Muse - Starlight"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            /**
             * Отображаем родительский фрагмент, в который дальше добавим переключение между
             * вложенными фрагментами.
             */
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, FragmentA.getInstance(getSongName()))
                .commit()
        }
    }
}