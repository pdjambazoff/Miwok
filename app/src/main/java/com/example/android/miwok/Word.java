package com.example.android.miwok;

/**
 * Created by Beast on 1/7/2018.
 */

public class Word {
    private String englishWord;
    private String miwokWord;
    private int image_resource_id;

    public Word(String e, String m) {
        miwokWord = m;
        englishWord = e;
    }
    public Word(String e, String m, int imageId) {
        miwokWord = m;
        englishWord = e;
        image_resource_id = imageId;
    }
    public String getMiwokWord() {
        return miwokWord;
    }
    public String getTranslation() {
        return englishWord;
    }
    public int getImageRosourceID() { return image_resource_id;}
}
