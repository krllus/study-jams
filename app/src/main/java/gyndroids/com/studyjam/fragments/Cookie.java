package gyndroids.com.studyjam.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import gyndroids.com.studyjam.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Cookie extends Fragment {

    private View mView;

    private Button mButton;
    private ImageView mImageView;
    private TextView mTextView;

    public Cookie() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_cookie, container, false);

        //setViews
        mButton = (Button) mView.findViewById(R.id.btn_eat_cookie);
        mImageView = (ImageView) mView.findViewById(R.id.android_cookie_image_view);
        mTextView = (TextView) mView.findViewById(R.id.status_text_view);

        //setListeners
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eatCookie();
            }
        });

        return mView;
    }

    private void eatCookie() {
        mImageView.setImageResource(R.drawable.after_cookie);
        mTextView.setText(getString(R.string.after_cookie));
    }

}
