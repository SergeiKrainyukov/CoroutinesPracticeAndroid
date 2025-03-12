package com.example.coroutinespracticeandroid.lesson1

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.coroutinespracticeandroid.R
import com.example.coroutinespracticeandroid.showToast
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity2 : AppCompatActivity(R.layout.activity_main) {
    override fun onResume() {
        super.onResume()

        lifecycleScope.launch {
            val result1 = performLongOperation1()
            showToast(result1)

            val result2 = performLongOperation2()
            showToast(result1.plus("\n").plus(result2))
        }
    }

    private suspend fun performLongOperation1(): String {
        delay(4000)
        return "Данные получены из источника 1"
    }

    private suspend fun performLongOperation2(): String {
        delay(8000)
        return "Данные получены из источника 2"
    }

}