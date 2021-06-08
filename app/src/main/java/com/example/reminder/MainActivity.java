package com.example.reminder;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AlertDialogLayout;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.Constraints;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialStyledDatePickerDialog;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout main;
    private ArrayList<CardView> cards = new ArrayList<>();
    private Context context;
    private AlertDialog.Builder builder;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.scroll_layout);

        main = findViewById(R.id.main);
        context = getApplicationContext();
        builder = new AlertDialog.Builder(this);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            //Toast.makeText(MainActivity.this, "FAB clicked", Toast.LENGTH_SHORT).show();
            //createCardView();
            getInformation(builder);


        });
    }

    private void getInformation(AlertDialog.Builder builder) {


        //New Layout
        ConstraintLayout constraintLayout = new ConstraintLayout(MainActivity.this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT);
        constraintLayout.setLayoutParams(params);
        constraintLayout.setId(View.generateViewId());

        //EditText
        EditText editText = new EditText(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        editText.setLayoutParams(params);
        editText.setHint("Írd ide az emlékeztető leírását");
        editText.setId(View.generateViewId());

        constraintLayout.addView(editText);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(editText.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 50);
        constraintSet.connect(editText.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.TOP, 10);
        constraintSet.connect(editText.getId(), ConstraintSet.RIGHT, constraintLayout.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.applyTo(constraintLayout);

        //TextView
        TextView textView = new TextView(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        textView.setLayoutParams(params);
        textView.setText("Határidő: ");
        textView.setId(View.generateViewId());

        constraintLayout.addView(textView);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(textView.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 50);
        constraintSet.connect(textView.getId(), ConstraintSet.TOP, editText.getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.applyTo(constraintLayout);


        //Date
        /*TextView date = new TextView(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        date.setLayoutParams(params);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date now = new Date();
        date.setText(formatter.format(now));
        date.setId(View.generateViewId());

        date.setOnClickListener( v -> {
            Toast.makeText(MainActivity.this, "Date", Toast.LENGTH_SHORT).show();

            Calendar getDate = Calendar.getInstance();
            Integer startYear = getDate.get(Calendar.YEAR);
            Integer starthMonth = getDate.get(Calendar.MONTH);
            Integer startDay = getDate.get(Calendar.DATE);

            DatePickerDialog datePickerDialog = new DatePickerDialog(
                    context, DatePickListener(), startYear, starthMonth, startDay);
            datePickerDialog.show();

            MaterialDatePicker datePicker = MaterialDatePicker.Builder.datePicker()
                    .setTitleText("Select date")
                    .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                    .build();
            //datePicker.show();
        });

        constraintLayout.addView(date);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(date.getId(), ConstraintSet.LEFT, textView.getId(), ConstraintSet.RIGHT, 100);
        constraintSet.connect(date.getId(), ConstraintSet.TOP, editText.getId(), ConstraintSet.BOTTOM, 30);
        constraintSet.applyTo(constraintLayout);*/



        //EditText
        EditText editText1 = new EditText(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        editText1.setLayoutParams(params);
        editText1.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText1.setText("2020");
        editText1.setId(View.generateViewId());

        constraintLayout.addView(editText1);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(editText1.getId(), ConstraintSet.LEFT, textView.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(editText1.getId(), ConstraintSet.TOP, editText.getId(), ConstraintSet.BOTTOM, 10);
        constraintSet.applyTo(constraintLayout);


        EditText editText2 = new EditText(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        editText2.setLayoutParams(params);
        editText2.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText2.setText("06");
        editText2.setId(View.generateViewId());

        constraintLayout.addView(editText2);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(editText2.getId(), ConstraintSet.LEFT, editText1.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(editText2.getId(), ConstraintSet.TOP, editText.getId(), ConstraintSet.BOTTOM, 10);
        constraintSet.applyTo(constraintLayout);


        EditText editText3 = new EditText(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        editText3.setLayoutParams(params);
        editText3.setInputType(InputType.TYPE_CLASS_NUMBER);
        editText3.setText("07");
        editText3.setId(View.generateViewId());

        constraintLayout.addView(editText3);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(editText3.getId(), ConstraintSet.LEFT, editText2.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(editText3.getId(), ConstraintSet.TOP, editText.getId(), ConstraintSet.BOTTOM, 10);
        constraintSet.applyTo(constraintLayout);






        builder.setCancelable(false)
                .setView(constraintLayout)
                .setPositiveButton("Felvesz", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            String desc = editText.getText().toString();
                            String year = editText1.getText().toString();
                            String month = editText2.getText().toString();
                            String day = editText3.getText().toString();
                            createCardView(desc, year, month, day);
                        }
                        dialog.cancel();
                    }
                })
                .setNegativeButton("Mégse", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        //Creating dialog box
        AlertDialog alert = builder.create();
        //Setting the title manually
        alert.setTitle("Új emlékeztető");
        alert.show();

    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void createCardView(String desc, String year, String month, String day) {

        CardView card = new CardView(context);

        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                400
        );
        card.setLayoutParams(layoutParams);
        card.setCardElevation(50);
        card.setRadius(15);
        card.setId(View.generateViewId());

        main.addView(card);

        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(main);

        cards.add(card);
        if (cards.size() > 1) {
            constraintSet.connect(card.getId(), ConstraintSet.LEFT, main.getId(), ConstraintSet.LEFT, 50);
            constraintSet.connect(card.getId(), ConstraintSet.RIGHT, main.getId(), ConstraintSet.RIGHT, 50);
            constraintSet.connect(card.getId(), ConstraintSet.TOP, main.getId(), ConstraintSet.TOP, 50);
            constraintSet.connect((cards.get(cards.size() - 2)).getId(), ConstraintSet.TOP, card.getId(), ConstraintSet.BOTTOM, 50);
            constraintSet.applyTo(main);
        } else {
            constraintSet.connect(card.getId(), ConstraintSet.LEFT, main.getId(), ConstraintSet.LEFT, 50);
            constraintSet.connect(card.getId(), ConstraintSet.TOP, main.getId(), ConstraintSet.TOP, 50);
            constraintSet.connect(card.getId(), ConstraintSet.RIGHT, main.getId(), ConstraintSet.RIGHT, 50);
            constraintSet.connect(findViewById(R.id.space).getId(), ConstraintSet.TOP, card.getId(), ConstraintSet.BOTTOM, 0);
            constraintSet.applyTo(main);
        }

        //New Layout
        ConstraintLayout constraintLayout = new ConstraintLayout(MainActivity.this);
        ConstraintLayout.LayoutParams params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.MATCH_PARENT,
                ConstraintLayout.LayoutParams.MATCH_PARENT);
        constraintLayout.setLayoutParams(params);
        constraintLayout.setId(View.generateViewId());
        card.addView(constraintLayout);

        //TextView
        TextView txtName = new TextView(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        txtName.setLayoutParams(params);
        txtName.setText("Leírás: ");
        txtName.setId(View.generateViewId());

        constraintLayout.addView(txtName);


        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(txtName.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 50);
        constraintSet.connect(txtName.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.TOP, 50);
        constraintSet.applyTo(constraintLayout);

        //TextView
        TextView Name = new TextView(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        Name.setLayoutParams(params);
        Name.setText(desc);
        Name.setId(View.generateViewId());

        constraintLayout.addView(Name);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(Name.getId(), ConstraintSet.LEFT, txtName.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(Name.getId(), ConstraintSet.TOP, constraintLayout.getId(), ConstraintSet.TOP, 50);
        constraintSet.applyTo(constraintLayout);

        //TextView
        TextView txtDate = new TextView(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        txtDate.setLayoutParams(params);
        txtDate.setText("Határidő: ");
        txtDate.setId(View.generateViewId());

        constraintLayout.addView(txtDate);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(txtDate.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 50);
        constraintSet.connect(txtDate.getId(), ConstraintSet.TOP, txtName.getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.applyTo(constraintLayout);

        //TextView
        TextView Date = new TextView(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        Date.setLayoutParams(params);
        Date.setText(year + "." + month + "." + day);
        Date.setId(View.generateViewId());

        constraintLayout.addView(Date);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(Date.getId(), ConstraintSet.LEFT, txtDate.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(Date.getId(), ConstraintSet.TOP, Name.getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.applyTo(constraintLayout);

        //Button
        Button btnEdit = new Button(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        btnEdit.setLayoutParams(params);
        btnEdit.setText("Szerkesztés");
        btnEdit.setId(View.generateViewId());
        btnEdit.setTextColor(getResources().getColor(R.color.design_default_color_primary));
        btnEdit.setBackgroundColor(Color.TRANSPARENT);

        constraintLayout.addView(btnEdit);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(btnEdit.getId(), ConstraintSet.LEFT, constraintLayout.getId(), ConstraintSet.LEFT, 50);
        constraintSet.connect(btnEdit.getId(), ConstraintSet.TOP, txtDate.getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.applyTo(constraintLayout);

        //Button
        Button btnDelete = new Button(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        btnDelete.setLayoutParams(params);
        btnDelete.setText("Törlés");
        btnDelete.setId(View.generateViewId());
        btnDelete.setTextColor(getResources().getColor(R.color.design_default_color_primary));
        btnDelete.setBackgroundColor(Color.TRANSPARENT);

        constraintLayout.addView(btnDelete);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(btnDelete.getId(), ConstraintSet.LEFT, btnEdit.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(btnDelete.getId(), ConstraintSet.TOP, Date.getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.applyTo(constraintLayout);

        //CheckBox
        CheckBox checkBox = new CheckBox(MainActivity.this);
        params = new ConstraintLayout.LayoutParams(
                ConstraintLayout.LayoutParams.WRAP_CONTENT,
                ConstraintLayout.LayoutParams.WRAP_CONTENT);
        checkBox.setLayoutParams(params);
        checkBox.setId(View.generateViewId());
        checkBox.setButtonTintList(ColorStateList.valueOf(getResources().getColor(R.color.design_default_color_primary)));

        constraintLayout.addView(checkBox);

        constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);

        constraintSet.connect(checkBox.getId(), ConstraintSet.LEFT, btnDelete.getId(), ConstraintSet.RIGHT, 50);
        constraintSet.connect(checkBox.getId(), ConstraintSet.TOP, Name.getId(), ConstraintSet.BOTTOM, 50);
        constraintSet.applyTo(constraintLayout);
    }
}