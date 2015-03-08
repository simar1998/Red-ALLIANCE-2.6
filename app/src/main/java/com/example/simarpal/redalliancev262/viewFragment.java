package com.example.simarpal.redalliancev262;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link viewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link viewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class viewFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    EditText teamText;
    EditText matchText;
    TextView mainTextView;
    Button refreshButton;
    File []listFiles;
    String teamFiles ="";
    int hello[] = {};
    String teamMatches;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment viewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static viewFragment newInstance(String param1, String param2) {
        viewFragment fragment = new viewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public viewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_view,container,false);
    }
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view ,savedInstanceState);
        teamText = (EditText) getView().findViewById(R.id.teamEditText);
        matchText = (EditText) getView().findViewById(R.id.matchEditText);
        mainTextView = (TextView) getView().findViewById(R.id.viewTextView);
        refreshButton =(Button) getView().findViewById(R.id.refreshButton);
        File root = Environment.getExternalStorageDirectory();
        String filename = root.getPath() + File.separator + "Red Alliance";
        File folder = new File(filename);
        listFiles = folder.listFiles();

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        for (int i = 0; i < listFiles.length ; i++)
        {
            Log.d("a", listFiles[i].getName());
            String createdFileName = "Team " +teamText.getText().toString() + " Match " + matchText.getText().toString() +".txt";
            Log.d("A","Smart: "+ createdFileName);

            if(matchText.getText().toString().isEmpty()) {
                for (int teamNumberFor = 0; teamNumberFor < 100; teamNumberFor++) {
                    mainTextView.setText("Team " + teamText.getText().toString() + " Has competed in \n");
                    Log.d("AAAA","AAA");
                    for (int matchNumbers = 0; matchNumbers < 100; matchNumbers++) {
                        if (listFiles[teamNumberFor].getName().toString().equals("Team " + teamText.getText().toString() + " Match " + matchNumbers + ".txt")) {
                            teamFiles = teamFiles + "\n" + matchNumbers;

                            //mainTextView.setText(teamFiles);

                        }
                    }



                }

                mainTextView.setText(teamFiles);

            }
            else if(listFiles[i].getName().equals(createdFileName) )
            {
                mainTextView.setText("");
                Log.d("a", "here");
                try {
                    MessageBox("File Read");
                    BufferedReader br = new BufferedReader(new FileReader(listFiles[i]));
                    String  line;
                    String lineStore = "";

                    while((line = br.readLine()) != null)
                    {
                        lineStore = lineStore + " \n" +line;
                        mainTextView.setText(lineStore);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }else{
                Log.d("a", "if loop didn't work");

            }
        }

            }
        };
        refreshButton.setOnClickListener(listener);

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }
    public void MessageBox(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

}
