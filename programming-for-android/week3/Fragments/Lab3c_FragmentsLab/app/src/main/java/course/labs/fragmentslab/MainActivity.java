package course.labs.fragmentslab;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity implements
		FriendsFragment.SelectionListener {

	private static final String TAG = "Lab-Fragments";

	private FriendsFragment mFriendsFragment;
	private FeedFragment mFeedFragment;

	private FragmentManager mFragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_activity);

		// If the layout is single-pane, create the FriendsFragment 
		// and add it to the Activity

		if (!isInTwoPaneMode()) {
			
			mFriendsFragment = new FriendsFragment();

			//TODO 1 - add the FriendsFragment to the fragment_container

			// Get a reference to the FragmentManager
			mFragmentManager = getFragmentManager();
			// Start a new FragmentTransaction
			FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
			// Add the FriendsFragment to the layout
			fragmentTransaction.add(R.id.fragment_container, mFriendsFragment);
			// Add this FragmentTransaction to the backstack
			//fragmentTransaction.addToBackStack(null);
			// Commit the FragmentTransaction
			fragmentTransaction.commit();
			// Force Android to execute the committed FragmentTransaction
			//mFragmentManager.executePendingTransactions();

		} else {

			// Otherwise, save a reference to the FeedFragment for later use

			mFeedFragment = (FeedFragment) getFragmentManager()
					.findFragmentById(R.id.feed_frag);

			/*
			mFragmentManager = getFragmentManager();
			FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
			fragmentTransaction.add(R.id.friends_frag, new FriendsFragment());
			fragmentTransaction.add(R.id.feed_frag, mFeedFragment);
			fragmentTransaction.commit();
			*/
		}

	}

	// If there is no fragment_container ID, then the application is in
	// two-pane mode

	private boolean isInTwoPaneMode() {

		return findViewById(R.id.fragment_container) == null;
	
	}

	// Display selected Twitter feed

	public void onItemSelected(int position) {

		Log.i(TAG, "Entered onItemSelected(" + position + ")");

		// If there is no FeedFragment instance, then create one

		if (mFeedFragment == null)
			mFeedFragment = new FeedFragment();

		// If in single-pane mode, replace single visible Fragment

		if (!isInTwoPaneMode()) {

			//TODO 2 - replace the fragment_container with the FeedFragment
			
			if (!mFeedFragment.isAdded()) {

				FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();

				// Replace whatever is in the fragment_container view with this fragment,
				// and add the transaction to the back stack so the user can navigate back
				fragmentTransaction.replace(R.id.fragment_container, mFeedFragment);
				fragmentTransaction.addToBackStack(null);

				fragmentTransaction.commit();

				// execute transaction now
				getFragmentManager().executePendingTransactions();
			}

		}

		// Update Twitter feed display on FriendFragment
		mFeedFragment.updateFeedDisplay(position);

	}

}
