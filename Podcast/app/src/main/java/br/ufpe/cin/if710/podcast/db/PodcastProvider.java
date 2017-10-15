package br.ufpe.cin.if710.podcast.db;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class PodcastProvider extends ContentProvider {
    private PodcastDBHelper podcast;
    public PodcastProvider() {
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // TODO: Implement this to handle requests for the MIME type of the data
        // at the given URI.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        final SQLiteDatabase database = podcast.getReadableDatabase();
        long data = database.insert(PodcastDBHelper.DATABASE_TABLE, null, values);
        uri = Uri.withAppendedPath(PodcastProviderContract.EPISODE_LIST_URI, Long.toString(data));

        return uri;

    }

    @Override
    public boolean onCreate() {
        Context context = this.getContext();
        this.podcast = PodcastDBHelper.getInstance(context);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        return podcast.getReadableDatabase().query(PodcastDBHelper.DATABASE_TABLE, projection, selection, selectionArgs, null, null, sortOrder);

    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        return podcast.getWritableDatabase().update(PodcastDBHelper.DATABASE_TABLE, values, selection, selectionArgs);
    }
}
