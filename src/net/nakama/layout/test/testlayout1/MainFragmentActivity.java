package net.nakama.layout.test.testlayout1;

import net.nakama.layout.test.testlayout1.fragments.MyListFrament;
import android.os.Bundle;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentTransaction;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;

public class MainFragmentActivity extends FragmentActivity implements MyListFrament.OnHeadlineSelectedListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        
        if (findViewById(R.id.fragment_container) != null) {
        	
        	Fragment mf = new MyListFrament(false);
        	mf.setArguments(getIntent().getExtras());
        	
        	getFragmentManager().beginTransaction().add(R.id.fragment_container, mf).commit();
        	
        	
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main_fragment, menu);
        return true;
    }

	/* (non-Javadoc)
	 * @see net.nakama.layout.test.testlayout1.fragments.MyListFrament.OnHeadlineSelectedListener#onArticleSelected(int)
	 */
	@Override
	public void onArticleSelected(int position) {
		Fragment mf = new MyListFrament(true);
    	mf.setArguments(getIntent().getExtras());
    	
    	FragmentTransaction trx = getFragmentManager().beginTransaction();
    	//trx.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    	trx.setCustomAnimations(android.R.animator.fade_in, android.R.animator.fade_out);

    	trx.replace(R.id.fragment_container, mf);
    	trx.addToBackStack(null);
    	
    	trx.commit();
	}
    
    
}
