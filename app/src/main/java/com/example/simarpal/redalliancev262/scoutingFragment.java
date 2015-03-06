package com.example.simarpal.redalliancev262;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.RatingBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link scoutingFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link scoutingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class scoutingFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    //VARIABLES

    String teamNumberDouble = "";//Stores the value for the user input of the team Number :INPUT METHOD = EditText
    String matchNumberDouble = "";//Stores the value for the user input of the matchNumber :INPUT METHOD = EditText
    String totesFromLandfillDouble = "";//Stores the value for the user input of the totes from the landfill :INPUT METHOD = EditText
    String upsideDownTotesDouble = "";//Stores the value for the user input of the upside down totes :INPUT METHOD = EditText
    String totesHPDouble = "";//Stores the value for the user input of the totes from the Human Player :INPUT METHOD = EditText
    String numberOverPlatformDouble = "";//Stores the value for the user input of the number of times over platform :INPUT METHOD = EditText
    int cylindersMovedDouble = 0;//Stores the values for the user input of the cylinders moved :INPUT METHOD = NumberPicker
    int totesMovedDouble = 0;//Stores the values for the user input of the totes moved :INPUT METHOD = NumberPicker
    int offStepCylindersDouble = 0;//Stores the values of the user input of the off step cylinders :INPUT METHOD = NumberPicker
    int offStepTotesDouble = 0;//Stores the values of the user input of the off step totes :INPUT METHOD = NumberPicker
    int noodlesCylinderDouble = 0;//Stores the values of the user input of the noodles in  the cylinder :INPUT METHOD = NumberPicker
    int noodlesOpponentDouble = 0;//Stores the values of the user input of the noodles in opponent zone;:INPUT METHOD = NumberPicker
    //booleans
    Boolean wideBool;//Unknown context :INPUT METHOD = CheckBox
    Boolean longBool;//Unknown context :INPUT METHOD = CheckBox
    Boolean botZoneBool;//Stores the value of the bot in zone :INPUT METHOD = ToggleButton
    Boolean toteSetBool;//Stores the value of the totes set :INPUT METHOD = ToggleButton
    Boolean herdLitterBool;//Stores the value of the herd litter option :INPUT METHOD = Switch
    //Constants
    String scoutNameString = "";//Stores the value of the user input of the scout number

    int MIN_VALUE = 0;//This variable stores the min value of 0
    final int CYLINDERS_MOVED_MAX = 3;//This variable stores the max of the corresponding value
    final int TOTES_MOVED_MAX = 3;//This variable stores the max of the corresponding value
    final int CYLINDERS_OFF_STEP_MAX = 4;//This variable stores the max of the corresponding value
    final int TOTES_OFF_STEP_MAX = 12;//This variable stores the max of the corresponding value
    final int NOODLES_CYLINDER_MAX = 10;//This variable stores the max of the corresponding value
    final int NOODLES_OPPONENT_ZONE_MAX = 10;//This variable stores the max of the corresponding value
    //Strings

    float ratingRobot;
    EditText teamNumberText ;
    EditText matchNumberText ;
    EditText scoutNameText;
    EditText landfillTotesText;
    EditText upsideDownTotesText ;
    EditText totesFromHP ;
    EditText platformText ;

    //Number Picker Objects
    NumberPicker cylinderMoveNP ;
    NumberPicker totesMovedNP ;
    NumberPicker cylinderOffStep;
    NumberPicker totesOffStep ;
    NumberPicker noodlesCylinderNp;
    NumberPicker noodlesOpponentNp;

    //Toggle button code
    ToggleButton toteSetToggle;
    ToggleButton botZoneToggle ;

    //CheckBox Objects
    CheckBox longCheckBox;
    CheckBox wideCheckBox;

    //Switch object
    Switch herdLitterSwitch ;

    RatingBar robotRating ;
    Button submitButton;
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
     * @return A new instance of fragment scoutingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static scoutingFragment newInstance(String param1, String param2) {
        scoutingFragment fragment = new scoutingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;

    }

    public scoutingFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);}









    }
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        // initialise your views

        submitButton = (Button) getView().findViewById(R.id.submitButton);
        teamNumberText = (EditText)  getView().findViewById(R.id.teamNumberEditText);
        matchNumberText = (EditText)  getView().findViewById(R.id.matchNumberEditText);
        scoutNameText = (EditText)  getView().findViewById(R.id.scoutNameEditText);
        landfillTotesText = (EditText)  getView().findViewById(R.id.totesFromLandfillEditText);
        upsideDownTotesText = (EditText)  getView().findViewById(R.id.upsideDownTotesEditText);
        totesFromHP = (EditText)  getView().findViewById(R.id.totesHPEditText);
        platformText = (EditText) getView().findViewById(R.id.numberOverPlatformEditText);

        //Number Picker Objects
        cylinderMoveNP = (NumberPicker)  getView().findViewById(R.id.cylindersMovedNumberPicker);
        totesMovedNP = (NumberPicker)  getView().findViewById(R.id.numberOfTotesMovedNumberPicker);
        cylinderOffStep = (NumberPicker)  getView().findViewById(R.id.numberOffStepNumberPicker);
        totesOffStep = (NumberPicker)  getView().findViewById(R.id.totesOffStepNP);
        noodlesCylinderNp = (NumberPicker)  getView().findViewById(R.id.noodlesCylinderNP);
        noodlesOpponentNp = (NumberPicker)  getView().findViewById(R.id.noodlesInOpponentNP);

        //Toggle button code
        toteSetToggle = (ToggleButton)  getView().findViewById(R.id.toteSetToggleButton);
        botZoneToggle = (ToggleButton)  getView().findViewById(R.id.botZoneToggleButton);

        //CheckBox Objects
        longCheckBox = (CheckBox)  getView().findViewById(R.id.longCheckBox);
        wideCheckBox = (CheckBox)  getView().findViewById(R.id.wideCheckBox);

        //Switch object
        herdLitterSwitch = (Switch)  getView().findViewById(R.id.herdLitterOptionSwitch);
        robotRating = (RatingBar)  getView().findViewById(R.id.ratingBar);
        cylinderMoveNP.setMaxValue(CYLINDERS_MOVED_MAX);
        totesMovedNP.setMaxValue(TOTES_MOVED_MAX);
        cylinderOffStep.setMaxValue(CYLINDERS_OFF_STEP_MAX);
        totesOffStep.setMaxValue(TOTES_OFF_STEP_MAX);
        noodlesCylinderNp.setMaxValue(NOODLES_CYLINDER_MAX);
        noodlesOpponentNp.setMaxValue(NOODLES_OPPONENT_ZONE_MAX);
        //Number Picker min values assigned
        cylinderMoveNP.setMinValue(MIN_VALUE);
        totesMovedNP.setMinValue(MIN_VALUE);
        cylinderMoveNP.setMinValue(MIN_VALUE);
        totesOffStep.setMinValue(MIN_VALUE);
        noodlesOpponentNp.setMinValue(MIN_VALUE);
        noodlesCylinderNp.setMinValue(MIN_VALUE);
        View.OnClickListener listenerScout = new View.OnClickListener() {
            public void onClick(View v) {
                //This method updates the information from the scouting_layout.xml during runtime
                // START OF EDIT TEXT
                scoutNameString = scoutNameText.getText().toString();//Updates the scout name
                teamNumberDouble = teamNumberText.getText().toString();//Updates team number
                matchNumberDouble = matchNumberText.getText().toString();//Updates match number
                totesFromLandfillDouble = landfillTotesText.getText().toString();//Updates landfill
                upsideDownTotesDouble = upsideDownTotesText.getText().toString();//Updates upside Down totes
                totesHPDouble = totesFromHP.getText().toString();//Updates totes from HP
                numberOverPlatformDouble = platformText.getText().toString();//Updates times over platform
                //END OF EDIT TEXT

                //START OF NUMBER PICKER
                cylindersMovedDouble = cylinderMoveNP.getValue();//Updates the cylinder
                totesMovedDouble = totesMovedNP.getValue();//Updates the totes
                offStepCylindersDouble = cylinderOffStep.getValue();//Updates the off step cylinder
                offStepTotesDouble = totesOffStep.getValue();//Update the off step tote
                noodlesCylinderDouble = noodlesCylinderNp.getValue();//Update the noodles in cylinder
                noodlesOpponentDouble = noodlesOpponentNp.getValue();//Updates the noodles in opponent
                ratingRobot = robotRating.getRating();
                //END OF NUMBER PICKER

                //START OF TOGGLE BUTTONS

                //Checks if tote toggle is pressed if so changes bool
                if (toteSetToggle.isChecked()) {
                    toteSetBool = true;
                } else toteSetBool = false;

                //Checks if bot zone toggle is pressed if so changes bool
                if (botZoneToggle.isChecked()) {
                    botZoneBool = true;
                } else botZoneBool = false;

                //END OF TOGGLE BUTTONS

                //START OF CHECKBOX
                //Checks if long checkbox is pressed if so changes bool
                if (longCheckBox.isChecked()) {
                    longBool = true;
                }
                //Checks if wide checkbox is pressed if so changes bool
                else longBool = false;
                if (wideCheckBox.isChecked()) {
                    wideBool = true;
                } else wideBool = false;
                //END OF CHECKBOX

                //START OF SWITCH
                //Checks if herd litter switch is pressed if so changes bool
                if (herdLitterSwitch.isChecked()) {
                    herdLitterBool = true;
                } else herdLitterBool = false;

                try {
                    writerToFileScouting();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                //END OF SWITCH

            }
        };
        submitButton.setOnClickListener(listenerScout);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

    return inflater.inflate(R.layout.scouting,container,false);


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
    private void writerToFileScouting() throws IOException {


        String myFileName = "Team " + teamNumberDouble + " Match " + matchNumberDouble + ".txt";
        File root = Environment.getExternalStorageDirectory();
        File outDir = new File(root.getAbsolutePath() + File.separator + "Red Alliance");
        Writer writer;
        File outPutFile = new File(outDir, myFileName);
        writer = new PrintWriter(new FileWriter(outPutFile));
        if (!outDir.isDirectory()) {
            outDir.mkdir();
        }

        if (!outDir.isDirectory()) {
            throw new IOException("unable to create directory ");

        }
        if (!teamNumberDouble.isEmpty() && !matchNumberDouble.isEmpty()) {
            writer.write("Team Number = " + teamNumberDouble + "\n");
            writer.write("Match Number = " + matchNumberDouble + "\n");
            writer.write("Scout Name = " + scoutNameString + "\n");
            writer.write("Totes Number = " + totesMovedDouble + "\n");
            writer.write("Cylinders Moved = " + cylindersMovedDouble + "\n");
            writer.write("Cylinders off step = " + offStepCylindersDouble + "\n");
            writer.write("Tote set = " + toteSetBool + "\n");
            writer.write("Bot in zone = " + botZoneBool + "\n");
            writer.write("Long = " + longBool + "\n");
            writer.write("Wide = " + wideBool + "\n");
            writer.write("Totes from landfill = " + totesFromLandfillDouble + "\n");
            writer.write("Upside down totes = " + upsideDownTotesDouble + "\n");
            writer.write("Totes off step = " + offStepTotesDouble + "\n");
            writer.write("Noodles in cylinder = " + noodlesCylinderDouble + "\n");
            writer.write("Noodles in opponent zone = " + noodlesOpponentDouble + "\n");
            writer.write("Herd Litter = " + herdLitterBool + "\n");
            writer.write("Totes from HP = " + totesHPDouble + "\n");
            writer.write("Number over platform = " + numberOverPlatformDouble + "\n");
            writer.write("Rating = " + ratingRobot);
            writer.close();
            MessageBox("File saved");
        } else {
            MessageBox("Please enter team Number and match number");
        }
    }
    public void MessageBox(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }


}
