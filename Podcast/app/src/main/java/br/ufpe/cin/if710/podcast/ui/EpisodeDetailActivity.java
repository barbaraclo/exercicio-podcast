package br.ufpe.cin.if710.podcast.ui;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import br.ufpe.cin.if710.podcast.R;
import br.ufpe.cin.if710.podcast.ui.adapter.XmlFeedAdapter;

public class EpisodeDetailActivity extends Activity {
    TextView texto;
    TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_episode_detail);

         texto = (TextView) findViewById(R.id.titulo);
         data = (TextView) findViewById(R.id.data);

        
        texto.setText(this.getIntent().getExtras().getString(XmlFeedAdapter.TITULO));
        data.setText(this.getIntent().getExtras().getString(XmlFeedAdapter.DATA));

    }
}
