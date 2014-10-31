package is.advanced.movie.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import is.advanced.movie.R;
/**
 * Created by Sindri on 30/10/14.
 */
public class TheatersFragment extends Fragment {

    String theaters[] = {
            "SMÁRABÍÓ", "BÍÓ PARADÍS", "HÁSKÓLABÍÓ", "LAUGARÁSBÍÓ", "SAMBÍÓIN EGILSHÖLL",
            "SAMBÍÓIN KRINGLUNNI", "SAMBÍÓIN ÁLFABAKKA", "SMÁRABÍÓ"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.theaters, container, false);


        TextView textView1 = (TextView) view.findViewById(R.id.theatersId1);
        TextView textView2 = (TextView) view.findViewById(R.id.theatersId2);
        TextView textView3 = (TextView) view.findViewById(R.id.theatersId3);
        TextView textView4 = (TextView) view.findViewById(R.id.theatersId4);
        TextView textView5 = (TextView) view.findViewById(R.id.theatersId5);
        TextView textView6 = (TextView) view.findViewById(R.id.theatersId6);
        TextView textView7 = (TextView) view.findViewById(R.id.theatersId7);
        TextView textView8 = (TextView) view.findViewById(R.id.theatersId8);

        textView1.setText(theaters[0]);
        textView2.setText(theaters[1]);
        textView3.setText(theaters[2]);
        textView4.setText(theaters[3]);
        textView5.setText(theaters[4]);
        textView6.setText(theaters[5]);
        textView7.setText(theaters[6]);
        textView8.setText(theaters[7]);

       /* View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        }
        */

        return view;
    }

}
