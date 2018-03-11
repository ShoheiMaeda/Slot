package jp.slot777game.slot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import jp.slot777game.slotgame.R;

public class overActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_over);
    }

    public void RetryButton(View v){
        Intent intent = new Intent(this,TitleActivity.class);
        startActivity(intent);
    }
}
