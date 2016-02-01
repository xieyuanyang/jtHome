/**
 *
 */
package com.shendu.jthome.model;

/**
 * @author Erich Lee
 * @desc <pre>

 * 私信
 * </pre>
 * @Date Mar 20, 2013
 */
public class Message {

    private String content;

    private boolean isSend;

    private boolean isReplay;//判断是回复消息还是评论消息

    private String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isSend() {
        return isSend;
    }

    public void setSend(boolean isSend) {
        this.isSend = isSend;
    }

    public boolean isReplay() {
        return isReplay;
    }

    public void setIsReplay(boolean isReplay) {
        this.isReplay = isReplay;
    }
}
