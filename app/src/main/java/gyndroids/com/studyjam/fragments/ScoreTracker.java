package gyndroids.com.studyjam.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import gyndroids.com.studyjam.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ScoreTracker#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ScoreTracker extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_SCORE_A = "score_a";
    private static final String ARG_SCORE_B = "score_b";

    private View mView;

    private int mScoreTeamA;
    private int mScoreTeamB;

    private TextView txtTeamAScore;
    private Button btnTeamA3Points;
    private Button btnTeamA2Points;
    private Button btnTeamA1Points;

    private TextView txtTeamBScore;
    private Button btnTeamB3Points;
    private Button btnTeamB2Points;
    private Button btnTeamB1Points;

    private Button btnResetScores;

    public ScoreTracker() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param scoreTeamA Parameter 1.
     * @param scoreTeamB Parameter 2.
     * @return A new instance of fragment ScoreTracker.
     */
    // TODO: Rename and change types and number of parameters
    public static ScoreTracker newInstance(int scoreTeamA, int scoreTeamB) {
        ScoreTracker fragment = new ScoreTracker();
        Bundle args = new Bundle();
        args.putInt(ARG_SCORE_A, scoreTeamA);
        args.putInt(ARG_SCORE_B, scoreTeamB);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mScoreTeamA = getArguments().getInt(ARG_SCORE_A);
            mScoreTeamB = getArguments().getInt(ARG_SCORE_B);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_scoretracker, container, false);

        mScoreTeamA = 0;
        mScoreTeamB = 0;

        setupToolbar();
        setupViews();
        setupListeners();

        return mView;
    }

    private void setupToolbar() {
    }

    private void setupViews() {
        txtTeamAScore = (TextView) mView.findViewById(R.id.txt_team_01_score);

        btnTeamA1Points = (Button) mView.findViewById(R.id.btn_team_01_add_1_points);
        btnTeamA2Points = (Button) mView.findViewById(R.id.btn_team_01_add_2_points);
        btnTeamA3Points = (Button) mView.findViewById(R.id.btn_team_01_add_3_points);

        txtTeamBScore = (TextView) mView.findViewById(R.id.txt_team_02_score);

        btnTeamB1Points = (Button) mView.findViewById(R.id.btn_team_02_add_1_points);
        btnTeamB2Points = (Button) mView.findViewById(R.id.btn_team_02_add_2_points);
        btnTeamB3Points = (Button) mView.findViewById(R.id.btn_team_02_add_3_points);

        btnResetScores = (Button) mView.findViewById(R.id.btn_score_reset);


    }

    private void setupListeners() {

        btnTeamA1Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamA += 1;
                updateScore();
            }
        });

        btnTeamA2Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamA += 2;
                updateScore();
            }
        });

        btnTeamA3Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamA += 3;
                updateScore();
            }
        });

        btnTeamB1Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamB += 1;
                updateScore();
            }
        });

        btnTeamB2Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamB += 2;
                updateScore();
            }
        });

        btnTeamB3Points.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamB += 3;
                updateScore();
            }
        });


        btnResetScores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScoreTeamA = 0;
                mScoreTeamB = 0;
                updateScore();
            }
        });

    }

    private void updateScore() {
        txtTeamAScore.setText(Integer.toString(mScoreTeamA));
        txtTeamBScore.setText(Integer.toString(mScoreTeamB));
    }
}


