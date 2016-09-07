package cn.ac.yoxin.draw;

import android.graphics.Path;

/**
 * Created by zhengyoxin on 16-9-6.
 */
public interface IBrush {
    void down(Path path, float x, float y);
    void move(Path path, float x, float y);
    void up(Path path, float x, float y);
}
