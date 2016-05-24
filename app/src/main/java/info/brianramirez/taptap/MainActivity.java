package info.brianramirez.taptap;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int redCounter = 0;
    int blueCounter = 0;

    TextView redTextView;
    TextView blueTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Button redButton = (Button)findViewById(R.id.redPlayer);
        Button blueButton = (Button)findViewById(R.id.bluePlayer);

        redTextView = (TextView)findViewById(R.id.redText);
        blueTextView = (TextView)findViewById(R.id.blueText);




        redTextView.setText(redCounter+"");
        blueTextView.setText(blueCounter+"");

        showIntro();

        redButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                redCounter++;
                redTextView.setText(redCounter + "");

                if(redCounter == 30){
                    showWinner("Red");
                }
            }
        });

        blueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                blueCounter++;
                blueTextView.setText(blueCounter+"");

                if(blueCounter == 30){
                    showWinner("Blue");
                }
            }
        });
    }

    public void showWinner(String winner){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(winner + " Wins!!!!");

        builder.setPositiveButton(
                "Play Again!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        blueCounter = 0;
                        redCounter = 0;
                        blueTextView.setText(blueCounter + "");
                        redTextView.setText(redCounter + "");
                        dialog.cancel();
                    }
                });


        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }

    public void showIntro(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Hello There!\n \nThis is Tap Tap! This game consists of two buttons, a green one and a blue one. " +
                "Players must tap their buttons as fast as they can to win. First player to reach 30 taps WINS!!\n \nGood luck! and keep on tapping. ");

        builder.setPositiveButton(
                "Let's Play!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });


        AlertDialog alert = builder.create();
        alert.setCanceledOnTouchOutside(false);
        alert.show();
    }
}
