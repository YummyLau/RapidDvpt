package yummylau.feature.bean;

import com.google.gson.annotations.SerializedName;

import yummylau.feature.data.local.db.entity.StatusEntity;
import yummylau.feature.data.local.db.entity.UserEntity;
import yummylau.feature.data.remote.result.ApiResult;


/**
 * 微博评论
 * Email yummyl.lau@gmail.com
 * Created by yummylau on 2017/11/15.
 */

public class Comment extends ApiResult {

    //评论创建时间
    @SerializedName("created_at")
    public String createdAt;

    //评论的ID
    @SerializedName("id")
    public int id;

    //评论的内容
    @SerializedName("source")
    public String source;

    //评论的来源
    @SerializedName("text")
    public String text;

    //评论作者的用户信息字段
    @SerializedName("user")
    public UserEntity user;

    //评论的MID
    @SerializedName("mid")
    public String mid;

    //字符串型的评论ID
    @SerializedName("idstr")
    public String idstr;

    //评论的微博信息字段
    @SerializedName("status")
    public StatusEntity status;

    //评论来源评论，当本评论属于对另一评论的回复时返回此字段
    @SerializedName("reply_comment")
    public String replyComment;
}
