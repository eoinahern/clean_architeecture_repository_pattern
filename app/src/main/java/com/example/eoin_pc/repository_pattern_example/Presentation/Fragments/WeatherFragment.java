package com.example.eoin_pc.repository_pattern_example.Presentation.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.eoin_pc.repository_pattern_example.MyApplication;
import com.example.eoin_pc.repository_pattern_example.Presentation.Adapters.WeatherRecviewAdpt;
import com.example.eoin_pc.repository_pattern_example.Presentation.Presenters.WeatherListPresenter;
import com.example.eoin_pc.repository_pattern_example.R;
import com.example.eoin_pc.repository_pattern_example.data.entity.DailyWeatherEntity;

import java.util.List;

import javax.inject.Inject;

public class WeatherFragment extends Fragment implements WeatherFragView{

    @Inject WeatherListPresenter weatherlistpresenter;
    @Inject WeatherRecviewAdpt weatheradpt;


    private ProgressBar  progbar;
    private RecyclerView w_recview;



    public WeatherFragment() {
    }


    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((MyApplication) getActivity().getApplication()).getFragComponent().inject(this);


        if(weatherlistpresenter == null   ||  weatheradpt == null  )
            Log.d("weather presenter", "its null");
            else
            Log.d("not null", "yipeee!!!");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        weatherlistpresenter.setView(this);
        View v = inflater.inflate(R.layout.fragment_weather, container, false);
        progbar = (ProgressBar) v.findViewById(R.id.progbar);
        w_recview = (RecyclerView) v.findViewById(R.id.recview);


        return v;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);


        /*if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }*/
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //mListener = null;
    }


    @Override
    public void SetProgress(boolean visible) {

        if(visible)
            progbar.setVisibility(View.VISIBLE);

        progbar.setVisibility(View.INVISIBLE) ;
    }

    @Override
    public void GetWeather() {
        weatherlistpresenter.getWeatherDetails();
    }

    @Override
    public void setUpView(List<DailyWeatherEntity> wlist) {
        weatheradpt.updateList(wlist);
    }


}
