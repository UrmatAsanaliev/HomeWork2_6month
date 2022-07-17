package com.example.homework2_6month

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.homework2_6month.PromptUtils.negativeButton
import com.example.homework2_6month.PromptUtils.positiveButton
import com.example.homework2_6month.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private lateinit var adapter: NamesAdapter
    private var namesList = mutableListOf<NamesModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        initNames()
        initAdapter()
    }

    private fun initAdapter() {
        adapter = NamesAdapter { pos ->
            initAlert(pos)
        }
        adapter.addNames(namesList)
        binding.rvMain.adapter = adapter
    }

    fun initAlert(pos : Int){
            PromptUtils.alertDialog(this) {
                setTitle("Удалить?")
                positiveButton(){
                    adapter.deleteNames(pos)
                    showToast("Успешно удалено!")
                }
                negativeButton(){
                    showToast("Не удалено!")
                }
                show()
            }
    }

    private fun initNames() {
        namesList.add(NamesModel("Арбын"))
        namesList.add(NamesModel("Марал"))
        namesList.add(NamesModel("Бека"))
        namesList.add(NamesModel("Байел"))
        namesList.add(NamesModel("Аскат"))
        namesList.add(NamesModel("Жаныш"))
        namesList.add(NamesModel("Жамалдин"))
        namesList.add(NamesModel("Сабзиро"))
        namesList.add(NamesModel("Азирет"))
        namesList.add(NamesModel("Эдилбек"))
        namesList.add(NamesModel("Залкар"))
        namesList.add(NamesModel("Тимур"))
        namesList.add(NamesModel("Удан"))
        namesList.add(NamesModel("Жанболот"))
    }
}