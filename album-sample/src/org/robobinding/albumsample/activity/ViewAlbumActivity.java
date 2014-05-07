package org.robobinding.albumsample.activity;

import org.robobinding.albumsample.R;
import org.robobinding.albumsample.model.Album;
import org.robobinding.albumsample.presentationmodel.ViewAlbumPresentationModel;
import org.robobinding.binder.Binders;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

/**
 *
 * @since 1.0
 * @author Cheng Wei
 * @author Robert Taylor
 */
public class ViewAlbumActivity extends Activity {
	public static final String ALBUM_ID = "album_id";

	private ViewAlbumPresentationModel presentationModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		Intent intent = getIntent();
		long albumId = intent.getLongExtra(ALBUM_ID, Album.NO_ID);

		presentationModel = new ViewAlbumPresentationModel(this, albumId);
		Binders.bindWithoutPreInitializingViews(this,
				R.layout.view_album_activity, presentationModel);
	}

	@Override
	protected void onResume() {
		super.onResume();
		presentationModel.refresh();
	}
}
