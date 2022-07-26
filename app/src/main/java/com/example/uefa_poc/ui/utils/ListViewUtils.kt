package com.example.uefa_poc.viewmodels

import android.view.View
import android.view.ViewGroup
import android.widget.ListAdapter
import android.widget.ListView

object UIUtils {
    fun setListViewHeightBasedOnItems(listView: ListView): Boolean {
        val listAdapter: ListAdapter = listView.adapter
        return run {
            val numberOfItems: Int = listAdapter.count

            // Get total height of all items.
            var totalItemsHeight = 0
            for (itemPos in 0 until numberOfItems) {
                val item: View = listAdapter.getView(itemPos, null, listView)
                item.measure(0, 0)
                totalItemsHeight += item.measuredHeight
            }

            // Get total height of all item dividers.
            val totalDividersHeight: Int = listView.dividerHeight *
                    (numberOfItems - 1)

            // Set list height.
            val params: ViewGroup.LayoutParams = listView.layoutParams
            params.height = totalItemsHeight + totalDividersHeight + 50
            listView.layoutParams = params
            listView.requestLayout()
            true
        }
    }
}