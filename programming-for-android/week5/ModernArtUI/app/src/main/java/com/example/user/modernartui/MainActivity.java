package com.example.user.modernartui;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private GridLayout gridLayout;
    private TextView tvLeftTop, tvLeftBottom, tvRightTop, tvRightMiddle, tvRightBottom;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = (GridLayout) findViewById(R.id.gridLayout);

        tvLeftTop = (TextView) findViewById(R.id.textview_LeftTop);
        tvLeftBottom = (TextView) findViewById(R.id.textview_LeftBottom);
        tvRightTop = (TextView) findViewById(R.id.textview_RightTop);
        tvRightMiddle = (TextView) findViewById(R.id.textview_RightMiddle);
        tvRightBottom = (TextView) findViewById(R.id.textview_RightBottom);

        seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setMax(255);

        SeekBar.OnSeekBarChangeListener seekbarListener = new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                int redPart, greenPart, bluePart;
                int color;

                redPart = seekBar.getProgress();
                greenPart = seekBar.getProgress();
                bluePart = Color.blue(Color.YELLOW);

                color = Color.rgb(redPart, greenPart, bluePart);

                ColorFilter filter = new PorterDuffColorFilter(color, PorterDuff.Mode.LIGHTEN);

                tvLeftTop.getBackground().setColorFilter(filter);
                tvLeftBottom.getBackground().setColorFilter(filter);
                tvRightTop.getBackground().setColorFilter(filter);
                tvRightMiddle.getBackground().setColorFilter(filter);
                tvRightBottom.getBackground().setColorFilter(filter);

                tvLeftTop.setText("");
                tvLeftBottom.setText("");
                tvRightTop.setText("");
                tvRightMiddle.setText("");
                tvRightBottom.setText("");

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        };

        seekBar.setOnSeekBarChangeListener(seekbarListener);

    }

    // Create options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
        //return super.onCreateOptionsMenu(menu);
    }

    // Process clicks on Options Menu items
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.item_MoreInfo:
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder .setMessage(R.string.dialog_text)
                        .setPositiveButton(R.string.button_ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Uri uri = Uri.parse("http://www.moma.org/");
                                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                                startActivity(intent);

                            }
                        })
                        .setNegativeButton(R.string.button_cancel, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                ;

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;

            default:
                return false;
                //return super.onOptionsItemSelected(item);
        }
    }


}
