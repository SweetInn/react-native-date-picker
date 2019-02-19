package com.henninghall.date_picker.wheels;

import com.henninghall.date_picker.Mode;
import com.henninghall.date_picker.PickerView;
import java.util.Calendar;
import java.util.Date;

import cn.carbswang.android.numberpickerview.library.NumberPickerView;


public class MinutesWheel extends Wheel {

    public MinutesWheel(PickerView pickerView, int id) {
        super(pickerView, id);
    }

    @Override
    void init() {
        Calendar cal = pickerView.getInitialDate();
        cal.set(Calendar.MINUTE, 0);

        for(int i=0; i<60; i = i + pickerView.minuteInterval) {
            this.values.add(format.format(cal.getTime()));
            this.displayValues.add(format.format(cal.getTime()));
            cal.add(Calendar.MINUTE, pickerView.minuteInterval);
        }
        picker.setDisplayedValues(this.values.toArray(new String[0]));
        picker.setMinValue(0);
        picker.setMaxValue(this.values.size() - 1);
    }

    @Override
    public boolean visible() {
        return pickerView.mode != Mode.date;
    }

    @Override
    public String getFormatTemplate() {
        return "mm";
    }

}
