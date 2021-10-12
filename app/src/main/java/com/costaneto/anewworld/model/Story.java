package com.costaneto.anewworld.model;

import com.costaneto.anewworld.R;

public class Story {

    private Page[] pages;

    public Story() {
        pages = new Page[7];

        pages[0] = new Page(R.drawable.pic3, R.string.page0, new Choice(R.string.page0_choice1, 1) , new Choice(R.string.page0_choice2, 2), R.string.page0_tittleTextView1, R.string.page0_tittleTextView2);
        pages[1] = new Page(R.drawable.pic9, R.string.page1, new Choice(R.string.page1_choice1, 3) , new Choice(R.string.page1_choice2, 4), R.string.page1_tittleTextView1, R.string.page1_tittleTextView2);
        pages[2] = new Page(R.drawable.pic7, R.string.page2, new Choice(R.string.page2_choice1, 1) , new Choice(R.string.page2_choice2, 6), R.string.page2_tittleTextView1, R.string.page2_tittleTextView2);
        pages[3] = new Page(R.drawable.pic1, R.string.page3, new Choice(R.string.page3_choice1, 5) , new Choice(R.string.page3_choice2, 4), R.string.page3_tittleTextView1, R.string.page3_tittleTextView2);
        pages[4] = new Page(R.drawable.pic5, R.string.page4, new Choice(R.string.page4_choice1, 6), R.string.page4_tittleTextView1, R.string.page4_tittleTextView2);
        pages[5] = new Page(R.drawable.pic8, R.string.page5, R.string.page5_tittleTextView1, R.string.page5_tittleTextView2);
        pages[6] = new Page(R.drawable.pic4, R.string.page6, R.string.page6_tittleTextView1, R.string.page6_tittleTextView2);

    }

    public Page getPage(int pageNumber) {
        if (pageNumber >= pages.length) {
            pageNumber = 0;
        }
        return  pages[pageNumber];
    }
}
