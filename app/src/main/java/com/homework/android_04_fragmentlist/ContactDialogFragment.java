package com.homework.android_04_fragmentlist;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ContactDialogFragment extends DialogFragment implements View.OnClickListener  {
    public final static String DIALOGONE_LASTNAME = "dialog_lastname";
    public final static String DIALOGONE_FIRSTNAME = "dialog_firstname";
    public final static String DIALOGONE_EMAIL = "dialog_email";
    private EditText edtLastName;
    private EditText edtFirstName;
    private EditText editEmail;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup containerViewId, Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.dialog_fragment, containerViewId, false);
        view.findViewById(R.id.btnApply).setOnClickListener(this);
        view.findViewById(R.id.btnCancel).setOnClickListener(this);
        this.edtLastName = (EditText) view.findViewById(R.id.dialog_lastname);
        this.edtFirstName = (EditText) view.findViewById(R.id.dialog_firstname);
        this.editEmail = (EditText) view.findViewById(R.id.dialog_email);
        return view;
    }
    @Override
    public void onResume()   {
        super.onResume();
        Bundle bundleArgs = this.getArguments();
        if (bundleArgs.containsKey(ContactDialogFragment.DIALOGONE_LASTNAME)){
            this.edtLastName.setText((bundleArgs.getString(ContactDialogFragment.DIALOGONE_LASTNAME)));
        }
        if (bundleArgs.containsKey(ContactDialogFragment.DIALOGONE_FIRSTNAME)){
            this.edtFirstName.setText((bundleArgs.getString(ContactDialogFragment.DIALOGONE_FIRSTNAME)));
        }
        if (bundleArgs.containsKey(ContactDialogFragment.DIALOGONE_EMAIL)){
            this.editEmail.setText((bundleArgs.getString(ContactDialogFragment.DIALOGONE_EMAIL)));
        }
    }
    @Override
    public void onClick(View v)   {
        switch (v.getId()){
            case R.id.btnApply:
                Bundle bundleArgs = this.getArguments();
                ((MainActivity) getActivity()).SetContact(new EmailContact(edtLastName.getText().toString(), edtFirstName.getText().toString(),editEmail.getText().toString()) );
                this.dismiss();
                break;
            case R.id.btnCancel:
                this.dismiss();
                break;
        }
    }
}
