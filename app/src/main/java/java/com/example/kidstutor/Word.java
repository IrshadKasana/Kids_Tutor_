package java.com.example.kidstutor;

/**
 * Created by Irshad Kasana on 7/16/2020.
 */

public class Word {
    private String mDefaulttranslation ;
    private String mMiwoktranslation;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int mImageResourseId= NO_IMAGE_PROVIDED;
    private int  mAudioResourseId;


    public Word(String defaulttranslation,String miwoktranslation,int audioResourseId){
        mDefaulttranslation=defaulttranslation;
        mMiwoktranslation=miwoktranslation;
        mAudioResourseId=audioResourseId;


    }
    public Word(String defaulttranslation,String miwoktranslation, int imageResourseId,int audioResourseId){
        mDefaulttranslation=defaulttranslation;
        mMiwoktranslation=miwoktranslation;
        mImageResourseId=imageResourseId;
        mAudioResourseId=audioResourseId;

    }
    public String getmDefaulttranslation(){
        return mDefaulttranslation;
    }
    public String getmMiwoktranslation(){
        return mMiwoktranslation;
    }
    public int getmResourseId(){
        return mImageResourseId;
    }
    public boolean hasImage(){
        return mImageResourseId!=NO_IMAGE_PROVIDED;
    }
    public int getmAudioResourseId(){
        return mAudioResourseId;
    }

}
