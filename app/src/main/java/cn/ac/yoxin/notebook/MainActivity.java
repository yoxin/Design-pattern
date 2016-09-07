package cn.ac.yoxin.notebook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.note_et)
    NoteEditText noteEt;
    @BindView(R.id.note_undo)
    Button noteUndo;
    @BindView(R.id.note_save)
    Button noteSave;
    @BindView(R.id.note_redo)
    Button noteRedo;

    NoteCaretaker caretaker = NoteCaretaker.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        noteSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                caretaker.saveMemoto(noteEt.createMemotoForEditeText());
                makeToast("保存：");
            }
        });
        noteUndo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteEt.restoreEt(caretaker.getPreMemoto());
                makeToast("撤销：");
            }
        });
        noteRedo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                noteEt.restoreEt(caretaker.getNextMemoto());
                makeToast("重做：");
            }
        });
    }

    private void makeToast(String msg) {
        Toast.makeText(this, msg + noteEt.getText().toString() + ",光标位置：" + noteEt.getSelectionStart(), Toast.LENGTH_LONG).show();
    }

}
