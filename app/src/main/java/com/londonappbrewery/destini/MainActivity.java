package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView mStoryTextView;
    private Button mButtonTop;
    private Button mButtonBottom;

    private int mStoryIndex = 1;
    private int mChoiceNumber = 0;

    private StoryLine[] mStoryLines = new StoryLine[]{
            new StoryLine(R.string.T1_Story, R.string.T1_Ans1, R.string.T1_Ans2),
            new StoryLine(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryLine(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2)
    };

    private int[] mChoicesMade = new int[mStoryLines.length];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null) {
            mStoryIndex = savedInstanceState.getInt("IndexKey");
        } else {
            mStoryIndex = 0;
        }


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
        mStoryTextView = (TextView) findViewById(R.id.storyTextView);
        mButtonTop = (Button) findViewById(R.id.buttonTop);
        mButtonBottom = (Button) findViewById(R.id.buttonBottom);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        mButtonTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mChoicesMade[mChoiceNumber] = mStoryIndex;

                if (mStoryIndex==2){
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);

                    mStoryTextView.setText(R.string.T6_End);
                } else {
                    mStoryIndex = 2;
                    updateStoryPath();
                }

            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:

        mButtonBottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mChoicesMade[mChoiceNumber] = mStoryIndex;

                if (mStoryIndex==2){
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);

                    mStoryTextView.setText(R.string.T5_End);

                } else if (mStoryIndex==1){
                    mButtonTop.setVisibility(View.GONE);
                    mButtonBottom.setVisibility(View.GONE);

                    mStoryTextView.setText(R.string.T4_End);

                } else {
                    mStoryIndex = 1;
                    updateStoryPath();
                }

            }
        });

    }


    private void updateStoryPath(){
        int narrative = mStoryLines[mStoryIndex].getQuestionID();
        int first_choice = mStoryLines[mStoryIndex].getButtonTopID();
        int second_choice = mStoryLines[mStoryIndex].getButtonBottomID();

        mStoryTextView.setText(narrative);
        mButtonTop.setText(first_choice);
        mButtonBottom.setText(second_choice);
        mChoiceNumber = mChoiceNumber + 1;
    }

    // TODO: Saving state of the app
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("IndexKey", mStoryIndex);
    }
}
