package com.debug.presenter.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.debug.domain.model.Category
import com.debug.meals.databinding.ItemCategoryBinding
import com.debug.presenter.model.CategoryUiModel

class CategoriesAdapter(
    private val categories: List<CategoryUiModel>
) : RecyclerView.Adapter<CategoriesAdapter.CategoriesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        val itemView =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoriesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        val category = categories[position]

        with(holder) {
            binding.tvMeal.text = category.name
            binding.ivMeal.load(category.thumb)
        }
    }

    override fun getItemCount() = categories.size

    inner class CategoriesViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)
}