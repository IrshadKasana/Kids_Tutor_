package java.com.example.kidstutor;

import android.view.View;

/**
 * Created by Irshad Kasana on 7/16/2020.
 */
import android.view.View;
import android.widget.Toast;

public class NumberClickListener implements View.OnClickListener {
    @Override
    public void onClick(View v) {
        Toast.makeText(v.getContext(),"you visited in numbers",Toast.LENGTH_LONG).show();
    }
}