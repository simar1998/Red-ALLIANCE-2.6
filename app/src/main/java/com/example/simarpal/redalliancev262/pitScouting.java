package com.example.simarpal.redalliancev262;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
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
 * {@link pitScouting.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link pitScouting#newInstance} factory method to
 * create an instance of this fragment.
 */
public class pitScouting extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
   EditText pitTeamNumberText;
    EditText pitScoutNameText ;
    EditText pitSpeedText ;
    EditText pitDriveTypeText ;
   EditText pitOrientationText ;
   EditText pitAutonText ;
    EditText pitStackHeightText;
    EditText pitContainerHeightText ;
   EditText pitLitterContainerHowText;

    //Switch objects
     Switch pitTotesPickBool;
    Switch pitPushTotesBool ;
    Switch pitRightToteBool;
    Switch pitLandfillTotesBool ;
     Switch pitHPFeedBool ;
    Switch pitLitterBool;
    Switch pitRightContainerBool;
   Switch pitHerdLitterBool;
     Switch pitThrowLitterBool ;
     Switch pitLitterLandfillBool ;
     Switch pitOneOnThreeBool ;
     Switch pitThreeOnOneBool ;

    //Toggle button
     ToggleButton pitStrafeToggleBool;
     ToggleButton pitOverPlatformBool ;

    //Checkbox objects
     CheckBox pitSetBool;
     CheckBox pitStackBool ;

    //Spinner objects

    //pit Button object
     Button pitSubmitButton ;
     Button cameraLaunchButton ;

    String pitTeamName = "";
    String pitScoutName = "";
    String pitSpeed = "";
    String pitDriveType = "";
    String pitOrientation = "";
    String pitAutonomous = "";
    String pitStackHeight = "";
    String pitContainerHeight = "";
    String pitLitterInContainerHowString = "";
    String pitFileName = "PIT SCOUT TEAM " + pitTeamName;
    String imageFile;

    //Booleans
    Boolean pitStrafe = false;
    Boolean pitOverPlatform = false;
    Boolean pitTotesPick = false;
    Boolean pitPushTotes = false;
    Boolean pitRightTotes = false;
    Boolean pitLandfillTotes = false;
    Boolean pitHPfeed = false;
    Boolean pitLitterInContainer = false;
    Boolean pitRightContainers = false;
    Boolean pitHerdLitter = false;
    boolean pitThrowLitter = false;
    Boolean pitLitterLandfill = false;
    Boolean coopOneThree = false;
    Boolean coopThreeOne = false;
    Boolean pitSet = false;
    Boolean pitStack = false;

    Intent mainIntent;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static final int REQUEST_TAKE_PHOTO = 1;

    File photoFile;


    private OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment pitScouting.
     */
    // TODO: Rename and change types and number of parameters
    public static pitScouting newInstance(String param1, String param2) {
        pitScouting fragment = new pitScouting();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public pitScouting() {
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

    public void onViewCreated(View view , Bundle savedInstanceState)
    {
        super.onViewCreated(view,savedInstanceState);


        pitTeamNumberText = (EditText) getView().findViewById(R.id.teamNumber);
        pitScoutNameText = (EditText)  getView().findViewById(R.id.scoutName);
        pitSpeedText = (EditText)  getView().findViewById(R.id.speedTextPIT);
        pitDriveTypeText = (EditText)  getView().findViewById(R.id.driveType);
        pitOrientationText = (EditText)  getView().findViewById(R.id.orientationPIT);
         pitAutonText = (EditText) getView(). findViewById(R.id.autonPIT);
          pitStackHeightText = (EditText)  getView().findViewById(R.id.tallStackPIT);
          pitContainerHeightText = (EditText)  getView().findViewById(R.id.containerHeightPIT);
          pitLitterContainerHowText = (EditText) getView(). findViewById(R.id.litterHowPIT);

        //Switch objects
          pitTotesPickBool= (Switch)  getView().findViewById(R.id.totesPickPIT);
          pitPushTotesBool = (Switch)  getView().findViewById(R.id.pushTotesPIT);
          pitRightToteBool = (Switch) getView().findViewById(R.id.rightTotesPIT);
          pitLandfillTotesBool = (Switch)  getView().findViewById(R.id.landfillTotesPIT);
          pitHPFeedBool = (Switch)  getView().findViewById(R.id.hpFeedPIT);
          pitLitterBool= (Switch)  getView().findViewById(R.id.litterPIT);
          pitRightContainerBool = (Switch) getView().findViewById(R.id.rightContainersPIT);
          pitHerdLitterBool =(Switch)  getView().findViewById(R.id.herdLitterPIT);
          pitLitterLandfillBool = (Switch)  getView().findViewById(R.id.litterLandfillPIT);
          pitOneOnThreeBool = (Switch)  getView().findViewById(R.id.oneToteOnThreePIT);
          pitThreeOnOneBool = (Switch)  getView().findViewById(R.id.threeOnOnePit);
          pitThrowLitterBool= (Switch) getView().findViewById(R.id.throwLitterPIT);

        //Toggle button
          pitStrafeToggleBool = (ToggleButton)  getView().findViewById(R.id.strafeTogglePIT);
          pitOverPlatformBool = (ToggleButton)  getView().findViewById(R.id.overPlatformPIT);

        //Checkbox objects
          pitSetBool = (CheckBox)  getView().findViewById(R.id.setCheckBoxPIT);
          pitStackBool = (CheckBox)  getView().findViewById(R.id.stackCheckBoxPIT);

        //Spinner objects

        //pit Button object
          pitSubmitButton = (Button)  getView().findViewById(R.id.pitSubmit);
          cameraLaunchButton = (Button)  getView().findViewById(R.id.launchCameraButton);
        View.OnClickListener listenerPitScout = new View.OnClickListener() {
            public void onClick(View v){

                pitTeamName = pitTeamNumberText.getText().toString();
                pitScoutName = pitScoutNameText.getText().toString();
                pitSpeed = pitSpeedText.getText().toString();
                pitDriveType = pitDriveTypeText.getText().toString();
                pitOrientation = pitOrientationText.getText().toString();
                pitAutonomous = pitAutonText.getText().toString();
                pitStackHeight = pitStackHeightText.getText().toString();
                pitContainerHeight = pitContainerHeightText.getText().toString();
                pitLitterInContainerHowString = pitLitterContainerHowText.getText().toString();

                if(pitStrafeToggleBool.isChecked()){
                    pitStrafe = true;
                }
                else pitStrafe = false;

                if(pitOverPlatformBool.isChecked())
                {
                    pitOverPlatform = true;
                }
                else pitOverPlatform = false;

                Switch[] switchArray =
                        {
                                pitTotesPickBool,pitPushTotesBool,pitRightToteBool,pitLandfillTotesBool,pitHPFeedBool,pitLitterBool,pitRightContainerBool,
                                pitHerdLitterBool,pitThrowLitterBool,pitLitterLandfillBool,pitOneOnThreeBool,pitThreeOnOneBool
                        };
                Boolean[] boolArray = {
                        pitTotesPick,pitPushTotes, pitRightTotes ,pitLandfillTotes,pitHPfeed, pitLitterInContainer , pitRightContainers
                , pitHerdLitter ,pitThrowLitter,pitLitterLandfill,coopOneThree ,coopThreeOne };
                    if (switchArray[0].isChecked()) {
                        boolArray[0] = true;
                    } else boolArray[0] = false;
                if (switchArray[1].isChecked()) {
                    boolArray[1] = true;
                } else boolArray[1] = false;
                if (switchArray[2].isChecked()) {
                    boolArray[2] = true;
                } else boolArray[2] = false;
                if (switchArray[3].isChecked()) {
                    boolArray[3] = true;
                } else boolArray[3] = false;
                if (switchArray[4].isChecked()) {
                    boolArray[4] = true;
                } else boolArray[4] = false;
                if (switchArray[5].isChecked()) {
                    boolArray[5] = true;
                } else boolArray[5] = false;
                if (switchArray[6].isChecked()) {
                    boolArray[6] = true;
                } else boolArray[6] = false;
                if (switchArray[7].isChecked()) {
                    boolArray[7] = true;
                } else boolArray[7] = false;
                if (switchArray[8].isChecked()) {
                    boolArray[8] = true;
                } else boolArray[8] = false;
                if (switchArray[9].isChecked()) {
                    boolArray[9] = true;
                } else boolArray[9] = false;
                if (switchArray[10].isChecked()) {
                    boolArray[10] = true;
                } else boolArray[10] = false;
                if (switchArray[11].isChecked()) {
                    boolArray[11] = true;
                } else boolArray[11] = false;
                
                
                if(pitSetBool.isChecked())
                {
                    pitSet = true;
                }else pitSet = false;
                if(pitStackBool.isChecked())
                {
                    pitStack = true;
                }else pitStack = false;
                try {
                    writerToFilePit();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };


        View.OnClickListener cameraLaunch = new View.OnClickListener()
        {
            public void onClick(View v)
            {
                pitTeamName = pitTeamNumberText.getText().toString();
                if(!pitTeamName.isEmpty()) {

                    dispatchTakePictureIntent();

                }
                else MessageBox("Please put team name first");
            }
        };
        pitSubmitButton.setOnClickListener(listenerPitScout);


        cameraLaunchButton.setOnClickListener(cameraLaunch);
    }
    private File createImageFile() throws IOException {
        String imageFileName = "TEAM " + pitTeamName.toString() + " Image";
        File root = Environment.getExternalStorageDirectory();
        File outDir = new File(root.getAbsolutePath() + File.separator + "Red Alliance Images");
        if (!outDir.isDirectory()) {
            outDir.mkdir();
        }

        if (!outDir.isDirectory()) {
            throw new IOException("unable to create directory ");

        }

        File image = File.createTempFile( imageFileName,".jpg",outDir );
        return image;

    }
    public void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
            if (takePictureIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                photoFile = null;
                try {
                    photoFile = createImageFile();
                } catch (IOException ex) {

                }
                if (photoFile != null) {
                    takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT,
                            Uri.fromFile(photoFile));
                    startActivityForResult(takePictureIntent, REQUEST_TAKE_PHOTO);
                }

            }
        }


    }
    public void isCheckedMethod(Switch s)
    {
        s.isChecked();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_pit_scouting, container, false);
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
    private void writerToFilePit() throws IOException {
        String myFileName = "PIT " + pitTeamName + ".txt";
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

        if (!pitTeamName.isEmpty() && !pitScoutName.isEmpty()) {
            writer.write("*Team Number = " + pitTeamName + "\n");
            writer.write("*Scout Name = " + pitScoutName + "\n");
            writer.write("*Preferred Speed = " + pitSpeed + "\n");
            writer.write("*Drive Train = " + pitDriveType + "\n");
            writer.write("*Orientation = " + pitOrientation + "\n");
            writer.write("*Autonomous = " + pitAutonomous + "\n");
            writer.write("*Stack Height = " + pitStackHeight + "\n");
            writer.write("*Container Height = " + pitContainerHeight + "\n");
            writer.write("*Litter in container how = " + pitLitterInContainerHowString + "\n");
            writer.write("*Strafe = " + pitStrafe + "\n");
            writer.write("*Over Platform = " + pitOverPlatform + "\n");
            writer.write("*Can pick totes up = " + pitTotesPick + "\n");
            writer.write("*can push totes = " + pitPushTotes + "\n");
            writer.write("*Can right totes = " + pitRightTotes + "\n");
            writer.write("*Landfill totes = " + pitLandfillTotes + "\n");
            writer.write("*HP FEED = " + pitHPfeed + "\n");
            writer.write("*Can put litter in container = " + pitLitterInContainerHowString + "\n");
            writer.write("*Can right container = " + pitRightContainers + "\n");
            writer.write("*Herd litter = " + pitHerdLitter + "\n");
            writer.write("*Can throw litter = " + pitThrowLitter + "\n");
            writer.write("*Can litter landfill = " + pitLitterLandfill + "\n");
            writer.write("*Can put one tote on three = " + coopOneThree + "\n");
            writer.write("*Can put three totes on one = " + coopThreeOne + "\n");
            writer.write("*Set = " + pitSet + "\n");
            writer.write("*Stack = " + pitStack + "\n");
            MessageBox("File Saved");
            writer.close();
        } else MessageBox("Please complete form");
}


}
