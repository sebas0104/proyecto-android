package com.example.projec11.ui.pan;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.projec11.R;
import com.example.projec11.databinding.FragmentPanBinding;

public class PanFragment extends Fragment {

    private PanViewModel panViewModel;
    private FragmentPanBinding binding;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        panViewModel =
                new ViewModelProvider(this).get(PanViewModel.class);
        binding = FragmentPanBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        TextView textviewNom = root.findViewById(R.id.campNom);

        return root;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Bundle datosRecuperados = getArguments();
        if (datosRecuperados == null) {
            // No hay datos, manejar excepción
            return;
        }
        String coddr = datosRecuperados.getString("bundleKey");
        Log.d("GastosFragmentEditar", "El ID: " + coddr);
    }

}
