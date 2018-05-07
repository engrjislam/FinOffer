package com.example.ahsanulhoque.finoffer.activity.core;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ahsanulhoque.finoffer.R;
import com.example.ahsanulhoque.finoffer.activity.authentication.LogInActivity;
import com.example.ahsanulhoque.finoffer.activity.authentication.SingOutActivity;
import com.example.ahsanulhoque.finoffer.domain.Product;

public class ProductDetails extends AppCompatActivity {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToggle;
    private NavigationView navigation;

    private Toolbar lTopToolbar;

    ImageView image;
    TextView title;
    TextView details;
    TextView location;
    TextView regularPrice;
    TextView price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        //statusbar color
        updateStatusBarColor("#EF6C00");

        Product product = (Product) getIntent().getSerializableExtra("product");

        title = (TextView) findViewById(R.id.ProductDTitleTV);
        details = (TextView) findViewById(R.id.ProductDDetailsTV);
        image = (ImageView) findViewById(R.id.product1IV);
        location = (TextView) findViewById(R.id.ProductDLocationTV);
        regularPrice = (TextView) findViewById(R.id.PDOldPriceTV);
        price = (TextView) findViewById(R.id.PDNewPriceTV);

        String title1 = product.getName();
        String regPrice = String.valueOf(product.getRegularPrice());
        String newPrice = String.valueOf(product.getPrice());
        String location1 = product.getLocation();
        String details1 = product.getDescription();
        title.setText(title1);
        regularPrice.setText("€" + regPrice);
        price.setText("€" + newPrice);
        location.setText(location1);
        details.setText(details1);




        //for drawer ode
        mDrawerlayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToggle);
        mToggle.syncState();

        //for custom toolbar
        lTopToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(lTopToolbar);

        // for menu image click open drawer
        ImageButton menuBTN = (ImageButton) findViewById(R.id.menuBTN);
        menuBTN.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                mDrawerlayout.openDrawer(Gravity.LEFT);
            }
        });

        initInstances();

    }

    private void initInstances() {
        navigation = (NavigationView) findViewById(R.id.navVW);
        navigation.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.addPRD:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        Intent i = new Intent(ProductDetails.this, ProductActivity.class);
                        startActivity(i);
                        mDrawerlayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.dash:
                        Intent j = new Intent(ProductDetails.this, MainFinOffer.class);
                        startActivity(j);
                        mDrawerlayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.faq:
                        Intent k = new Intent(ProductDetails.this, FaqActivity.class);
                        startActivity(k);
                        mDrawerlayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.about:
                        Intent l = new Intent(ProductDetails.this, AboutActivity.class);
                        startActivity(l);
                        mDrawerlayout.closeDrawer(Gravity.LEFT);
                        break;
                    case R.id.lgot:
                        //Do some thing here
                        // add navigation drawer item onclick method here
                        new SingOutActivity().signOut();
                        Intent intentMain = new Intent(ProductDetails.this, LogInActivity.class);
                        startActivity(intentMain);
                        finish();
                        break;
                }
                return false;
            }
        });
    }

    public void updateStatusBarColor(String color) {
        // Color must be in hexadecimal format
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }
}
