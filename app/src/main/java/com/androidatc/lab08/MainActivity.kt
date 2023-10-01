package com.androidatc.lab08

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.SeekBar
import android.widget.TextView
import java.util.Calendar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var slider: SeekBar
        lateinit var value: TextView
        lateinit var dateBtn:Button
        lateinit var dateText:TextView
        lateinit var timeBtn:Button
        lateinit var timeText:TextView

        slider = findViewById(R.id.mySeekBar)
        value = findViewById(R.id.myPizzaSize)
        dateBtn = findViewById(R.id.dateBtn)
        dateText = findViewById(R.id.dateText)
        timeBtn = findViewById(R.id.timeBtn)
        timeText = findViewById(R.id.timeText)
        val pizzaSize = arrayListOf<String>("Please Select", "Small", "Medium", "Large", "Extra-Large")

        dateBtn.setOnClickListener{
            val c = Calendar.getInstance()
            val day= c.get(Calendar.DAY_OF_MONTH)
            val month =c.get(Calendar.MONTH)
            val year =c.get(Calendar.YEAR)
            val myDatePicker = DatePickerDialog(this,android.R.style.ThemeOverlay,DatePickerDialog.OnDateSetListener {
                    DatePicker, Year,Month,Day ->
                dateText.text="$Day/ ${Month+1} /$Year"},year,month,day)
            myDatePicker.show()
        }

        timeBtn.setOnClickListener{
            val c = Calendar.getInstance()
            val hour =c.get(Calendar.HOUR_OF_DAY)
            val minutes =c.get(Calendar.MINUTE)
            val myTimePicker= TimePickerDialog(this,TimePickerDialog.OnTimeSetListener {
                    TimePicker, hourOfDay, minute -> timeText.text="$hourOfDay :  $minute"},hour,minutes,true)
            myTimePicker.show()
        }

        slider.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                // Update the value TextView with the selected pizza size
                value.text = pizzaSize[progress]
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                // Not needed in this implementation
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                // Not needed in this implementation
            }
        })
    }
}
