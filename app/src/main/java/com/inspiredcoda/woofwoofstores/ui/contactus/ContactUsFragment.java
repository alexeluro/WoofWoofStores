package com.inspiredcoda.woofwoofstores.ui.contactus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.inspiredcoda.woofwoofstores.R;

public class ContactUsFragment extends Fragment implements View.OnClickListener {

    private ContactUsViewModel contactUsViewModel;
    private EditText yourMessage;
    private Button sendMessageBtn;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_contact_us, container, false);

        yourMessage = root.findViewById(R.id.contact_us_message);
        sendMessageBtn = root.findViewById(R.id.contact_us_send_btn);

        contactUsViewModel = ViewModelProviders.of(this).get(ContactUsViewModel.class);
        contactUsViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    private void sendMessage(){
        String message = yourMessage.getText().toString();
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        yourMessage.setText("");
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.contact_us_send_btn){
            sendMessage();
        }
    }





}
