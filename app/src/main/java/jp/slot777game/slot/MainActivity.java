package jp.slot777game.slot;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.view.View;
        import android.widget.Button;
        import android.widget.LinearLayout;
        import android.widget.Toast;
        import android.widget.ImageView;
        import android.widget.TextView;
        import android.os.Bundle;
        import android.graphics.drawable.AnimationDrawable;
        import android.view.Gravity;
        import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button button;

    ImageView image1,image2,image3;

    Random r;

    int img1,img2,img3;

    int exp;

    int click = 0;

    int explotion[] = new int[3];

    int coin = 5;

    int mgamestate = 1;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        r = new Random();

        button = (Button) findViewById(R.id.b_roll);

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(String.valueOf(coin));

        image1 = (ImageView) findViewById(R.id.image1);
        image2 = (ImageView) findViewById(R.id.image2);
        image3 = (ImageView) findViewById(R.id.image3);

        image1.setImageResource(R.drawable.ic_hatena);
        image2.setImageResource(R.drawable.ic_hatena);
        image3.setImageResource(R.drawable.ic_hatena);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(click==3){

                    img3 = r.nextInt(6) + 1;

                    switch (img3){
                        case 1:
                            image3.setImageResource(R.drawable.ic_knife);
                            break;
                        case 2:
                            image3.setImageResource(R.drawable.ic_ninja1);
                            break;
                        case 3:
                            image3.setImageResource(R.drawable.ic_ninja2);
                            break;
                        case 4:
                            image3.setImageResource(R.drawable.ic_shuriken1);
                            break;
                        case 5:
                            image3.setImageResource(R.drawable.ic_shuriken2);
                            break;
                        case 6:
                            image3.setImageResource(R.drawable.ic_explotion);
                            explotion[2] = 1;
                            break;
                    }

                    click = 0;

                    getScore();

                    button.setText("Roll !");

                }


                if(click==2){

                    img2 = r.nextInt(6) + 1;

                    switch (img2){
                        case 1:
                            image2.setImageResource(R.drawable.ic_knife);
                            break;
                        case 2:
                            image2.setImageResource(R.drawable.ic_ninja1);
                            break;
                        case 3:
                            image2.setImageResource(R.drawable.ic_ninja2);
                            break;
                        case 4:
                            image2.setImageResource(R.drawable.ic_shuriken1);
                            break;
                        case 5:
                            image2.setImageResource(R.drawable.ic_shuriken2);
                            break;
                        case 6:
                            image2.setImageResource(R.drawable.ic_explotion);
                            explotion[1] = 1;
                            break;
                    }

                    click = 3;

                }

                if (click==1){

                    img1 = r.nextInt(6) + 1;

                    switch (img1){
                        case 1:
                            image1.setImageResource(R.drawable.ic_knife);
                            break;
                        case 2:
                            image1.setImageResource(R.drawable.ic_ninja1);
                            break;
                        case 3:
                            image1.setImageResource(R.drawable.ic_ninja2);
                            break;
                        case 4:
                            image1.setImageResource(R.drawable.ic_shuriken1);
                            break;
                        case 5:
                            image1.setImageResource(R.drawable.ic_shuriken2);
                            break;
                        case 6:
                            image1.setImageResource(R.drawable.ic_explotion);
                            explotion[0] = 1;
                            break;
                    }

                    click = 2;

                }


                if(click==0) {

                    button.setText("Stop !");

                    coin = coin - 1;

                    TextView text = (TextView) findViewById(R.id.textView);
                    text.setText(String.valueOf(coin));

                    image1.setImageResource(R.drawable.anim);
                    final AnimationDrawable image1anim = (AnimationDrawable) image1.getDrawable();
                    image1anim.start();

                    image2.setImageResource(R.drawable.anim);
                    final AnimationDrawable image2anim = (AnimationDrawable) image2.getDrawable();
                    image2anim.start();

                    image3.setImageResource(R.drawable.anim);
                    final AnimationDrawable image3anim = (AnimationDrawable) image3.getDrawable();
                    image3anim.start();

                    click = 1;

                }



            }
        });




    }


    public void getScore(){

        exp = explotion[0]+explotion[1]+explotion[2];

        if(exp == 3){
            Toast ts1 = Toast.makeText(this,"−５",Toast.LENGTH_SHORT);
            ts1.setGravity(Gravity.TOP, 0, 150);
            LinearLayout tsLayout1 = (LinearLayout) ts1.getView();
            TextView tsTV1 = (TextView) tsLayout1.getChildAt(0);
            tsTV1.setTextSize(100);
            ts1.show();
            coin = coin - 5;
        }else if(exp == 2){
            Toast ts2 = Toast.makeText(this,"−３",Toast.LENGTH_SHORT);
            ts2.setGravity(Gravity.TOP, 0, 150);
            LinearLayout tsLayout2 = (LinearLayout) ts2.getView();
            TextView tsTV2 = (TextView) tsLayout2.getChildAt(0);
            tsTV2.setTextSize(100);
            ts2.show();
            coin = coin - 3;
        }else if(exp == 1) {
            Toast ts3 = Toast.makeText(this, "−１", Toast.LENGTH_SHORT);
            ts3.setGravity(Gravity.TOP, 0, 150);
            LinearLayout tsLayout3 = (LinearLayout) ts3.getView();
            TextView tsTV3 = (TextView) tsLayout3.getChildAt(0);
            tsTV3.setTextSize(100);
            ts3.show();
            coin = coin - 1;

            if (img1 == img2 || img2 == img3 || img1 == img3) {
                Toast ts4 = Toast.makeText(this, "＋２!", Toast.LENGTH_SHORT);
                ts4.setGravity(Gravity.TOP, 0, 150);
                LinearLayout tsLayout4 = (LinearLayout) ts4.getView();
                TextView tsTV4 = (TextView) tsLayout4.getChildAt(0);
                tsTV4.setTextSize(100);
                ts4.show();
                coin = coin + 2;
            }
        }else {

            if (img1 == img2 && img2 == img3) {
                Toast ts5 = Toast.makeText(this, "＋５", Toast.LENGTH_SHORT);
                ts5.setGravity(Gravity.TOP, 0, 150);
                LinearLayout tsLayout5 = (LinearLayout) ts5.getView();
                TextView tsTV5 = (TextView) tsLayout5.getChildAt(0);
                tsTV5.setTextSize(100);
                ts5.show();
                coin = coin + 5;
            } else if (img1 == img2 || img2 == img3 || img1 == img3) {
                Toast ts6 = Toast.makeText(this, "＋２!", Toast.LENGTH_SHORT);
                ts6.setGravity(Gravity.TOP, 0, 150);
                LinearLayout tsLayout6 = (LinearLayout) ts6.getView();
                TextView tsTV6 = (TextView) tsLayout6.getChildAt(0);
                tsTV6.setTextSize(100);
                ts6.show();
                coin = coin + 2;
            }

        }

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(String.valueOf(coin));

        if(coin < 1){

            Intent intent = new Intent(MainActivity.this, overActivity.class);
            mgamestate = 0;
            startActivity(intent);

        }

        for (int i = 0;i<=2;i++) {
            explotion[i] = 0;
        }

        exp = 0;

    }

}