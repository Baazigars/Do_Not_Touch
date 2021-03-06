package org.fsmk.fsmk;

import android.graphics.Color;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class Login extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;

    static public ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_ACTION_BAR);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.login_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public static class PlaceholderFragment extends Fragment {
        EditText username, password;
        Button login, signup,signin;
        public RelativeLayout page1,page2;
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }
        void reset(){
            page1.setVisibility(View.INVISIBLE);
            page2.setVisibility(View.INVISIBLE);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.login_home, container, false);
            //textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
            username = (EditText) rootView.findViewById(R.id.login_username);
            password = (EditText) rootView.findViewById(R.id.login_password);
            login = (Button) rootView.findViewById(R.id.login_btnlogin);
            signup = (Button) rootView.findViewById(R.id.login_btnsignup);
            page1=(RelativeLayout)rootView.findViewById(R.id.login_page1);
            page2= (RelativeLayout)rootView.findViewById(R.id.login_page2);
            signin  = (Button)rootView.findViewById(R.id.login_btnsignup);

            signin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    
                }
            });

            if(getArguments().getInt(ARG_SECTION_NUMBER)==1){
                reset();
                page1.setVisibility(View.VISIBLE);
            }
            else if(getArguments().getInt(ARG_SECTION_NUMBER)==2){
                reset();
                page2.setVisibility(View.VISIBLE);
            }

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    reset();
                    page1.setVisibility(View.VISIBLE);
                    mViewPager.setCurrentItem(1);
                }
            });

            username.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                        login.setBackgroundColor(Color.parseColor(("#474747")));
                    } else {
                        login.setBackgroundColor(Color.parseColor(("#afaeae")));
                    }
                }
            });

            password.addTextChangedListener(new TextWatcher() {
                @Override
                public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                }

                @Override
                public void afterTextChanged(Editable editable) {
                    if (!username.getText().toString().isEmpty() && !password.getText().toString().isEmpty()) {
                        login.setBackgroundColor(Color.parseColor(("#474747")));
                    } else {
                        login.setBackgroundColor(Color.parseColor(("#afaeae")));
                    }
                }
            });

            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
            }
            return null;
        }
    }

    @Override
    public void onBackPressed() {
        if (mViewPager.getCurrentItem() == 1)

            mViewPager.setCurrentItem(0);
        else
            super.onBackPressed();
    }
}
