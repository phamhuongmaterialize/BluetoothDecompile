package com.example.phamt.bluetoothdecompile.vo;

/**
 * Created by phamt on 2018/01/16.
 */

import java.io.File;
import java.util.ArrayList;

public class ContentVo
{
    private String authorName;
    private int badgeCnt;
    private int catId;
    private String catName;
    private boolean checkedState;
    private String comment;
    private int commentCnt;
    private File contentFile;
    private int contentFileSize;
    private String contentFromSns;
    private int contentId = -1;
    private String contentIdJson;
    private String contentInfo;
    private String contentPath;
    private int contentPathId;
    private String contentPathIdJson;
    private String contentRegistType;
    private String contentType;
    private String contentsURLtoJson;
    private String copyrightYN;
    private int deviceContentsId;
    private int deviceId;
    private String deviceIdToString;
    private int downloadCnt;
    private String downloadContentYN;
    private int downloadPayPrice = 0;
    private int drawablePath;
    private String hashTag;
    private String licenseType;
    private int likeCnt;
    private int likeStatus;
    private String likeYN;
    private String limitedContentYN;
    private String limitedNumber;
    private int limitedPayPrice;
    private String locale;
    private int loginUserId = -1;
    private String makeYear;
    private String meterial;
    private String mimeType;
    private String nickName;
    private int orderNum;
    private String originFileNm;
    private int originPayPrice;
    private int pageNum;
    private int parentCatId;
    private ArrayList<ContentVo> pathList;
    private String pathListToString;
    private String payKind;
    private String preViewPath;
    private int printPayPrice;
    private String profileImgName;
    private String profileImgPath;
    private String profileImgSize;
    private String publicYN;
    private String registDt;
    private int rownum = -1;
    private String saveFileNm;
    private String size;
    private String snsId;
    private int stramingPayPrice;
    private String streamingContentYN;
    private String thumbnailPath;
    private String title;
    private int userId = -1;

    public ContentVo() {}

    public ContentVo(int paramInt)
    {
        this.drawablePath = paramInt;
    }

    public ContentVo(int paramInt1, int paramInt2)
    {
        this.contentId = paramInt1;
        this.contentPathId = paramInt2;
    }

    public ContentVo(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString1, int paramInt5, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt6, String paramString7, int paramInt7, String paramString8, int paramInt8, int paramInt9, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15)
    {
        this.contentId = paramInt1;
        this.userId = paramInt2;
        this.orderNum = paramInt3;
        this.deviceContentsId = paramInt4;
        this.contentInfo = paramString1;
        this.likeCnt = paramInt5;
        this.hashTag = paramString2;
        this.profileImgPath = paramString3;
        this.originFileNm = paramString4;
        this.thumbnailPath = paramString5;
        this.mimeType = paramString6;
        this.contentPathId = paramInt6;
        this.locale = paramString7;
        this.deviceId = paramInt7;
        this.authorName = paramString8;
        this.stramingPayPrice = paramInt8;
        this.downloadPayPrice = paramInt9;
        this.title = paramString9;
        this.size = paramString10;
        this.meterial = paramString11;
        this.makeYear = paramString12;
        this.downloadContentYN = paramString13;
        this.streamingContentYN = paramString14;
        this.contentRegistType = paramString15;
    }

    public ContentVo(int paramInt1, int paramInt2, String paramString)
    {
        this.contentId = paramInt1;
        this.contentPathId = paramInt2;
        this.thumbnailPath = paramString;
    }

