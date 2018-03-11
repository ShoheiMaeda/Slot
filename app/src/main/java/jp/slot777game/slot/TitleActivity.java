package jp.slot777game.slot;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;

        import jp.slot777game.slotgame.R;

public class TitleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title);
    }

    public void StartButton(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
