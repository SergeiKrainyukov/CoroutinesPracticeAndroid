package com.example.coroutinespracticeandroid.lesson1

import androidx.appcompat.app.AppCompatActivity
import com.example.coroutinespracticeandroid.R
import com.example.coroutinespracticeandroid.showToast

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onResume() {
        super.onResume()

        performLongOperation1 { result1 ->
            runOnUiThread {
                showToast(result1)
            }
            performLongOperation2 { result2 ->
                runOnUiThread {
                    showToast(result1.plus("\n").plus(result2))
                }
            }
        }
    }

    private fun performLongOperation1(callback: (String) -> Unit) {
        Thread {
            Thread.sleep(4000)
            val result = "Данные получены из источника 1"
            callback(result)
        }.start()
    }

    private fun performLongOperation2(callback: (String) -> Unit) {
        Thread {
            Thread.sleep(8000)
            val result = "Данные получены из источника 2"
            callback.invoke(result)
        }.start()
    }
}