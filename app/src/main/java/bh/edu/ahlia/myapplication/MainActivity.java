package bh.edu.ahlia.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends Activity {

    private ListView lviewColleges;
    private ArrayAdapter<String> listAdapter;

    public final static String EXTRA_MESSAGE ="bn.edu.ahlia.myapplication.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        lviewColleges = (ListView) findViewById( R.id.lviewColleges );
        String[] colleges = new String[] {"College of IT","College of Engineeing","College of Arts, Science and Education",
                "College of Business and Finance","College of Medical and Health Sciencs"
        ,"College of Graduate studied and Research"};
        ArrayList<String> collegeList = new ArrayList<String>();
        collegeList.addAll( Arrays.asList(colleges) );
        listAdapter = new ArrayAdapter<String>(this, R.layout.customer, collegeList  );
        lviewColleges.setAdapter( listAdapter );

        lviewColleges.setOnItemClickListener( new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String item = ((TextView) view).getText().toString();
               // Toast.makeText( getBaseContext(),item,Toast.LENGTH_SHORT ).show();

                Intent io = new Intent( getApplicationContext(), DisplayMessageActivity.class );
                io.putExtra(EXTRA_MESSAGE, item );
                startActivity( io );


            }

        } );






    }
}
