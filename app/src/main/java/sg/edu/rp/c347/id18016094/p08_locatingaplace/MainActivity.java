package sg.edu.rp.c347.id18016094.p08_locatingaplace;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity {

    Button btn1, btn2, btn3;
    private GoogleMap map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getSupportFragmentManager();
        SupportMapFragment mapFragment = (SupportMapFragment)
                fm.findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback(){
            @Override
            public void onMapReady(GoogleMap googleMap) {
                map = googleMap;
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.ACCESS_FINE_LOCATION);
                if (permissionCheck == PermissionChecker.PERMISSION_GRANTED) {
                    map.setMyLocationEnabled(true);
                } else {
                    Log.e("GMap - Permission", "GPS access has not been granted");
                    ActivityCompat.requestPermissions(MainActivity.this,
                            new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
                }
                LatLng poi_Admiralty = new LatLng(1.461708, 103.813500);
                Marker ad = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Admiralty)
                        .title("North HQ")
                        .snippet("Block 333, Admiralty Ave 3, 765654")
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
                
                LatLng poi_Orchard = new LatLng(1.300542, 103.841226);
                Marker rp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Orchard)
                        .title("Central HQ")
                        .snippet("Block 3A, Orchard Ave 3, 134542 "));
                        //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));

                LatLng poi_Tampinese = new LatLng(1.3500557, 103.934452);
                Marker tp = map.addMarker(new
                        MarkerOptions()
                        .position(poi_Tampinese)
                        .title("East HQ")
                        .snippet("Block 555, Tampines Ave 3, 287788 "));
                //.icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_launcher)));
            }
        });

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng pos = new LatLng(1.461708, 103.813500);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                map.moveCamera(update);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng pos = new LatLng(1.300542, 103.841226);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                map.moveCamera(update);
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng pos = new LatLng(1.3500557, 103.934452);
                CameraUpdate update = CameraUpdateFactory.newLatLngZoom(pos, 15);
                map.moveCamera(update);
            }
        });
    }
}
