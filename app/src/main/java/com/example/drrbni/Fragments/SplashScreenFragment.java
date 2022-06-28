package com.example.drrbni.Fragments;

import static com.example.drrbni.Constant.SPLASH_SCREEN_TIME_OUT;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.drrbni.R;
import com.example.drrbni.databinding.FragmentSplashScreenBinding;
import com.google.firebase.auth.FirebaseAuth;

public class SplashScreenFragment extends Fragment {

    private FragmentSplashScreenBinding binding;
    private FirebaseAuth auth;
    public SplashScreenFragment() {}

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentSplashScreenBinding.inflate
                (getLayoutInflater(), container, false);

//        getActivity().getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//        getActivity().setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (auth.getCurrentUser() != null) {
                    NavController navController = Navigation.findNavController(binding.getRoot());
                    navController.navigate(R.id.action_splashScreenFragment_to_mainFragment);
                } else {
                    NavController navController = Navigation.findNavController(binding.getRoot());
                    navController.navigate(R.id.action_splashScreen_to_onboarding);
                }
            }
        }, SPLASH_SCREEN_TIME_OUT);

        return binding.getRoot();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}