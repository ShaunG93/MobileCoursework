package com.mobile.coursework;

import android.os.Bundle;
import android.app.Activity;
import android.app.Dialog;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.CameraPosition.Builder;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.GoogleMap.OnMarkerClickListener;
import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.app.ListActivity;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends Activity implements OnMarkerClickListener, OnClickListener {
	
	//These declare the specific positions,the Lat and Lng values are used to 
	//specify the position of each location on googles map.
	private final LatLng LOCATION_GLASGOW = new LatLng(55.871459, -4.250443);		
	private final LatLng LOCATION_SECC = new LatLng(55.860983, -4.287504);
	private final LatLng LOCATION_CELTIC_PARK = new LatLng(55.851613,-4.206074);
	private final LatLng LOCATION_HAMPDEN_PARK = new LatLng(55.825576,-4.251927);
	private final LatLng LOCATION_EMIRATES_ARENA = new LatLng(55.846976,-4.207016);
	private final LatLng LOCATION_IBROX_STADIUM = new LatLng(55.85348,-4.309047);
	private final LatLng LOCATION_CATHKIN_BIKE = new LatLng(55.795974,-4.223306);
	
	//These declare the locations of the last 10 countries to host the Games, the 
	//Lat and Lng values are used in the same way as above
	private final LatLng LOCATION_DELHI = new LatLng(28.806174,77.076645);
	private final LatLng LOCATION_MELBOURNE = new LatLng(-37.805444,144.96417);
	private final LatLng LOCATION_MANCHESTER = new LatLng(53.482325,-2.245545);
	private final LatLng LOCATION_LUMPUR = new LatLng(3.143259,101.687973);
	private final LatLng LOCATION_VICTORIA = new LatLng(48.429884,-123.364846);
	private final LatLng LOCATION_AUCKLAND = new LatLng(-36.79609,174.7641560);
	private final LatLng LOCATION_EDINBURGH = new LatLng(55.958426,-3.188996);
	private final LatLng LOCATION_BRISBANE = new LatLng(-27.468526,153.023559);
	private final LatLng LOCATION_EDMONTON = new LatLng(53.554994,-113.491945);
	private final LatLng LOCATION_CHRISTCHURCH = new LatLng(53.554994,-113.491945);
	
	//This uses the GoogleMap class to declare a new map
	private GoogleMap map; 
	
	static final String[] items = {"Delhi, India","Melbourne, Australia", "Manchester, England", "Kuala Lumpur, Malaysia", "Victoria, Canada","Auckland, New Zealand", "Edinburgh, Scotland", "Brisbane, Australia","Edmonton, Canada", "Christchurch, New Zealand"};
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		map = ((MapFragment)getFragmentManager().findFragmentById(R.id.my_map)).getMap();
		map.setOnMarkerClickListener(this);
		
	
		//This .addMarker functions will create a new marker to be placed at the locations
		//already defined above, the position references link to the LatLng methods above
		//which is where the co-ordinates are taken from. The title has also been defined
		//and will be used from reference later in the onMarkerClick method.
		map.addMarker(new MarkerOptions()
		.position(LOCATION_GLASGOW)
		.title("Start")
		);
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_SECC)
		.title("SECC")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.boxing_gloves)));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_CELTIC_PARK)
		.title("CELTIC PARK"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_HAMPDEN_PARK)
		.title("HAMPDEN PARK")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.athletics)));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_EMIRATES_ARENA)
		.title("EMIRATES ARENA")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.badminton)));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_IBROX_STADIUM)
		.title("IBROX STADIUM")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.rugby)));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_CATHKIN_BIKE)
		.title("CATHKIN BRAES BIKE TRACK")
		.icon(BitmapDescriptorFactory.fromResource(R.drawable.cycling)));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_DELHI)
		.title("DELHI, INDIA"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_MELBOURNE)
		.title("MELBOURNE, AUSTRAILIA"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_MANCHESTER)
		.title("MANCHESTER, ENGLAND"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_LUMPUR)
		.title("KUALA LUMPUR, MALAYSIA"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_VICTORIA)
		.title("VICTORIA, CANADA"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_AUCKLAND)
		.title("AUCKLAND, NEW ZEALAND"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_EDINBURGH)
		.title("EDINBURGH, SCOTLAND"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_BRISBANE)
		.title("BRISBANE, AUSTRALIA"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_EDMONTON)
		.title("EDMONTON, CANADA"));
		
		map.addMarker(new MarkerOptions()
		.position(LOCATION_CHRISTCHURCH)
		.title("CHRISTCHURCH, NEW ZEALAND"));	
	}

	//This method will be called whenever a marker on the map is clicked,
	//it takes the title of the markers and uses them in an if statement
	//to uniquely identify each marker. Each if statement makes it so that when a 
	//marker is clicked, a dialog box will appear.
	@Override
	public boolean onMarkerClick(final Marker marker){
		String title = marker.getTitle();
		if("SECC".equals(title)){
			//Each marker will has it's own dialog box created, the message attribute is used
			//to display unique information for each marker relating to information about the 
			//location
			new AlertDialog.Builder(this)
		    .setTitle("SECC Precinct")
		    .setMessage("Events: Boxing, Gymnastics, Judo, Netball, Wrestling, Weightlifting   Address:Exhibition Way, Glasgow G3 8YW")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("Start".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("GLASGOW COMMONWEALTH GAMES 2014")
		    .setMessage("Welcome")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if("CELTIC PARK".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("CELTIC PARK")
		    .setMessage("Home to the world famous Celtic Football Club and location of the Commonwealth Games Opening Ceremony!")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("HAMPDEN PARK".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("HAMPDEN PARK")
		    .setMessage("Formerly known as the worlds largest stadium, Hampden Park will play home to Track and Field Athletic events during the Games" +
		    		"EVENTS: Athletics")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("EMIRATES ARENA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("EMIRATES ARENA")
		    .setMessage("Newly built and located just across the road from Celtic Park, the Emirates Arena will play host to the badminton and cycling events of the Games")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("IBROX STADIUM".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("IBROX STADIUM")
		    .setMessage("Home to Rangers Football Club, this stadium will host the Rugby Sevens events")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("CATHKIN BRAES BIKE TRACK".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("CATHKIN BRAES MOUNTAIN BIKE TRACK")
		    .setMessage("This wild track will take host to the Mountain Bike events of the games.")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("DELHI, INDIA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("DELHI, INDIA")
		    .setMessage("Year: 2010, Medals won by Scotland: 26")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("MELBOURNE, AUSTRALIA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("MELBOURNE, AUSTRAILIA")
		    .setMessage("Year: 2006, Medals won by Scotland: 29")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("MANCHESTER, ENGLAND".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("MANCHESTER, ENGLAND")
		    .setMessage("Year: 2002, Medals won by Scotland: 29")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("KUALA LUMPUR, MALAYSIA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("KUALA LUMPUR, MALAYSIA")
		    .setMessage("Year: 1998, Medals won by Scotland: 12")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("VICTORIA, CANADA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("VICTORIA, CANADA")
		    .setMessage("Year: 1994, Medals won by Scotland: 20")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("AUCKLAND, NEW ZEALAND".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("AUCKLAD, NEW ZEALAND")
		    .setMessage("Year: 1990, Medals won by Scotland: 22")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("EDINBURGH, SCOTLAND".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("EDINBURGH, SCOTLAND")
		    .setMessage("Year: 1986, Medals won by Scotland: 33")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("BRISBANE, AUSTRALIA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("BRISBANE, AUSTRALIA")
		    .setMessage("Year: 1982, Medals won by Scotland: 26")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("EDMONTON, CANADA".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("EDMONTON, CANADA")
		    .setMessage("Year: 1978, Medals won by Scotland: 14")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		else if ("CHRISTCHURCH, NEW ZEALAND".equals(title)){
			new AlertDialog.Builder(this)
		    .setTitle("CHRISTCHURCH, NEW ZEALAND")
		    .setMessage("Year: 1974, Medals won by Scotland: 19")			   
		    .setNegativeButton("close", new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) { 
		            // do nothing
		        }
		     }).show();}
		return false;
	}
	
	
	//This method will detect when the "Normal View" button is clicked, it then
	//
	public void onClick(View v){
		if(v.getId() == R.id.normalView){
			
			//Creates a toast message when the button is clicked to let the user know the map
			//is changing view
			Toast.makeText(getApplicationContext(), "CHANGING VIEW", Toast.LENGTH_SHORT).show();
			
			//Will change the map type to the default normal view
			map.setMapType(GoogleMap.MAP_TYPE_NORMAL);
			
			//This declares that b1 is the Normal View button, this is then used to disable the button
			//as the Normal View is already selected and the button is useless until the view is changed again
			Button b1 = (Button) findViewById(R.id.normalView);
			b1.setOnClickListener(this);
			b1.setEnabled(false);
			
			//This delcares that b2 is the Satellite View button, this is then used to enable the button when
			//the Normal View button is clicked. As the map type will no longer be the satellite view and the 
			//button needs to clickable now.
			Button b2 = (Button) findViewById(R.id.satView);
			b2.setOnClickListener(this);
			b2.setEnabled(true);
			
		}
		if(v.getId()== R.id.satView){
			
			Toast.makeText(getApplicationContext(), "CHANGING VIEW", Toast.LENGTH_SHORT).show();
			//GoogleMapOptions options = new GoogleMapOptions();
			
			//Will change the map type to googles satellite view
			map.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
			
			//Similarly this declares b1 and b2 again, performs the opposite and enables the Normal View button
			//when the Satellite View button has been selected. The Satellite View button is disabled as once
			//again the button becomes useless when the map type is already satellite 
			Button b1 = (Button) findViewById(R.id.normalView);
			b1.setOnClickListener(this);
			b1.setEnabled(true);
			
			Button b2 = (Button) findViewById(R.id.satView);
			b2.setOnClickListener(this);
			b2.setEnabled(false);
		}
		if(v.getId() == R.id.last10){
			final AlertDialog levelDialog;
			
			AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Select country");
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
				
				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					//DO NOTHING HERE
				}
			});
            builder.setSingleChoiceItems(items, -1, new DialogInterface.OnClickListener() {
            
            	public void onClick(DialogInterface dialog, int item) {
               
                
	                switch(item)
	                {
	                    case 0:	                            
	                    		CameraUpdate update = CameraUpdateFactory.newLatLng(LOCATION_DELHI);
	                    		map.animateCamera(update);
	                             break;
	                    case 1:	                            
	                    		CameraUpdate update1 = CameraUpdateFactory.newLatLng(LOCATION_MELBOURNE);
	                    		map.animateCamera(update1);
	                            break;
	                    case 2:	                           
	                    		CameraUpdate update2 = CameraUpdateFactory.newLatLng(LOCATION_MANCHESTER);
	                    		map.animateCamera(update2);
	                            break;
	                    case 3:	                                
	                    		CameraUpdate update3 = CameraUpdateFactory.newLatLng(LOCATION_LUMPUR);
	                    		map.animateCamera(update3);
	                            break;
	                    case 4:	                    		
	                    		CameraUpdate update4 = CameraUpdateFactory.newLatLng(LOCATION_VICTORIA);
	                    		map.animateCamera(update4);
	                    case 5:	                    	
	                    		CameraUpdate update5 = CameraUpdateFactory.newLatLng(LOCATION_AUCKLAND);
	                    		map.animateCamera(update5);
	                    case 6:	                    	
	                    		CameraUpdate update6 = CameraUpdateFactory.newLatLng(LOCATION_EDINBURGH);
	                    		map.animateCamera(update6);
	                    case 7: 	                    		
	                    		CameraUpdate update7 = CameraUpdateFactory.newLatLng(LOCATION_BRISBANE);
	                    		map.animateCamera(update7);
	                    case 8:	    
	                    		CameraUpdate update8 = CameraUpdateFactory.newLatLng(LOCATION_EDMONTON);
	                    		map.animateCamera(update8);
	                    case 9:
	                    		CameraUpdate update9 = CameraUpdateFactory.newLatLng(LOCATION_CHRISTCHURCH);
	                    		map.animateCamera(update9);
	                }
                 
                }
            });
            levelDialog = builder.create();
            levelDialog.show();
            
		
			
			
		}
	}
	
}


	
	

