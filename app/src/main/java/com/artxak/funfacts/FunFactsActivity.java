package com.artxak.funfacts;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FunFactsActivity extends AppCompatActivity {
    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();

    // Declare our View variables.
    private TextView mFactTextView;
    private Button mShowFactButton;
    private ConstraintLayout mConstraintLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        // Assign the Views from the layout files to the corresponding variables.
        mFactTextView = (TextView) findViewById(R.id.factTextView);
        mShowFactButton = (Button) findViewById(R.id.showFactButton);
        mConstraintLayout = (ConstraintLayout) findViewById(R.id.funFactLayout);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // The button was clicked, so update the fact TextView with a new fact.
                mFactTextView.setText(mFactBook.getRandomFact());
                int color = mColorWheel.getRandomColor();
                mConstraintLayout.setBackgroundColor(color);
                mShowFactButton.setTextColor(color);
            }
        };
        mShowFactButton.setOnClickListener(listener);

        Toast.makeText(this, "Yay! Our Activity was created!", Toast.LENGTH_SHORT).show();
    }
}
