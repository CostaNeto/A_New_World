package com.costaneto.anewworld.model;

public class Page {
    private int imageID;
    private int textID;
    private int storyTittleText1;
    private int storyTittleText2;
    private Choice choice1;
    private Choice choice2;
    private boolean isFinal = false;

    // Final pages 5 & 6
    public Page(int imageID, int textID, int storyTittleText1, int storyTittleText2) {
        this.imageID = imageID;
        this.textID = textID;
        this.storyTittleText1 = storyTittleText1;
        this.storyTittleText2 = storyTittleText2;
        this.isFinal = true;
    }

    // Page 4 only has one choice
    public Page(int imageID, int textID, Choice choice1, int storyTittleText1, int storyTittleText2) {
        this.imageID = imageID;
        this.textID = textID;
        this.storyTittleText1 = storyTittleText1;
        this.storyTittleText2 = storyTittleText2;
        this.choice1 = choice1;
    }

    // Remaining pages
    public Page(int imageID, int textID, Choice choice1, Choice choice2, int storyTittleText1, int storyTittleText2) {
        this.imageID = imageID;
        this.textID = textID;
        this.storyTittleText1 = storyTittleText1;
        this.storyTittleText2 = storyTittleText2;
        this.choice1 = choice1;
        this.choice2 = choice2;
    }

    public int getStoryTittleText1() {
        return storyTittleText1;
    }

    public void setStoryTittleText1(int storyTittleText1) {
        this.storyTittleText1 = storyTittleText1;
    }

    public int getStoryTittleText2() {
        return storyTittleText2;
    }

    public void setStoryTittleText2(int storyTittleText2) {
        this.storyTittleText2 = storyTittleText2;
    }

    public boolean isFinal() {
        return isFinal;
    }

    public void setFinal(boolean aFinal) {
        isFinal = aFinal;
    }

    public int getImageID() {
        return imageID;
    }

    public void setImageID(int imageID) {
        this.imageID = imageID;
    }

    public int getTextID() {
        return textID;
    }

    public void setTextID(int textID) {
        this.textID = textID;
    }

    public Choice getChoice1() {
        return choice1;
    }

    public void setChoice1(Choice choice1) {
        this.choice1 = choice1;
    }

    public Choice getChoice2() {
        return choice2;
    }

    public void setChoice2(Choice choice2) {
        this.choice2 = choice2;
    }
}
