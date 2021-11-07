package com.example.projec11.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.projec11.R;
import com.example.projec11.databinding.FragmentHomeBinding;
import com.example.projec11.ui.pan.PanFragment;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //
        homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        final TextView textView = binding.textHome;
        ImageView imageView1 = root.findViewById(R.id.imgP5);
        ImageView imageView2 = root.findViewById(R.id.imgDoa6);
        ImageView imageView3 = root.findViewById(R.id.imgSmtst);


        imageView1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Fragment newFragment = new PanFragment();

                Bundle result = new Bundle();
                result.putString("bundleKey", "result");
                newFragment.setArguments(result);

                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();

                FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.nav_host_fragment_content_main, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        imageView2.setOnClickListener(new View.OnClickListener() {
            int codigo = 2;
            @Override
            public void onClick(View view) {
                Fragment newFragment = new PanFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_content_main, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        imageView3.setOnClickListener(new View.OnClickListener() {
            int codigo = 3;
            @Override
            public void onClick(View view) {
                Fragment newFragment = new PanFragment();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.nav_host_fragment_content_main, newFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
        //
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}