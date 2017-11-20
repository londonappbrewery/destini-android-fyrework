package com.londonappbrewery.destini;

/**
 * Created by Ray on 19/11/2017.
 */

public class StoryLine{

        private int mQuestionID;
        private int mButtonTopId;
        private int mButtonBottomId;

        public StoryLine(int storyTextIndex, int buttonTopIndex, int buttonBottomIndex) {
            mQuestionID = storyTextIndex;
            mButtonTopId = buttonTopIndex;
            mButtonBottomId = buttonBottomIndex;
        }

    public int getQuestionID() {
        return mQuestionID;
    }

    public void setQuestionID(int questionID) {
        mQuestionID = questionID;
    }

    public int getButtonTopID() {
        return mButtonTopId;
    }

    public void setButtonTopID(int buttonTopIndex) {
        mButtonTopId = buttonTopIndex;
    }


    public int getButtonBottomID() {
        return mButtonBottomId;
    }

    public void setButtonBottomID(int buttonBottomIndex) {
        mButtonBottomId = buttonBottomIndex;
    }
}
