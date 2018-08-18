package com.mredrock.cyxbs.freshman.myapplication.EnterSchool;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.mredrock.cyxbs.freshman.myapplication.R;

public class DetailedDialog extends Dialog {

    private Context context;

    protected ImageView close;

    public DetailedDialog(@NonNull Context context) {
        super(context);
        this.context = context;
    }

    public DetailedDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(context).inflate(R.layout.freshman_dialog_layout, null);
        close = view.findViewById(R.id.close);
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        setContentView(view);
    }
}