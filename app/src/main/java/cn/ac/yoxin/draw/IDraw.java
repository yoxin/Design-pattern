package cn.ac.yoxin.draw;

import android.graphics.Canvas;

/**
 * Created by zhengyoxin on 16-9-6.
 */
public interface IDraw {
    void draw(Canvas canvas);
    void undo();
}
