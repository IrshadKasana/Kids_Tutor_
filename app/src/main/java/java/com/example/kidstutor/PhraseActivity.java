package java.com.example.kidstutor;

/**
 * Created by Irshad Kasana on 7/16/2020.
 */


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {

                //@Override
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                            focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        releaseMediaPlayer();

                    }
                }
            };
    private MediaPlayer.OnCompletionListener mcompleteListener =new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mp) {
            releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.words_list);
        mAudioManager=(AudioManager)getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("minto wuksus","where are you going?",R.raw.phrase_where_are_you_going));
        words.add(new Word("tena oyeaauna","what is your name?",R.raw.phrase_what_is_your_name));
        words.add(new Word("oyaseaset","my name is ",R.raw.phrase_my_name_is));
        words.add(new Word("mishaksas","how are you feeling? ",R.raw.phrase_how_are_you_feeling));
        words.add(new Word("kuchi achit","im feeling good",R.raw.phrase_im_feeling_good));
        words.add(new Word("aanasa'a","are you coming?",R.raw.phrase_are_you_coming));
        words.add(new Word("haa' anaam","yes im comming",R.raw.phrase_yes_im_coming));
        words.add(new Word("kuchi achit","come here",R.raw.phrase_come_here));
        words.add(new Word("tena oyeaauna","lets go ",R.raw.phrase_lets_go));
        words.add(new Word("wuksus","lets go",R.raw.phrase_lets_go));

        //ArrayAdapter<Word> itemAdapter = new ArrayAdapter<Word>(this,R.layout.list_item);

        WordAdapter adapter =new WordAdapter(this,words,R.color.category_phrases);
        ListView listView= (ListView)findViewById(R.id.list);
        listView.setAdapter(adapter);
        //listView.setAdapter(itemAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word word = words.get(position);
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener ,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                    releaseMediaPlayer();
                    mMediaPlayer= MediaPlayer.create(PhraseActivity.this,word.getmAudioResourseId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mcompleteListener);}
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer(){
        if(mMediaPlayer!=null){
            mMediaPlayer.release();
            mMediaPlayer=null;
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }




}

