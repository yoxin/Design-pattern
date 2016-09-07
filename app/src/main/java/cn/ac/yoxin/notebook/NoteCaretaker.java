package cn.ac.yoxin.notebook;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengyoxin on 16-9-7.
 */
public class NoteCaretaker {

    private static final int MAX = 30;
    List<Memoto> mMemotos = new ArrayList<Memoto>(MAX);
    int mIndex = 0;

    public void saveMemoto(Memoto memoto) {
        if (mMemotos.size() >= MAX) {
            mMemotos.remove(0);
        }
        mMemotos.add(memoto);
        mIndex = mMemotos.size() - 1;
    }

    public Memoto getPreMemoto() {
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

    public Memoto getNextMemoto() {
        mIndex = mIndex < mMemotos.size() - 1 ? ++mIndex : mIndex;
        return mMemotos.get(mIndex);
    }

    private NoteCaretaker() {};

    private static NoteCaretaker mInstance = new NoteCaretaker();

    public static NoteCaretaker getInstance() {
        return mInstance;
    }
}
