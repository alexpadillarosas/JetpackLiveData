package com.blueradix.android.jetpacklivedata.ui.main;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.blueradix.android.jetpacklivedata.databinding.MainFragmentBinding;

public class MainFragment extends Fragment {

    private MainFragmentBinding binding;
    private MainViewModel mViewModel;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = MainFragmentBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        //create an observer for the total property in the viewModel
        final Observer<String> totalObserver = new Observer<String>() {
            @Override
            public void onChanged(String value) {
                binding.totalTextView.setText(value);
            }
        };
        //getThe MutableLiveData object from the viewModel, then register the observer created for it.
        mViewModel.getTotal().observe(getViewLifecycleOwner(), totalObserver);

        binding.doubleItButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!binding.amountTextInputEditText.getText().toString().isEmpty()) {
                    String amount = binding.amountTextInputEditText.getText().toString();
                    Double amountDoubleIt = Double.valueOf(amount) * 2;
                    mViewModel.setTotal(amountDoubleIt.toString());
                }else{
                    mViewModel.setTotal("NO VALUE");
                }
            }
        });
    }


}