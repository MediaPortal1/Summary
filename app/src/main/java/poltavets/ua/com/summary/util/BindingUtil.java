package poltavets.ua.com.summary.util;


import android.databinding.BindingAdapter;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.support.v4.content.ContextCompat;
import android.widget.RatingBar;

import poltavets.ua.com.summary.R;

public class BindingUtil {

    @BindingAdapter("starColor")
    public static void setStarRatingColor(RatingBar ratingBar, boolean enable) {
        if (enable) {
            LayerDrawable stars = (LayerDrawable) ratingBar.getProgressDrawable();
            stars.getDrawable(2).setColorFilter(ContextCompat.getColor(ratingBar.getContext(), R.color.colorPrimaryDark), PorterDuff.Mode.SRC_ATOP);
        }
    }
}
