package bus.itgds.khadametdz.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

public class ScanningBareCodeActivity extends AppCompatActivity implements ZBarScannerView.ResultHandler  {

    private ZBarScannerView scannerView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        scannerView = new ZBarScannerView(this);
        setContentView(scannerView);
    }

    @Override
    public void handleResult(Result result) {
        Toast.makeText(ScanningBareCodeActivity.this,result.getContents()+"",Toast.LENGTH_LONG).show();
        scannerView.resumeCameraPreview(this);
        Log.e("RES",result.getContents()+"");
    }

    @Override
    protected void onResume() {
        super.onResume();
        scannerView.setResultHandler(ScanningBareCodeActivity.this);
        scannerView.startCamera();
    }

    @Override
    protected void onStop() {
        super.onStop();
        scannerView.stopCamera();
    }
}
