package ru.me.fromfragmenttoactivitry;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FragmentA extends Fragment {
    private static final String TAG = FragmentA.class.getSimpleName();

    private Button mBtnSend;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);

        etFirstNumber = (EditText) view.findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) view.findViewById(R.id.etSecondNumber);

        mBtnSend = (Button) view.findViewById(R.id.btnSend);
        mBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendData();
            }
        });
        return view;
    }

    private void sendData() {
        int i1 = Integer.parseInt(etFirstNumber.getText().toString());
        int i2 = Integer.parseInt(etSecondNumber.getText().toString());

//        !!! Обратить внимание на реализацию интерфейса:
        MyListener myListener = (MyListener) getActivity();
        myListener.addTwoNumbers(i1, i2);
    }
}
