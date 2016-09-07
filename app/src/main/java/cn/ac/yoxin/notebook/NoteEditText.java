package cn.ac.yoxin.notebook;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by zhengyoxin on 16-9-7.
 */
public class NoteEditText extends EditText {
    public NoteEditText(Context context) {
        super(context);
    }

    public NoteEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NoteEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void restoreEt(Memoto memoto) {
        setText(memoto.text);
        setSelection(memoto.cursor);
    }

    public Memoto createMemotoForEditeText() {
        Memoto memoto = new Memoto();
        memoto.text = getText().toString();
        memoto.cursor = getSelectionStart();
        return memoto;
    }
}