    public ContentVo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3)
    {
        this.contentId = paramInt1;
        this.contentPathId = paramInt2;
        this.thumbnailPath = paramString1;
        this.mimeType = paramString2;
        this.contentType = paramString3;
    }

    public ContentVo(int paramInt1, int paramInt2, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt3, String paramString7, int paramInt4, String paramString8, int paramInt5, int paramInt6, int paramInt7, int paramInt8, String paramString9, String paramString10, String paramString11, String paramString12, String paramString13, String paramString14, String paramString15, String paramString16, String paramString17)
    {
        this.contentId = paramInt1;
        this.userId = paramInt2;
        this.snsId = paramString1;
        this.contentType = paramString2;
        this.contentFromSns = paramString3;
        this.contentPath = paramString4;
        this.copyrightYN = paramString5;
        this.licenseType = paramString6;
        this.deviceContentsId = paramInt3;
        this.contentInfo = paramString7;
        this.catId = paramInt4;
        this.catName = paramString8;
        this.parentCatId = paramInt5;
        this.likeCnt = paramInt6;
        this.likeStatus = paramInt7;
        this.commentCnt = paramInt8;
        this.likeYN = paramString9;
        this.hashTag = paramString10;
        this.nickName = paramString11;
        this.profileImgPath = paramString12;
        this.comment = paramString13;
        this.thumbnailPath = paramString14;
        this.preViewPath = paramString15;
        this.pathListToString = paramString16;
        this.mimeType = paramString17;
    }

    public ContentVo(int paramInt1, int paramInt2, boolean paramBoolean, String paramString)
    {
        this.contentId = paramInt1;
        this.contentPathId = paramInt2;
        this.checkedState = paramBoolean;
        this.thumbnailPath = paramString;
    }

    public ContentVo(int paramInt1, int paramInt2, boolean paramBoolean, String paramString1, String paramString2)
    {
        this.contentId = paramInt1;
        this.deviceContentsId = paramInt2;
        this.checkedState = paramBoolean;
        this.contentPath = paramString1;
        this.thumbnailPath = paramString2;
    }

    public ContentVo(int paramInt1, String paramString1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, String paramString3)
    {
        this.contentId = paramInt1;
        this.contentPath = paramString1;
        this.contentPathId = paramInt2;
        this.deviceContentsId = paramInt3;
        this.checkedState = paramBoolean;
        this.thumbnailPath = paramString2;
        this.mimeType = paramString3;
    }

    public ContentVo(int paramInt, String paramString1, String paramString2)
    {
        this.contentPathId = paramInt;
        this.thumbnailPath = paramString1;
        this.mimeType = paramString2;
    }

    public ContentVo(int paramInt, String paramString1, String paramString2, String paramString3)
    {
        this.contentPathId = paramInt;
        this.thumbnailPath = paramString1;
        this.mimeType = paramString2;
        this.contentType = paramString3;
    }

    public ContentVo(String paramString)
    {
        this.likeYN = paramString;
    }

    public String getAuthorName()
    {
        return this.authorName;
    }

    public int getBadgeCnt()
    {
        return this.badgeCnt;
    }

    public int getCatId()
    {
        return this.catId;
    }

    public String getCatName()
    {
        return this.catName;
    }

    public String getComment()
    {
        return this.comment;
    }

    public int getCommentCnt()
    {
        return this.commentCnt;
    }

    public File getContentFile()
    {
        return this.contentFile;
    }

    public int getContentFileSize()
    {
        return this.contentFileSize;
    }

    public String getContentFromSns()
    {
        return this.contentFromSns;
    }

    public int getContentId()
    {
        return this.contentId;
    }

    public String getContentIdJson()
    {
        return this.contentIdJson;
    }

    public String getContentInfo()
    {
        return this.contentInfo;
    }

    public String getContentPath()
    {
        return this.contentPath;
    }

    public int getContentPathId()
    {
        return this.contentPathId;
    }

    public String getContentPathIdJson()
    {
        return this.contentPathIdJson;
    }

    public String getContentRegistType()
    {
        return this.contentRegistType;
    }

    public String getContentType()
    {
        return this.contentType;
    }

    public String getContentsURLtoJson()
    {
        return this.contentsURLtoJson;
    }

    public String getCopyrightYN()
    {
        return this.copyrightYN;
    }

    public int getDeviceContentsId()
    {
        return this.deviceContentsId;
    }

    public int getDeviceId()
    {
        return this.deviceId;
    }

    public String getDeviceIdToString()
    {
        return this.deviceIdToString;
    }

    public int getDownloadCnt()
    {
        return this.downloadCnt;
    }

    public String getDownloadContentYN()
    {
        return this.downloadContentYN;
    }

    public int getDownloadPayPrice()
    {
        return this.downloadPayPrice;
    }

    public int getDrawablePath()
    {
        return this.drawablePath;
    }

    public String getHashTag()
    {
        return this.hashTag;
    }

    public String getLicenseType()
    {
        return this.licenseType;
    }

    public int getLikeCnt()
    {
        return this.likeCnt;
    }

    public int getLikeStatus()
    {
        return this.likeStatus;
    }

    public String getLikeYN()
    {
        return this.likeYN;
    }

    public String getLimitedContentYN()
    {
        return this.limitedContentYN;
    }

    public String getLimitedNumber()
    {
        return this.limitedNumber;
    }

    public int getLimitedPayPrice()
    {
        return this.limitedPayPrice;
    }

    public String getLocale()
    {
        return this.locale;
    }

    public int getLoginUserId()
    {
        return this.loginUserId;
    }

    public String getMakeYear()
    {
        return this.makeYear;
    }

    public String getMeterial()
    {
        return this.meterial;
    }

    public String getMimeType()
    {
        return this.mimeType;
    }

    public String getNickName()
    {
        return this.nickName;
    }

    public int getOrderNum()
    {
        return this.orderNum;
    }

    public String getOriginFileNm()
    {
        return this.originFileNm;
    }

    public int getOriginPayPrice()
    {
        return this.originPayPrice;
    }

    public int getPageNum()
    {
        return this.pageNum;
    }

    public int getParentCatId()
    {
        return this.parentCatId;
    }

    public ArrayList<ContentVo> getPathList()
    {
        return this.pathList;
    }

    public String getPathListToString()
    {
        return this.pathListToString;
    }

    public String getPayKind()
    {
        return this.payKind;
    }

    public String getPreViewPath()
    {
        return this.preViewPath;
    }

    public int getPrintPayPrice()
    {
        return this.printPayPrice;
    }

    public String getProfileImgName()
    {
        return this.profileImgName;
    }

    public String getProfileImgPath()
    {
        return this.profileImgPath;
    }

    public String getProfileImgSize()
    {
        return this.profileImgSize;
    }

    public String getPublicYN()
    {
        return this.publicYN;
    }

    public String getRegistDt()
    {
        return this.registDt;
    }

    public int getRownum()
    {
        return this.rownum;
    }

    public String getSaveFileNm()
    {
        return this.saveFileNm;
    }

    public String getSize()
    {
        return this.size;
    }

    public String getSnsId()
    {
        return this.snsId;
    }

    public int getStramingPayPrice()
    {
        return this.stramingPayPrice;
    }

    public String getStreamingContentYN()
    {
        return this.streamingContentYN;
    }

    public String getThumbnailPath()
    {
        return this.thumbnailPath;
    }

    public String getTitle()
    {
        return this.title;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public boolean isCheckedState()
    {
        return this.checkedState;
    }

    public void setAuthorName(String paramString)
    {
        this.authorName = paramString;
    }

    public void setBadgeCnt(int paramInt)
    {
        this.badgeCnt = paramInt;
    }

    public void setCatId(int paramInt)
    {
        this.catId = paramInt;
    }

    public void setCatName(String paramString)
    {
        this.catName = paramString;
    }

    public void setCheckedState(boolean paramBoolean)
    {
        this.checkedState = paramBoolean;
    }

    public void setComment(String paramString)
    {
        this.comment = paramString;
    }

    public void setCommentCnt(int paramInt)
    {
        this.commentCnt = paramInt;
    }

    public void setContentFile(File paramFile)
    {
        this.contentFile = paramFile;
    }

    public void setContentFileSize(int paramInt)
    {
        this.contentFileSize = paramInt;
    }

    public void setContentFromSns(String paramString)
    {
        this.contentFromSns = paramString;
    }

    public void setContentId(int paramInt)
    {
        this.contentId = paramInt;
    }

    public void setContentIdJson(String paramString)
    {
        this.contentIdJson = paramString;
    }

    public void setContentInfo(String paramString)
    {
        this.contentInfo = paramString;
    }

    public void setContentPath(String paramString)
    {
        this.contentPath = paramString;
    }

    public void setContentPathId(int paramInt)
    {
        this.contentPathId = paramInt;
    }

    public void setContentPathIdJson(String paramString)
    {
        this.contentPathIdJson = paramString;
    }

    public void setContentRegistType(String paramString)
    {
        this.contentRegistType = paramString;
    }

    public void setContentType(String paramString)
    {
        this.contentType = paramString;
    }

    public void setContentsURLtoJson(String paramString)
    {
        this.contentsURLtoJson = paramString;
    }

    public void setCopyrightYN(String paramString)
    {
        this.copyrightYN = paramString;
    }

    public void setDeviceContentsId(int paramInt)
    {
        this.deviceContentsId = paramInt;
    }

    public void setDeviceId(int paramInt)
    {
        this.deviceId = paramInt;
    }

    public void setDeviceIdToString(String paramString)
    {
        this.deviceIdToString = paramString;
    }

    public void setDownloadCnt(int paramInt)
    {
        this.downloadCnt = paramInt;
    }

    public void setDownloadContentYN(String paramString)
    {
        this.downloadContentYN = paramString;
    }

    public void setDownloadPayPrice(int paramInt)
    {
        this.downloadPayPrice = paramInt;
    }

    public void setDrawablePath(int paramInt)
    {
        this.drawablePath = paramInt;
    }

    public void setHashTag(String paramString)
    {
        this.hashTag = paramString;
    }

    public void setLicenseType(String paramString)
    {
        this.licenseType = paramString;
    }

    public void setLikeCnt(int paramInt)
    {
        this.likeCnt = paramInt;
    }

    public void setLikeStatus(int paramInt)
    {
        this.likeStatus = paramInt;
    }

    public void setLikeYN(String paramString)
    {
        this.likeYN = paramString;
    }

    public void setLimitedContentYN(String paramString)
    {
        this.limitedContentYN = paramString;
    }

    public void setLimitedNumber(String paramString)
    {
        this.limitedNumber = paramString;
    }

    public void setLimitedPayPrice(int paramInt)
    {
        this.limitedPayPrice = paramInt;
    }

    public void setLocale(String paramString)
    {
        this.locale = paramString;
    }

    public void setLoginUserId(int paramInt)
    {
        this.loginUserId = paramInt;
    }

    public void setMakeYear(String paramString)
    {
        this.makeYear = paramString;
    }

    public void setMeterial(String paramString)
    {
        this.meterial = paramString;
    }

    public void setMimeType(String paramString)
    {
        this.mimeType = paramString;
    }

    public void setNickName(String paramString)
    {
        this.nickName = paramString;
    }

    public void setOrderNum(int paramInt)
    {
        this.orderNum = paramInt;
    }

    public void setOriginFileNm(String paramString)
    {
        this.originFileNm = paramString;
    }

    public void setOriginPayPrice(int paramInt)
    {
        this.originPayPrice = paramInt;
    }

    public void setPageNum(int paramInt)
    {
        this.pageNum = paramInt;
    }

    public void setParentCatId(int paramInt)
    {
        this.parentCatId = paramInt;
    }

    public void setPathList(ArrayList<ContentVo> paramArrayList)
    {
        this.pathList = paramArrayList;
    }

    public void setPathListToString(String paramString)
    {
        this.pathListToString = paramString;
    }

    public void setPayKind(String paramString)
    {
        this.payKind = paramString;
    }

    public void setPreViewPath(String paramString)
    {
        this.preViewPath = paramString;
    }

    public void setPrintPayPrice(int paramInt)
    {
        this.printPayPrice = paramInt;
    }

    public void setProfileImgName(String paramString)
    {
        this.profileImgName = paramString;
    }

    public void setProfileImgPath(String paramString)
    {
        this.profileImgPath = paramString;
    }

    public void setProfileImgSize(String paramString)
    {
        this.profileImgSize = paramString;
    }

    public void setPublicYN(String paramString)
    {
        this.publicYN = paramString;
    }

    public void setRegistDt(String paramString)
    {
        this.registDt = paramString;
    }

    public void setRownum(int paramInt)
    {
        this.rownum = paramInt;
    }

    public void setSaveFileNm(String paramString)
    {
        this.saveFileNm = paramString;
    }

    public void setSize(String paramString)
    {
        this.size = paramString;
    }

    public void setSnsId(String paramString)
    {
        this.snsId = paramString;
    }

    public void setStramingPayPrice(int paramInt)
    {
        this.stramingPayPrice = paramInt;
    }

    public void setStreamingContentYN(String paramString)
    {
        this.streamingContentYN = paramString;
    }

    public void setThumbnailPath(String paramString)
    {
        this.thumbnailPath = paramString;
    }

    public void setTitle(String paramString)
    {
        this.title = paramString;
    }

    public void setUserId(int paramInt)
    {
        this.userId = paramInt;
    }
}
