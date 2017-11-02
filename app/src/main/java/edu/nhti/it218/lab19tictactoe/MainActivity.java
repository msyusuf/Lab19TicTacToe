package edu.nhti.it218.lab19tictactoe;

import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    static String myTag = "TT";
    private Button[][] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);
        buildGuiByCode();
    }

    public void buildGuiByCode() {
        // Get width of the screen
        Point size = new Point();
        Log.e(myTag, String.format("Value of Point is %d, %d", size.x, size.y));
        getWindowManager().getDefaultDisplay().getSize(size);
        Log.e(myTag, String.format("Value of Point is %d, %d", size.x, size.y));
        int w = size.x / TicTacToe.SIDE;

        //Use GridLayout for layout manager
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(TicTacToe.SIDE);
        gridLayout.setRowCount(TicTacToe.SIDE);

        buttons = new Button[TicTacToe.SIDE][TicTacToe.SIDE];
        for (int row = 0; row < TicTacToe.SIDE; row++) {
            for (int col = 0; col < TicTacToe.SIDE; col++) {
                buttons[row][col] = new Button(this);
                gridLayout.addView(buttons[row][col],w,w);
            } // inner for loop for cols
        } // outer for loop for row

        // Set gridLayout as the View of this Activity
        setContentView(gridLayout);
    } // buildGuiByCode
}
