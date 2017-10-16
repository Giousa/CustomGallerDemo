package com.zmm.customairwavedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.zmm.customairwavedemo.galler.GallerAdapter;
import com.zmm.customairwavedemo.galler.GallerViewPager;
import com.zmm.customairwavedemo.galler.ScaleGallerTransformer;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.galler_view_pager)
    GallerViewPager mGallerViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        initView();
    }

    private void initView() {
        mGallerViewPager.setAdapter(new Adapter());
        mGallerViewPager.setPageTransformer(true, new ScaleGallerTransformer());
        mGallerViewPager.setSliderTransformDuration(1500, null);
    }

    class Adapter extends GallerAdapter {

        @Override
        public int getGallerSize() {
            return 3;
        }

        @Override
        public View getItemView(int position) {
            System.out.println("position = "+position);
            if(position == 1){
                return LayoutInflater.from(MainActivity.this).inflate(R.layout.item_gallery1, null);
            }else if(position == 2){
                return LayoutInflater.from(MainActivity.this).inflate(R.layout.item_gallery2, null);
            }else {
                return LayoutInflater.from(MainActivity.this).inflate(R.layout.item_gallery3, null);
            }

        }
    }
}
