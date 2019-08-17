package com.qstu.login.component;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.qstu.login.R;

import base_component.login.base.BaseLoginDialogFragment;

public class LoginDialogFragment extends BaseLoginDialogFragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.login_layout_dialog_fragment, null);
    }
}
