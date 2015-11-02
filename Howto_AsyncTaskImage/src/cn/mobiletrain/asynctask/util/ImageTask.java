package cn.mobiletrain.asynctask.util;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.ImageView;

public class ImageTask extends AsyncTask<String, Void, Bitmap> {
	
	ImageView iv;

	public ImageTask(ImageView iv) {
		super();
		this.iv = iv;
	}

	@Override
	protected Bitmap doInBackground(String... params) {
		// TODO Auto-generated method stub
		String url = params[0];
		Bitmap bitmap = HttpUtils.getBitmapFromUrl(url);
		return bitmap;
	}

	@Override
	protected void onPostExecute(Bitmap result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		iv.setImageBitmap(result);
	}
	
	

}
