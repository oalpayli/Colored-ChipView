package com.ceng.ozi.androidcoloredchipview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.ceng.ozi.coloredchipview.ChipView
import com.google.android.material.chip.ChipGroup

class MainActivity : AppCompatActivity() {

    private lateinit var chipGroup: ChipGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chipGroup = findViewById(R.id.chip_group)

        addChips()
    }

    private fun addChips() {
        val chipViewWork = ChipView(this)
        chipViewWork.tag = "Work"
        chipViewWork.text = "Work"
        chipViewWork.setColor(ContextCompat.getColor(this, R.color.chip_work))
        chipGroup.addView(chipViewWork)

        val chipViewPersonal = ChipView(this)
        chipViewPersonal.tag = "Personal"
        chipViewPersonal.text = "Personal"
        chipViewPersonal.setColor(ContextCompat.getColor(this, R.color.chip_personal))
        chipGroup.addView(chipViewPersonal)

        val chipViewMeeting = ChipView(this)
        chipViewMeeting.tag = "Meeting"
        chipViewMeeting.text = "Meeting"
        chipViewMeeting.setColor(ContextCompat.getColor(this, R.color.chip_meeting))
        chipGroup.addView(chipViewMeeting)

        val chipViewStudy = ChipView(this)
        chipViewStudy.tag = "Study"
        chipViewStudy.text = "Study"
        chipViewStudy.setColor(ContextCompat.getColor(this, R.color.chip_study))
        chipGroup.addView(chipViewStudy)

        val chipViewShopping = ChipView(this)
        chipViewShopping.tag = "Shopping"
        chipViewShopping.text = "Shopping"
        chipViewShopping.setColor(ContextCompat.getColor(this, R.color.chip_shopping))
        chipGroup.addView(chipViewShopping)
    }
}