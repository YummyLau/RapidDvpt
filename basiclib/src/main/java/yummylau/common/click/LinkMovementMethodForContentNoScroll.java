package yummylau.common.click;

import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.widget.TextView;

/**
 * 点击长文的时候，内容不滑动
 * Created by g8931 on 2017/11/20.
 */

public class LinkMovementMethodForContentNoScroll extends LinkMovementMethod {

    @Override
    public boolean onTouchEvent(TextView widget, Spannable buffer, MotionEvent event) {
        int action = event.getAction();

        if (action == MotionEvent.ACTION_UP ||
                action == MotionEvent.ACTION_DOWN) {
            int x = (int) event.getX();
            int y = (int) event.getY();

            x -= widget.getTotalPaddingLeft();
            y -= widget.getTotalPaddingTop();

            x += widget.getScrollX();
            y += widget.getScrollY();

            Layout layout = widget.getLayout();
            int line = layout.getLineForVertical(y);
            int off = layout.getOffsetForHorizontal(line, x);

            ClickableSpan[] link = buffer.getSpans(off, off, ClickableSpan.class);

            if (link.length != 0) {
                if (action == MotionEvent.ACTION_UP) {
                    link[0].onClick(widget);
                } else if (action == MotionEvent.ACTION_DOWN) {
//                    Selection.setSelection(buffer,
//                            buffer.getSpanStart(link[0]),
//                            buffer.getSpanEnd(link[0]));
                }
            } else {
                Selection.removeSelection(buffer);
            }
            return true;
        } else {
            return super.onTouchEvent(widget, buffer, event);
        }

    }


    public static LinkMovementMethodForContentNoScroll getInstance() {
        if (null == sInstance) {
            sInstance = new LinkMovementMethodForContentNoScroll();
        }
        return sInstance;
    }

    private static LinkMovementMethodForContentNoScroll sInstance;
}
