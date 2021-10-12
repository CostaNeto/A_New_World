package com.costaneto.anewworld.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.costaneto.anewworld.R;
import com.costaneto.anewworld.model.Page;
import com.costaneto.anewworld.model.Story;

import java.util.Stack;

public class StoryActivity extends AppCompatActivity {

    public static final String TAG = StoryActivity.class.getSimpleName();
    private Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private TextView storyTittleTextView1;
    private TextView storyTittleTextView2;
    private TextView scrollTextView;
    private Button choice1Button;
    private Button choice2Button;
    private String name;
    private Stack<Integer> pageStack = new Stack<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = (ImageView) findViewById(R.id.storyImageView);
        storyTextView = (TextView) findViewById(R.id.storyTextView);
        storyTittleTextView1 = (TextView) findViewById(R.id.storyTittleTextView1);
        storyTittleTextView2 = (TextView) findViewById(R.id.storyTittleTextView2);
        scrollTextView = (TextView) findViewById(R.id.scrollTextView);
        choice1Button = (Button) findViewById(R.id.choice1Button);
        choice2Button = (Button)findViewById(R.id.choice2Button);

        Intent intent = getIntent();
        name = intent.getStringExtra(getString(R.string.key_name));
        if (name == null || name.isEmpty())
            name = "friend";
        Log.d(TAG, name);

        story = new Story();
        loadPage(0);
    }

    private void loadPage(int pageNumber) {

        pageStack.push(pageNumber);

        Page page = story.getPage(pageNumber);

        Drawable image = ContextCompat.getDrawable(this, page.getImageID());
        storyImageView.setImageDrawable(image);

        String tittleText1 = getString(page.getStoryTittleText1());
        String tittleText2 = getString(page.getStoryTittleText2());
        storyTittleTextView1.setText(tittleText1);
        storyTittleTextView2.setText(tittleText2);

        String pageText = getString(page.getTextID());

        // Add name if placeholder is included. Won't add if not
        pageText = String.format(pageText, name);
        storyTextView.setText(pageText);

        // Displaying the "scroll down" tip
        if (pageNumber == 0 || pageNumber == 3 || pageNumber == 5 )
            scrollTextView.setVisibility(View.VISIBLE);
        else
            scrollTextView.setVisibility(View.INVISIBLE);


        // If it's one of the two final pages of the story
        if (page.isFinal()) {
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setVisibility(View.VISIBLE);
            choice2Button.setText(R.string.play_again_button);
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    loadPage(0);
                }
            });
        }

        // If it's the rest of the story pages
        else {
            // Behavior of choiceButton1 for all pages
            choice1Button.setVisibility(View.VISIBLE);
            choice1Button.setText(page.getChoice1().getTextID());
            choice1Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int nextPage = page.getChoice1().getNextPage();
                    loadPage(nextPage);
                }
            });

            // Behavior of choiceButton2 for page #4
            if (pageNumber == 4)
                choice2Button.setVisibility(View.INVISIBLE);

            // Behavior of choiceButton2 for the rest of the story pages
            else{
                choice2Button.setVisibility(View.VISIBLE);
                choice2Button.setText(page.getChoice2().getTextID());
                choice2Button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int nextPage = page.getChoice2().getNextPage();
                        loadPage(nextPage);
                    }
                });
            }
        }
    }

    @Override
    public void onBackPressed() {
        pageStack.pop();
        if (pageStack.isEmpty())
            super.onBackPressed();
        else
            loadPage(pageStack.pop());
    }
}