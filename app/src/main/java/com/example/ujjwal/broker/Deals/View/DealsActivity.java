package com.example.ujjwal.broker.Deals.View;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ujjwal.broker.Buy.View.BuyFragment;
import com.example.ujjwal.broker.Fragments.ContactUsFragment;
import com.example.ujjwal.broker.R;


import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ujjwal on 13/12/16.
 */

public class DealsActivity extends AppCompatActivity implements
		NavigationView.OnNavigationItemSelectedListener,ProductsFragment.OnFragmentInteractionListener {

	@BindView(R.id.coordinator_layout)
	CoordinatorLayout coordinatorLayout;
	@BindView(R.id.toolbar)
	Toolbar toolbar;

	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.deals_activity);

		ButterKnife.bind(this);

		setSupportActionBar(toolbar);
		initialise();

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
			this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
		drawer.setDrawerListener(toggle);
		toggle.syncState();

		NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
		navigationView.setNavigationItemSelectedListener(this);


		setFragment(new CategoryFragment(), "Home");
	}

	private void initialise() {


	}

	private void setFragment(Fragment fragment, String title) {

		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.frame_layout_deals, fragment);
		fragmentTransaction.commit();

		getSupportActionBar().setTitle(title);

	}

	@Override
	public void onBackPressed() {
		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		if (drawer.isDrawerOpen(GravityCompat.START)) {
			drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		return false;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		getMenuInflater().inflate(R.menu.main, menu);

		return true;


	}

	@Override
	public boolean onNavigationItemSelected(@NonNull MenuItem item) {

	int id =item.getItemId();

		if (id == R.id.daily_rates){
			Intent deals =new Intent(DealsActivity.this,DealsActivity.class);
			startActivity(deals);
			finish();
		}else if (id == R.id.buy){
			getSupportActionBar().hide();
			addFragment(new BuyFragment(),"Buy");

		}else {
				getSupportActionBar().hide();
					addFragment(new ContactUsFragment(),"Contact Us");
		}

		DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawer.closeDrawer(GravityCompat.START);
		return true;
	}

	private void addFragment(Fragment fragment,String title) {


		FragmentManager fragmentManager = getSupportFragmentManager();
		FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
		fragmentTransaction.replace(R.id.frame_layout_deals, fragment);
		fragmentTransaction.addToBackStack(null);
		fragmentTransaction.commit();

		getSupportActionBar().setTitle(title);
	}


	@Override
	public void onFragmentInteraction(Uri uri) {

	}

}
