package com.example.ujjwal.broker.helper.image_loader;

import android.widget.ImageView;
import android.widget.ProgressBar;

/**
 * Created by ujjwal on 11/12/16.
 */
public interface ImageLoader {

	void LoadImage(String url , ImageView imageView , ProgressBar progressBar);
	/*void Load_Circular_Image(String url ,ImageView imageView);
*/}

