package au.id.chrisb.funfacts;

import android.app.Activity;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import static android.os.BatteryManager.BATTERY_PROPERTY_CAPACITY;

public class FunFactsActivity extends Activity  {

    private FactBook mFactBook = new FactBook();
    private bgColor mColor = new bgColor();
    public static final String TAG = FunFactsActivity.class.getSimpleName();
    public static final String LOC = "locdebug";
    public loc mLoc = new loc();
    public BatteryManager mBM = new BatteryManager();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);
        // Declare view variables
        final TextView factLabel = (TextView) findViewById(R.id.factTextView);
        final TextView batCap = (TextView) findViewById(R.id.batCap);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);
        final RelativeLayout mainlayout = (RelativeLayout) findViewById(R.id.mainLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fact = mFactBook.getFact();
                if (fact == "lon") {fact = "your latitude is not "+mLoc.lon;}
                if (fact == "lat") {fact = "Your longitude is not "+mLoc.lat;}
                int color = mColor.getColor();
                factLabel.setText(fact);
                mainlayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
                mLoc.getLocation();
                batCap.setText(mBM.getIntProperty(BATTERY_PROPERTY_CAPACITY)+"");
            }
        };
        mLoc.buildGoogleApiClient(this);
        showFactButton.setOnClickListener(listener);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(FunFactsActivity.this, "hi", Toast.LENGTH_LONG).show();
            }
        });


    }

    protected void onResume() {
        super.onResume();
        if (mLoc.mGoogleApiClient.isConnected()) { mLoc.startLocationUpdates();}
    }

    protected void onPause() {
        super.onPause();
        mLoc.stopLocationUpdates();
    }

}

