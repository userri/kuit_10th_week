package com.iyr.a10thweek

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.iyr.a10thweek.databinding.ActivityCalendarBinding
import java.util.Calendar

class CalendarActivity(dayList : ArrayList<String>) : AppCompatActivity() {
    lateinit var binding: ActivityCalendarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalendarBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvWeek.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        binding.rvDate.layoutManager = GridLayoutManager(this, 7)

        binding.rvWeek.adapter = WeekAdapter(arrayListOf("S", "M", "T", "W", "T", "F", "S"))

        val dayList = setDayList()
        binding.rvDate.adapter = DateAdapter(dayList)
    }

    private fun setDayList() : ArrayList<String>{
        var cal = Calendar.getInstance()
        cal.set(Calendar.DATE, 1)
        var startWeekday = cal.get(Calendar.DAY_OF_WEEK)
        var lastDay = cal.getActualMaximum(Calendar.DATE)

        if (cal.get(Calendar.MONTH) == 0) {
            cal.set(Calendar.YEAR - 1, 11, 1)
        } else {
            cal.set(Calendar.YEAR, Calendar.MONTH - 1, 1)
        }

        var previousMonthLastDay = cal.getActualMaximum(Calendar.DATE)

        var dayList = ArrayList<String>()


        for (i in startWeekday - 4 downTo 0) {
            dayList.add((previousMonthLastDay - i).toString())
        }
        for (i in 1..lastDay)
            dayList.add(i.toString())
        var dayCount = 1
        while (dayList.size < 42) {
            dayList.add(dayCount.toString())
            dayCount++
        }

        return dayList

    }
}