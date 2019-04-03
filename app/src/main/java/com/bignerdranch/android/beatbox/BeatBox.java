package com.bignerdranch.android.beatbox;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BeatBox {
    private static final String TAG = "BeatBox";
    private static final String SOUNDS_FOLDER = "sample_sounds";

    private AssetManager mAsset;
    private List<Sound> mSounds = new ArrayList<>();

    public BeatBox(Context context) {
        this.mAsset = context.getAssets();
        loadSounds();
    }

    public List<Sound> getSounds() {
        return mSounds;
    }

    private void loadSounds() {
        String[] soundNames;

        try {
            soundNames = mAsset.list(SOUNDS_FOLDER);
            Log.i(TAG, "Found " + soundNames.length + " sounds");
        } catch (IOException e) {
            Log.e(TAG, "Could not list assets", e);
            return;
        }
        for (String fileName : soundNames) {
            String assetPath = SOUNDS_FOLDER + "/" + fileName;
            Sound sound = new Sound(assetPath);
            mSounds.add(sound);
        }


    }
}
