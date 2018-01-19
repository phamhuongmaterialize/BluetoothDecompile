package com.example.phamt.bluetoothdecompile.vo;

/**
 * Created by phamt on 2018/01/16.
 */

import java.io.File;
import java.util.List;

public class UserInfoVo
{
    private int collect;
    private String crossFollow;
    private String deviceCount;
    private String email;
    private String emailConfirmYN;
    private String follower;
    private int followerCnt;
    private String following;
    private int followingCnt;
    private String gcmRegId;
    private String joinType;
    private String lastLoginType;
    private String locale;
    private int loginUserId = -1;
    private int maxCollectionCnt;
    private int maxDeviceCnt;
    private String newPassword;
    private String nickname;
    private String password;
    private File profileImg;
    private String profileImgName;
    private String profileImgPath;
    private int profileImgSize;
    private String profileImgType;
    private String pushMsgYN;
    private String searchYN;
    private int shared;
    private List<SNSUserVo> snsList;
    private String snsType;
    private String type;
    private int upload;
    private String userAgreementYN;
    private int userId = -1;

    public UserInfoVo() {}

    public UserInfoVo(int paramInt, String paramString1, String paramString2, String paramString3)
    {
        this.userId = paramInt;
        this.nickname = paramString1;
        this.crossFollow = paramString2;
        this.profileImgPath = paramString3;
    }

    public int getCollect()
    {
        return this.collect;
    }

    public String getCrossFollow()
    {
        return this.crossFollow;
    }

    public String getDeviceCount()
    {
        return this.deviceCount;
    }

    public String getEmail()
    {
        return this.email;
    }

    public String getEmailConfirmYN()
    {
        return this.emailConfirmYN;
    }

    public String getFollower()
    {
        return this.follower;
    }

    public int getFollowerCnt()
    {
        return this.followerCnt;
    }

    public String getFollowing()
    {
        return this.following;
    }

    public int getFollowingCnt()
    {
        return this.followingCnt;
    }

    public String getGcmRegId()
    {
        return this.gcmRegId;
    }

    public String getJoinType()
    {
        return this.joinType;
    }

    public String getLastLoginType()
    {
        return this.lastLoginType;
    }

    public String getLocale()
    {
        return this.locale;
    }

    public int getLoginUserId()
    {
        return this.loginUserId;
    }

    public int getMaxCollectionCnt()
    {
        return this.maxCollectionCnt;
    }

    public int getMaxDeviceCnt()
    {
        return this.maxDeviceCnt;
    }

    public String getNewPassword()
    {
        return this.newPassword;
    }

    public String getNickname()
    {
        return this.nickname;
    }

    public String getPassword()
    {
        return this.password;
    }

    public File getProfileImg()
    {
        return this.profileImg;
    }

    public String getProfileImgName()
    {
        return this.profileImgName;
    }

    public String getProfileImgPath()
    {
        return this.profileImgPath;
    }

    public int getProfileImgSize()
    {
        return this.profileImgSize;
    }

    public String getProfileImgType()
    {
        return this.profileImgType;
    }

    public String getPushMsgYN()
    {
        return this.pushMsgYN;
    }

    public String getSearchYN()
    {
        return this.searchYN;
    }

    public int getShared()
    {
        return this.shared;
    }

    public List<SNSUserVo> getSnsList()
    {
        return this.snsList;
    }

    public String getSnsType()
    {
        return this.snsType;
    }

    public String getType()
    {
        return this.type;
    }

    public int getUpload()
    {
        return this.upload;
    }

    public String getUserAgreementYN()
    {
        return this.userAgreementYN;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public void setCollect(int paramInt)
    {
        this.collect = paramInt;
    }

    public void setCrossFollow(String paramString)
    {
        this.crossFollow = paramString;
    }

    public void setDeviceCount(String paramString)
    {
        this.deviceCount = paramString;
    }

    public void setEmail(String paramString)
    {
        this.email = paramString;
    }

    public void setEmailConfirmYN(String paramString)
    {
        this.emailConfirmYN = paramString;
    }

    public void setFollower(String paramString)
    {
        this.follower = paramString;
    }

    public void setFollowerCnt(int paramInt)
    {
        this.followerCnt = paramInt;
    }

    public void setFollowing(String paramString)
    {
        this.following = paramString;
    }

    public void setFollowingCnt(int paramInt)
    {
        this.followingCnt = paramInt;
    }

    public void setGcmRegId(String paramString)
    {
        this.gcmRegId = paramString;
    }

    public void setJoinType(String paramString)
    {
        this.joinType = paramString;
    }

    public void setLastLoginType(String paramString)
    {
        this.lastLoginType = paramString;
    }

    public void setLocale(String paramString)
    {
        this.locale = paramString;
    }

    public void setLoginUserId(int paramInt)
    {
        this.loginUserId = paramInt;
    }

    public void setMaxCollectionCnt(int paramInt)
    {
        this.maxCollectionCnt = paramInt;
    }

    public void setMaxDeviceCnt(int paramInt)
    {
        this.maxDeviceCnt = paramInt;
    }

    public void setNewPassword(String paramString)
    {
        this.newPassword = paramString;
    }

    public void setNickname(String paramString)
    {
        this.nickname = paramString;
    }

    public void setPassword(String paramString)
    {
        this.password = paramString;
    }

    public void setProfileImg(File paramFile)
    {
        this.profileImg = paramFile;
    }

    public void setProfileImgName(String paramString)
    {
        this.profileImgName = paramString;
    }

    public void setProfileImgPath(String paramString)
    {
        this.profileImgPath = paramString;
    }

    public void setProfileImgSize(int paramInt)
    {
        this.profileImgSize = paramInt;
    }

    public void setProfileImgType(String paramString)
    {
        this.profileImgType = paramString;
    }

    public void setPushMsgYN(String paramString)
    {
        this.pushMsgYN = paramString;
    }

    public void setSearchYN(String paramString)
    {
        this.searchYN = paramString;
    }

    public void setShared(int paramInt)
    {
        this.shared = paramInt;
    }

    public void setSnsList(List<SNSUserVo> paramList)
    {
        this.snsList = paramList;
    }

    public void setSnsType(String paramString)
    {
        this.snsType = paramString;
    }

    public void setType(String paramString)
    {
        this.type = paramString;
    }

    public void setUpload(int paramInt)
    {
        this.upload = paramInt;
    }

    public void setUserAgreementYN(String paramString)
    {
        this.userAgreementYN = paramString;
    }

    public void setUserId(int paramInt)
    {
        this.userId = paramInt;
    }
}
