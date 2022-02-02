package org.o7planning.smsBomber;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSION_REQUEST_CODE_SEND_SMS = 1;

    private static final String LOG_TAG = "AndroidExample";

    private EditText editTextPhoneNumber;
    private EditText editTextMessage;

    private Button buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.editTextPhoneNumber = (EditText) this.findViewById(R.id.editText_phoneNumber);
        this.editTextMessage = (EditText) this.findViewById(R.id.editText_message);

        this.buttonSend = (Button) this.findViewById(R.id.button_send);

        this.buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askPermissionAndSendSMS();
            }
        });
        recupContacts();
    }

    public void recupContacts(){
        // access au contenu mobile
        ContentResolver contentResolver = this.getContentResolver();
        // récuperation des contacts dans un curseur
        Cursor cursor = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                new String[]{ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE,
                ContactsContract.CommonDataKinds.Phone.NUMBER}, null, null, null);
        if (cursor == null) {
            Log.d("recup","***** erreur curseur");
        }else{
            EditText txtContacts = (EditText) findViewById(R.id.txtContacts);
            //parcour des contacts
            while(cursor.moveToNext()){
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_ALTERNATIVE));
                @SuppressLint("Range") String phone = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                // Affichage de la récupération
                txtContacts.setText(txtContacts.getText().toString() + "\n\r" + name + " : " + phone);

            }
            //fermer le curseur
            cursor.close();
        }
    }

    private void askPermissionAndSendSMS() {

        if (android.os.Build.VERSION.SDK_INT >=  android.os.Build.VERSION_CODES.M) {

            // vvérifier si SMS permission
            int sendSmsPermisson = ActivityCompat.checkSelfPermission(this,
                    Manifest.permission.SEND_SMS);

            if (sendSmsPermisson != PackageManager.PERMISSION_GRANTED) {
            // pas la permission, invitez l'utilisateur.
                this.requestPermissions(
                        new String[]{Manifest.permission.SEND_SMS},
                        MY_PERMISSION_REQUEST_CODE_SEND_SMS
                );
                return;
            }
        }
        this.sendSMS_by_smsManager();
    }


    public class SMSReceiver extends BroadcastReceiver {

        private SharedPreferences preferences;

        @Override
        public void onReceive(Context context, Intent intent) {
            // TODO Auto-generated method stub

            if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
                Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
                SmsMessage[] msgs = null;
                String msg_from;
                if (bundle != null){
                    //---retrieve the SMS message received---
                    try{
                        Object[] pdus = (Object[]) bundle.get("pdus");
                        msgs = new SmsMessage[pdus.length];
                        for(int i=0; i<msgs.length; i++){
                            msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                            msg_from = msgs[i].getOriginatingAddress();
                            String msgBody = msgs[i].getMessageBody();
                        }
                    }catch(Exception e){
//                            Log.d("Exception caught",e.getMessage());
                    }
                }
            }
        }
    }

    private void sendSMS_by_smsManager()  {

        String phoneNumber = this.editTextPhoneNumber.getText().toString();
        String message = this.editTextMessage.getText().toString();
        // Envoie de
        for (int i=0; i<10;i++) {
            try {
                // Obtenir l'instance par defaultt du SmsManager
                SmsManager smsManager = SmsManager.getDefault();
                // l'envoi
                smsManager.sendTextMessage(phoneNumber,
                        null,
                        message,
                        null,
                        null);

                Log.i( LOG_TAG,"Votre SMS est envoyé ! ");
                Toast.makeText(getApplicationContext(),"Votre SMS est envoyé 10 fois !",
                        Toast.LENGTH_LONG).show();
            } catch (Exception ex) {
                Log.e( LOG_TAG,"Votre sms a échoué...", ex);
                Toast.makeText(getApplicationContext(),"Votre sms a échoué.. " + ex.getMessage(),
                        Toast.LENGTH_LONG).show();
                ex.printStackTrace();
            }
        }

    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //
        switch (requestCode) {
            case MY_PERMISSION_REQUEST_CODE_SEND_SMS: {


                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    Log.i( LOG_TAG,"Permission accordée!");
                    Toast.makeText(this, "Permission accordée!", Toast.LENGTH_LONG).show();

                    this.sendSMS_by_smsManager();
                }
                else {
                    Log.i( LOG_TAG,"Permission refusé!");
                    Toast.makeText(this, "Permission refusée!", Toast.LENGTH_LONG).show();
                }
                break;
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MY_PERMISSION_REQUEST_CODE_SEND_SMS) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "Action OK", Toast.LENGTH_LONG).show();
            } else if (resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "Action annulé", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Action échoué", Toast.LENGTH_LONG).show();
            }
        }
    }
}