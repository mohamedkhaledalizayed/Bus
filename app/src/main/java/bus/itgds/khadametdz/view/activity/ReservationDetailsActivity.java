package bus.itgds.khadametdz.view.activity;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import net.glxn.qrgen.android.QRCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

import bus.itgds.khadametdz.R;
import bus.itgds.khadametdz.databinding.ActivityReservationDetailsBinding;

public class ReservationDetailsActivity extends AppCompatActivity {

    private boolean isProfile = false;
    private ActivityReservationDetailsBinding binding;
    private String id = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        id = getIntent().getStringExtra("id");
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reservation_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Reservation Details");



        if (id != null){
            if (id.equalsIgnoreCase("0") || id.equalsIgnoreCase("2") || id.equalsIgnoreCase("4")) {
                binding.cancel.setText("Map");
            } else if (id.equalsIgnoreCase("3")) {
                binding.cancel.setVisibility(View.GONE);
                binding.download.setVisibility(View.GONE);
            } else if (id.equalsIgnoreCase("5")) {
                binding.cancel.setVisibility(View.GONE);
                binding.download.setVisibility(View.GONE);
            }
        }
        isProfile = getIntent().getBooleanExtra("isProfile", false);
        if (isProfile) {
            binding.cancel.setVisibility(View.GONE);
            binding.download.setVisibility(View.GONE);
        }

        binding.cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (id != null){
                    if (id.equalsIgnoreCase("0") || id.equalsIgnoreCase("2") || id.equalsIgnoreCase("4")) {
                        Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse("http://maps.google.com/maps?saddr=31.048578,29.9567804&daddr=30.048578,30.9567804"));
                        startActivity(intent);
                    }
                }
            }
        });
        /*
         * Generate bitmap from the text provided,
         * The QR code can be saved using other methods such as stream(), file(), to() etc.
         * Check out the GitHub README page for the same
         * (https://github.com/kenglxn/QRGen)
         * */
        final Bitmap bitmap = QRCode.from("Developed by Mohamed khaled ali zayed").withSize(1000, 1000).bitmap();
        binding.bareCodeImage.setImageBitmap(bitmap);



        binding.download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(ReservationDetailsActivity.this, ScanningBareCodeActivity.class));
                File out = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                out = new File(out, "IMAGE_"+new Date()+".jpg");
                image_url=out.getAbsolutePath();
                ImageData dat=new ImageData(image_url,bitmap);
                new SavePicture().execute(dat);

            }
        });
    }

    private class SavePicture extends AsyncTask<ImageData, Void, String> {

        @Override
        protected String doInBackground(ImageData... imageData) {

            OutputStream fOut = null;
            File file = new File(imageData[0].url);
            try {
                fOut = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            imageData[0].bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
            try {
                fOut.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fOut.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                MediaStore.Images.Media.insertImage(getContentResolver(),file.getAbsolutePath(),file.getName(),file.getName());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            return file.getAbsolutePath();
        }

        @Override
        protected void onPostExecute(String url) {
            Toast.makeText(ReservationDetailsActivity.this,url,Toast.LENGTH_LONG).show();
        }
    }


    private String image_url;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reservation_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else if (item.getItemId() == R.id.share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_TEXT,
                    "Hi friend, let's travel.I found this this trip from A to B: https://play.google.com/store/apps/details?id=com.google.android.apps.plus");
            sendIntent.setType("text/plain");
            startActivity(sendIntent);
        }
        return super.onOptionsItemSelected(item);
    }


}
