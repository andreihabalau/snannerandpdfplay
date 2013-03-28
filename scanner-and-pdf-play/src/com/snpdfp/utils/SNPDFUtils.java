package com.snpdfp.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.app.Activity;
import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;

import com.snpdfp.activity.R;

public class SNPDFUtils {

	public static void setErrorText(Activity activity, String message) {
		TextView textView = (TextView) activity.findViewById(R.id.message);
		ImageView imageView = (ImageView) activity.findViewById(R.id.imageOP);

		textView.setText(message);
		textView.setTextColor(Color.parseColor("#FF0040"));

		imageView.setImageResource(R.drawable.wrong);

	}

	public static void setSuccessText(Activity activity, String message,
			File file) {
		TextView textView = (TextView) activity.findViewById(R.id.message);
		ImageView imageView = (ImageView) activity.findViewById(R.id.imageOP);

		String fileDetails = "Filename:"
				+ file.getName()
				+ "\nSize:"
				+ SNPDFUtils.getSizeText(file.length())
				+ "\nDate Modified:"
				+ new SimpleDateFormat(SNPDFCContstants.DATE_FORMAT,
						Locale.getDefault()).format(new Date(file
						.lastModified()));
		textView.setText(message + "\n" + fileDetails);
		textView.setTextColor(Color.parseColor("#298A08"));

		imageView.setImageResource(R.drawable.correct);
	}

	public static String getSizeText(long length) {
		if (length < 1024)
			return length + " B";
		int exp = (int) (Math.log(length) / Math.log(1024));
		String pre = "KMGTPE".charAt(exp - 1) + "";
		return String.format("%.1f %sB", length / Math.pow(1024, exp), pre);
	}

	public static void setErrorText(TextView textView, String message) {
		textView.setText(message);
		textView.setTextColor(Color.parseColor("#FF0040"));
	}

}