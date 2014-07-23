package com.hacktoolkit.tipcalculator.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.hacktoolkit.android.tipcalculator.R;
import com.hacktoolkit.android.utils.HTKUtils;
import com.hacktoolkit.tipcalculator.constants.AppConstants;

public class TipCalculatorActivity extends Activity {
	EditText etAmount;
	TextView tvTipDisplay;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tip_calculator);
		
		etAmount = (EditText) findViewById(R.id.etAmount);
		tvTipDisplay = (TextView) findViewById(R.id.tip_display);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tip_calculator, menu);
		return true;
	}

	public void calculateTip(View view) {
		int id = view.getId();
		String value = etAmount.getText().toString();
		if (!value.equals(AppConstants.EMPTY_STRING)) {
			float amount = Float.parseFloat(value);
			float tipPercentage = .10f;
			float tipAmount;
			if (id == R.id.button_tip_10) {
				tipPercentage = .10f;
			} else if (id == R.id.button_tip_15) {
				tipPercentage = .15f;
			} else if (id == R.id.button_tip_20) {
				tipPercentage = .20f;
			} else {
				// do nothing
			}
			tipAmount = amount * tipPercentage;
			tvTipDisplay.setText(String.format("$%.2f", tipAmount));
			HTKUtils.hideSoftKeyboard(this, view);
		}
	}
}
