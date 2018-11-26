package ws.wolfsoft.cleanup_home;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.FrameLayout;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity {

    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        frameLayout = (FrameLayout) findViewById(R.id.framelayout);


        BottomBar bottomBar = (BottomBar) findViewById(R.id.bottombar);
        for (int i = 0; i < bottomBar.getTabCount(); i++) {
            bottomBar.getTabAtPosition(i).setGravity(Gravity.CENTER_VERTICAL);
        }



         /*roughike bottombar library code is here*/

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {

            @Override
            public void onTabSelected(@IdRes int tabId) {
                Fragment fragment = null;
                switch (tabId) {
                    case R.id.clean:
                        replace_fragment(new Clean_Fragment());
                        break;
                    case R.id.wifi:
                        replace_fragment(new Clean_Fragment());
                        break;
                    case R.id.more:
                        replace_fragment(new Clean_Fragment());
                        break;


                }


            }
        });
    }

    public void replace_fragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.framelayout, fragment);
        transaction.commit();
    }

}
