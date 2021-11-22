package com.ceng.ozi.coloredchipview

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.core.content.ContextCompat
import com.ceng.ozi.coloredchipview.util.dp
import com.google.android.material.chip.Chip

class ChipView(
    context: Context
) : Chip(context, null, R.style.Category_Chip) {

    private var color: Int? = null

    init {
        chipIcon = ContextCompat.getDrawable(context, R.drawable.ic_chip_dot)
        isChipIconVisible = true
        chipIconSize = context
            .resources
            .getDimension(R.dimen.default_colored_chip_icon_size)
            .toInt().dp.toFloat()

        textSize = context
            .resources
            .getDimension(R.dimen.default_colored_chip_text_size)
            .toInt().dp.toFloat()
        setTextColorForCheckState()

        chipCornerRadius = context
            .resources
            .getDimension(R.dimen.default_color_chip_corner_radius)

        isClickable = true
        isCheckable = true
        isCheckedIconVisible = false

        setOnCheckedChangeListener { buttonView, isChecked ->
            isChipIconVisible = !isChecked
        }
    }

    private fun setTextColorForCheckState() {
        val statesColorArray: Array<IntArray> = getCheckedStatesColorArray()

        val colorArray = intArrayOf(
            ContextCompat.getColor(context, R.color.chip_checked_text),
            ContextCompat.getColor(context, R.color.chip_unchecked_text)
        )

        setTextColor(ColorStateList(statesColorArray, colorArray))
    }

    fun setColor(@ColorInt value: Int) {
        this.color = value

        val statesColorArray: Array<IntArray> = getCheckedStatesColorArray()

        val colorArray = intArrayOf(
            this.color ?: R.color.design_default_color_primary,
            Color.TRANSPARENT
        )

        val statesChipColorArray: Array<IntArray> = arrayOf(
            intArrayOf(-android.R.attr.state_checked),
            intArrayOf(android.R.attr.state_checked)
        )

        val chipColorArray = intArrayOf(
            this.color ?: R.color.design_default_color_primary,
            Color.TRANSPARENT
        )

        chipBackgroundColor = ColorStateList(statesColorArray, colorArray)
        chipIconTint = ColorStateList(statesChipColorArray, chipColorArray)
    }

    private fun getCheckedStatesColorArray(): Array<IntArray> =
        arrayOf(
            intArrayOf(android.R.attr.state_checked),
            intArrayOf()
        )
}