package com.example.lab8;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }
        City city = cities.get(position);
        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);
        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());
        return view;
    }

    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }

    // TDD Methods
    public boolean hasCity(String cityName) {
        for (City city : cities) {
            if (city.getCityName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteCity(String cityName) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return cities.removeIf(city -> city.getCityName().equals(cityName));
        }
        return false;
    }

    public int countCities() {
        return cities.size(); // This could be redundant given getCount() exists, but implemented as per instruction
    }
}
