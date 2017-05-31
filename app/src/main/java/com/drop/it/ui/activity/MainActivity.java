package com.drop.it.ui.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.drop.it.R;
import com.drop.it.ui.fragment.BaseFragment;
import com.drop.it.ui.fragment.ContactDetailsFragment;
import com.drop.it.ui.fragment.InitDropFragment;

/**
 * In real implementation, the fragments won't control each other, and this class will handle the
 * flow, but for this purposes i think its enough.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));

        openFragment(new InitDropFragment());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_settings) {
            openFragment(new ContactDetailsFragment());
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (fragmentManager.getBackStackEntryCount() == 1) {
            finish();
            return;
        }

        super.onBackPressed();
    }

    /**
     * @param fragment current fragment to inflate
     */
    public void openFragment(BaseFragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_container, fragment).addToBackStack(null).commit();
    }
}
