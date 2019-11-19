package com.myozawoo.mmcalendar.view

import android.content.Context
import android.util.Log
import com.myozawoo.mmcalendar.CalendarDay
import org.threeten.bp.DayOfWeek
import org.threeten.bp.LocalDate
import org.threeten.bp.temporal.WeekFields
import java.util.*

class MonthView (context: Context,
                 private var month: CalendarDay)
    : CalendarView(context, month, WeekFields.of(Locale.getDefault()).firstDayOfWeek) {

    override fun buildDayViews(dayViews: Collection<DayView>, calendar: LocalDate) {
        var temp = calendar
        for (r in 0 until DEFAULT_MAX_WEEK) {
            for (i in 0 until DEFAULT_DAYS_IN_WEEK) {
                addDayView(dayViews, temp)
                showLog(temp.toString())
                temp = temp.plusDays(1)
            }
        }
    }

    override fun getRows(): Int {
        return DEFAULT_MAX_WEEK
    }

    fun getMonth(): CalendarDay {
        return getFirstViewDay()
    }

    private fun showLog(message: String) {
        Log.d(javaClass.simpleName, message)
    }


}